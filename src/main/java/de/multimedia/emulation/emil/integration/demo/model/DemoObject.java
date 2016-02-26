package de.multimedia.emulation.emil.integration.demo.model;

import de.multimedia.emulation.emil.integration.model.object.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@XmlRootElement(name = "ArchiveObject")
public class DemoObject implements ArchiveObject {

  private final String id;

  private final List<? extends ArchiveFile> files;

  public DemoObject(String id, List<? extends ArchiveFile> files) {
    this.id = id;
    this.files = files;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<? extends ArchiveFile> getFiles() {
    return files;
  }

}
