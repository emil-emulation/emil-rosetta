package de.multimedia.emulation.emil.integration.rosetta.model.pid;

import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Marcus Bitzl marcus.bitzl@bsb-muenchen.de
 */
public class IEPidTest {

  private IEPid iePid;

  @Before
  public void setUp() throws Exception {
    iePid = new IEPid("IE1231273");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorFailsIfPidIsNull() {
    new IEPid(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorFailsIfPidIsEmpty() {
    new IEPid("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorRejectsPidNotStartingWithIE() {
    new IEPid("4728364");
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorRejectsPidContainingLetters() {
    new IEPid("IE47X283X64X");
  }

  @Test
  public void testToString() throws Exception {
    assertEquals("IEPid(IE1231273)", iePid.toString());
  }

  @Test
  public void testGetPid() throws Exception {
    assertEquals("IE1231273", iePid.getPid());
  }

  @Test
  public void testEquals() throws Exception {
    assertThat(iePid.equals(new IEPid("IE1231273")), is(true));
  }

  @Test
  public void testEqualsDoesNotMatchDifferent() throws Exception {
    assertThat(iePid.equals(new IEPid("IE14781273")), is(false));
  }

  @Test
  public void testHashCode() throws Exception {
    IEPid other = new IEPid("IE1231273");
    assertEquals(iePid.hashCode(), other.hashCode());
  }

  @Test
  public void testHashCodeDiffersForDifferent() throws Exception {
    IEPid other = new IEPid("IE48981273");
    assertThat(iePid.hashCode(), is(not(other.hashCode())));
  }
}
