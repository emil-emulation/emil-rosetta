package de.multimedia.emulation.emil.integration.rosetta.model.pid;

import de.multimedia.emulation.emil.integration.model.pid.AbstractPid;
import de.multimedia.emulation.emil.integration.model.pid.AbstractPid;
import java.util.regex.Pattern;

/**
 * Persistent identifier for a Rosetta IEs.
 */
public class IEPid extends AbstractPid {

  private static Pattern PATTERN = Pattern.compile("^IE\\d+$");

  public IEPid(String pid) {
    super(pid);
    if (!isValid(pid)) {
      throw new IllegalArgumentException(
          "Invalid IEPid (needs to be of form 'IE<number>', but was '" + pid + "').");
    }
  }

  @Override
  public String toString() {
    return "IEPid(" + getPid() + ")";
  }

  public static boolean isValid(String pid) {
    return PATTERN.matcher(pid).matches();
  }

}
