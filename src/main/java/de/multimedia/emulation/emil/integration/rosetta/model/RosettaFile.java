/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.rosetta.model;

import de.multimedia.emulation.emil.integration.model.object.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.object.FileType;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RosettaFile implements ArchiveFile {

  private String filePid;

  private String fileOriginalName;

  private FileType type;

  private URL url;

  @Override
  public String getFileId() {
    return filePid;
  }

  @Override
  public String getFileOriginalName() {
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
    this.filePid = filePid.getPid();
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
    } else if (hasExtension("img")) {
      this.type = FileType.IMG;
    }
  }

  private boolean hasExtension(String extension) {
    return fileOriginalName.toLowerCase().endsWith(extension);
  }

}
