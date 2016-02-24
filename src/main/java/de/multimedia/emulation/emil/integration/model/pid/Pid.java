package de.multimedia.emulation.emil.integration.model.pid;

/**
 * Common interface for all persistent identifiers.
 */
public interface Pid {

  /**
   *
   * @return A string representation of the identifier as used by Rosetta.
   */
  String getPid();

}
