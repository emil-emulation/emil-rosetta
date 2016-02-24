package de.multimedia.emulation.emil.integration.rosetta.model.pid;

import de.multimedia.emulation.emil.integration.model.pid.AbstractPid;
import de.multimedia.emulation.emil.integration.model.pid.AbstractPid;
import java.util.regex.Pattern;

/**
 * Persistent identifier for a Rosetta file object.
 */
public class FilePid extends AbstractPid {

  private static final Pattern PATTERN = Pattern.compile("^FL\\d+$");

  public FilePid(String pid) {
    super(pid);
    if (!isValid(pid)) {
      throw new IllegalArgumentException("Invalid FilePid (needs to be of form 'FL<number>')");
    }
  }

  @Override
  public String toString() {
    return "FilePid(" + getPid() + ")";
  }

  public static boolean isValid(String pid) {
    return PATTERN.matcher(pid).matches();
  }

}
