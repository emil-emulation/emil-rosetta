package de.multimedia.emulation.emil.integration.service;

import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import de.multimedia.emulation.emil.integration.model.pid.Pid;

/**
 * Interface for the interaction with arbitrary archive systems.
 *
 * @param <T> The persistent Identifier used with a certain archive system.
 */
public interface ArchiveService<T extends Pid> {

  /**
   * Get the ArchiveObject identified by <code>pid</code>. This method is responsible for the actual
   * interaction with the archive system.
   *
   * @param pid The identifier for the desired ArchiveObject.
   * @return The desired ArchiveObject.
   * @throws Exception if the ArchiveObject could not be retrieved.
   */
  ArchiveObject getArchiveObject(T pid) throws Exception;

  /**
   * Creates a valid identifier from a String token. This method is responsible ensure that the
   * identifier is technically correct.
   */
  T getPid(String token);
}
