package de.multimedia.emulation.emil.integration.rosetta.service;


import de.multimedia.emulation.emil.integration.model.pid.Pid;
import de.multimedia.emulation.emil.integration.service.ArchiveService;
import de.multimedia.emulation.emil.integration.service.UrlGenerator;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import de.multimedia.emulation.emil.integration.rosetta.model.RosettaFile;
import de.multimedia.emulation.emil.integration.rosetta.model.RosettaObject;
import de.multimedia.emulation.emil.integration.rosetta.model.pds.PdsSession;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import de.multimedia.emulation.emil.integration.rosetta.soap.IEUpdateClient;
import de.multimedia.emulation.emil.integration.rosetta.soap.IeFileExtractionContentHandler;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@Service
public class RosettaService implements ArchiveService<IEPid> {

  private final IEUpdateClient updateClient;

  private final PdsService pdsService;

  private final UrlGenerator urlGenerator;
  
  @Autowired
  public RosettaService(IEUpdateClient updateClient, PdsService pdsService, UrlGenerator urlGenerator) {
    this.updateClient = updateClient;
    this.pdsService = pdsService;
    this.urlGenerator = urlGenerator;
  }

  public List<RosettaFile> filesFor(IEPid iePid) throws Exception {
    String xml = xmlFor(iePid);
    
    try (FileWriter writer = new FileWriter(iePid.getPid() + ".xml")) {
      writer.write(xml);
    }
    
    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser parser = parserFactory.newSAXParser();
    IeFileExtractionContentHandler fileExtractionContentHandler = new IeFileExtractionContentHandler(urlGenerator);
    parser.parse(new InputSource(new StringReader(xml)), fileExtractionContentHandler);
    return fileExtractionContentHandler.getFiles();
  }

  @Override
  public ArchiveObject getArchiveObject(IEPid iePid) throws Exception {
    RosettaObject archiveObject = new RosettaObject(iePid);
    archiveObject.setFiles(filesFor(iePid));
    return archiveObject;
  }

  @Override
  public IEPid getPid(String token) {
    return new IEPid(token);
  }

  public String xmlFor(IEPid iePid) throws Exception {
    try (PdsSession session = pdsService.login()) {
      return updateClient.getXml(session, iePid);
    }
  }

}
