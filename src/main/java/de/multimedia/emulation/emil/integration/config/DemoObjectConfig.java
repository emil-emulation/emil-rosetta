package de.multimedia.emulation.emil.integration.config;

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
public class DemoObjectConfig implements ArchiveObject {

  private String objectId;

  private List<DemoFile> files;

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  @Override
  public List<DemoFile> getFiles() {
    return files;
  }

  public void setFiles(List<DemoFile> files) {
    this.files = files;
  }

  @Override
  public String getId() {
    return objectId;
  }

}
