package de.multimedia.emulation.emil.integration.demo.model;

import de.multimedia.emulation.emil.integration.model.object.ArchiveFile;
import de.multimedia.emulation.emil.integration.model.object.FileType;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class DemoFile implements ArchiveFile {

  private String fileId;
  private String fileOriginalName;
  private String url;
  private String type;

  @Override
  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  @Override
  public String getFileOriginalName() {
    return fileOriginalName;
  }

  public void setFileOriginalName(String fileOriginalName) {
    this.fileOriginalName = fileOriginalName;
  }

  @Override
  public URL getUrl() {
    try {
      return new URL(url);
    } catch (MalformedURLException exception) {
      throw new RuntimeException(exception);
    }
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public FileType getType() {
    return FileType.valueOf(type.toUpperCase());
  }

  public void setType(String type) {
    this.type = type;
  }


}
