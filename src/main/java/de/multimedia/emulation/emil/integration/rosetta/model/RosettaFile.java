/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.rosetta.model;

import de.multimedia.emulation.emil.integration.model.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.FileType;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import java.net.URL;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class RosettaFile implements ArchiveFile {

  private FilePid filePid;
  
  private String fileOriginalName;
  
  private FileType type;

  private URL url;
  
  @Override
  public String getFileId() {
    if (filePid != null) {
      return filePid.getPid();  
    }
    return null;
  }

  @Override
  public String getFileOrignalName() {
    return fileOriginalName;
  }

  @Override
  public FileType getType() {
    return type;
  }

  @Override
  public URL getUrl() {
    return url;
  }

  public void setFilePid(FilePid filePid) {
    this.filePid = filePid;
  }

  public void setFileOriginalName(String fileOriginalName) {
    this.fileOriginalName = fileOriginalName;
    adjustFiletype();
  }

  public void setUrl(URL url) {
    this.url = url;
  }
  
  public void adjustFiletype() {
    if (hasExtension("iso")) {
      this.type = FileType.ISO;
    }
    else if (hasExtension("img")) {
      this.type = FileType.IMG;
    }
  }
  
  private boolean hasExtension(String extension) {
    return fileOriginalName.toLowerCase().endsWith(extension);
  }
  
}
