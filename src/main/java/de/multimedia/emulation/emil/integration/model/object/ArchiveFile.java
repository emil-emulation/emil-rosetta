package de.multimedia.emulation.emil.integration.model.object;

import java.net.URL;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public interface ArchiveFile {

  /**
   *
   * @return The File id as in archive.
   */
  String getFileId();

  /**
   * 
   * @return The original filename (may be different in storage).
   */
  String getFileOriginalName();

  /**
   * 
   * @return An storage media type as understood by EMiL (e.g. ISO or IMG).
   */
  FileType getType();

  /**
   * 
   * @return The URL where the file can be accessed.
   */
  URL getUrl();

}
