package de.multimedia.emulation.emil.integration.controller;

import de.multimedia.emulation.emil.integration.model.ArchiveObject;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import de.multimedia.emulation.emil.integration.rosetta.service.RosettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@RestController
public class EmilController {
  
  private final RosettaService rosettaService;
  
  @Autowired
  public EmilController(RosettaService rosettaService) {
    this.rosettaService = rosettaService;
  }
  
  /**
   *
   * @param id The IE-Pid for the desired object.
   * @return A representation of the object and all suitable files.
   * @throws Exception if the request fails.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ArchiveObject get(@PathVariable("id") String id) throws Exception {
    return rosettaService.getArchiveObject(new IEPid(id));
  }
  
}
