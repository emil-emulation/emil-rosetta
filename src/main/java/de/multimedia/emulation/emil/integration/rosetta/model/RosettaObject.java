/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.rosetta.model;

import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@XmlRootElement(name = "ArchiveObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class RosettaObject implements ArchiveObject {

  private String id;

  private List<RosettaFile> files;

  protected RosettaObject() {}

  public RosettaObject(IEPid iePid) {
    setIEPid(iePid);
    this.files = new ArrayList<>();
  }

  public void setIEPid(IEPid iePid) {
    this.id = iePid.getPid();
  }

  public void setFiles(List<RosettaFile> files) {
    this.files = new ArrayList<>();
    for (RosettaFile file : files) {
      this.files.add(file);
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<RosettaFile> getFiles() {
    return files;
  }

}
