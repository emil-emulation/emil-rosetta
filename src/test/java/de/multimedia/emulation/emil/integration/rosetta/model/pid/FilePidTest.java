package de.multimedia.emulation.emil.integration.rosetta.model.pid;

import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Marcus Bitzl marcus.bitzl@bsb-muenchen.de
 */
public class FilePidTest {

  private FilePid filePid;

  @Before
  public void setUp() throws Exception {
    filePid = new FilePid("FL1231273");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorFailsIfPidIsNull() {
    new FilePid(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorFailsIfPidIsEmpty() {
    new FilePid("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorRejectsPidNotStartingWithFL() {
    new FilePid("4728364");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorRejectsPidContainingLetters() {
    new FilePid("FL47X283X64X");
  }

  @Test
  public void testToString() throws Exception {
    assertThat(filePid.toString(), is("FilePid(FL1231273)"));
  }

  @Test
  public void testGetPid() throws Exception {
    assertThat(filePid.getPid(), is("FL1231273"));
  }

  @Test
  public void testEquals() throws Exception {
    assertThat(filePid.equals(new FilePid("FL1231273")), is(true));
  }

  @Test
  public void testEqualsDoesNotMatchDifferent() throws Exception {
    assertThat(filePid.equals(new FilePid("FL14781273")), is(not(true)));
  }

  @Test
  public void testHashCode() throws Exception {
    FilePid other = new FilePid("FL1231273");
    assertThat(filePid.hashCode(), is(other.hashCode()));
  }

  @Test
  public void testHashCodeDiffersForDifferent() throws Exception {
    FilePid other = new FilePid("FL48981273");
    assertThat(filePid.hashCode(), is(not(other.hashCode())));
  }
}

