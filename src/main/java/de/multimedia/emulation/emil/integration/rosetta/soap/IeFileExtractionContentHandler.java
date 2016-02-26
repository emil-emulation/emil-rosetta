package de.multimedia.emulation.emil.integration.rosetta.soap;

import de.multimedia.emulation.emil.integration.service.UrlGenerator;
import de.multimedia.emulation.emil.integration.rosetta.model.RosettaFile;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class IeFileExtractionContentHandler extends DefaultHandler {

  enum State {
    IGNORE, GET_ORIGINAL_NAME
  }

  private final UrlGenerator urlGenerator;
  
  private final List<RosettaFile> files;

  private RosettaFile current;

  private State state;

  public IeFileExtractionContentHandler(UrlGenerator urlGenerator) {
    this.urlGenerator = urlGenerator;
    files = new ArrayList<>();
    state = State.IGNORE;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    if ("mets:amdSec".equals(qName) && atts.getLength() == 1 && atts.getValue(0).startsWith("FL")) {
      current = new RosettaFile();
      String value = atts.getValue("ID");
      if (value.startsWith("FL")) {
        FilePid filePid = extractIdentifier(value);
        current.setFilePid(filePid);
        current.setUrl(urlGenerator.generateUrl(filePid));
      }
    } else if ("key".equals(qName) && atts.getLength() == 1 && "fileOriginalName".equals(atts.getValue(0))) {
      state = State.GET_ORIGINAL_NAME;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if ("mets:amdSec".equals(qName) && current != null) {
      files.add(current);
      current = null;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    switch (state) {
      case GET_ORIGINAL_NAME:
        String value = new String(ch, start, length);
        current.setFileOriginalName(value);
        state = State.IGNORE;
        break;
      default:
        break;
    }
  }

  private FilePid extractIdentifier(String value) {
    String[] parts = value.split("-");
    return new FilePid(parts[0]);
  }

  public List<RosettaFile> getFiles() {
    return files;
  }

}
