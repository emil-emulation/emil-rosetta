package de.multimedia.emulation.emil.integration.controller;

import de.multimedia.emulation.emil.integration.demo.service.DemoService;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import de.multimedia.emulation.emil.integration.model.pid.Pid;
import de.multimedia.emulation.emil.integration.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@RestController
public class EmilController {

  private final ArchiveService<Pid> archiveService;

  private final DemoService demoService;

  @Autowired
  public EmilController(ArchiveService archiveService, DemoService demoService) {
    this.archiveService = archiveService;
    this.demoService = demoService;
  }

  /**
   *
   * @param id The Pid for the desired object.
   * @return A representation of the object and all suitable files.
   * @throws Exception if the request fails.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
  @ResponseBody
  public ArchiveObject get(@PathVariable("id") String id) throws Exception {
    if (demoService.isDemoObjectId(id)) {
      return demoService.getDemoObject();
    }
    return archiveService.getArchiveObject(archiveService.getPid(id));
  }

}
