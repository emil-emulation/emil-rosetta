package de.multimedia.emulation.emil.integration.demo.service;

import de.multimedia.emulation.emil.integration.demo.config.DemoConfig;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@Service
public class DemoService {

  private final DemoConfig config;

  @Autowired
  public DemoService(DemoConfig config) {
    this.config = config;
  }

  public boolean isDemoObjectId(String id) {
    return id != null && id.equals(config.getObjectId());
  }

  public ArchiveObject getDemoObject() {
    return config.getDemoObject();
  }

}
