package de.multimedia.emulation.emil.integration.service;

import de.multimedia.emulation.emil.integration.config.DemoObjectConfig;
import de.multimedia.emulation.emil.integration.model.object.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@Service
public class DemoService {

  private final DemoObjectConfig config;

  @XmlRootElement(name = "ArchiveObject")
  class DemoObject implements ArchiveObject {

    @Override
    public String getId() {
      return config.getObjectId();
    }

    @Override
    public List<? extends ArchiveFile> getFiles() {
      return config.getFiles();
    }

  }

  @Autowired
  public DemoService(DemoObjectConfig config) {
    this.config = config;
  }

  public boolean isDemoObjectId(String id) {
    return id != null && id.equals(config.getObjectId());
  }

  public ArchiveObject getDemoObject() {
    return new DemoObject();
  }

}
