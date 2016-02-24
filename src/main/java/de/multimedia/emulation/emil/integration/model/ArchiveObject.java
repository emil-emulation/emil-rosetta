package de.multimedia.emulation.emil.integration.model;

import de.multimedia.emulation.emil.integration.model.ArchiveFile;
import java.util.List;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public interface ArchiveObject {
  
  String getId();
  
  List<ArchiveFile> getFiles();
  
}
