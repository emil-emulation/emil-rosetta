/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.rosetta.model;

import de.multimedia.emulation.emil.integration.model.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.ArchiveObject;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class RosettaObject implements ArchiveObject {

  private IEPid iePid;
  
  private List<ArchiveFile> files;
  
  public RosettaObject(IEPid iePid) {
    setIEPid(iePid);
    this.files = new ArrayList<>();
  }
  
  public void setIEPid(IEPid iePid) {
    this.iePid = iePid;
  }
  
  public void setFiles(List<RosettaFile> files) {
    this.files = new ArrayList<>();
    for (RosettaFile file : files) {
      this.files.add(file);
    }
  }
  
  @Override
  public String getId() {
    return iePid.getPid();
  }

  @Override
  public List<ArchiveFile> getFiles() {
    return files;
  }

}
