package de.multimedia.emulation.emil.integration.model.object;

import java.util.List;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public interface ArchiveObject {

  String getId();

  List<? extends ArchiveFile> getFiles();

}
