package de.multimedia.emulation.emil.integration.demo.config;

import de.multimedia.emulation.emil.integration.demo.model.DemoFile;
import de.multimedia.emulation.emil.integration.demo.model.DemoObject;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@ConfigurationProperties(prefix = "demoObject")
@Configuration
public class DemoConfig {

  private String objectId;

  private List<DemoFile> files;

  public List<DemoFile> getFiles() {
    return files;
  }

  public void setFiles(List<DemoFile> files) {
    this.files = files;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public String getObjectId() {
    return objectId;
  }

  public ArchiveObject getDemoObject() {
    return new DemoObject(objectId, files);
  }

}
