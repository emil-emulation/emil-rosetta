package de.multimedia.emulation.emil.integration.rosetta.service;

import com.exlibris.dps.sdk.pds.PdsClient;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PdsSessionAdapterTest {

  @Test(expected = IllegalArgumentException.class)
  public void pdsHandleShouldNotBeNull() {
    new PdsSessionAdapter(null, mock(PdsClient.class));
  }

  @Test(expected = IllegalArgumentException.class)
  public void pdsClientShouldNotBeNull() {
    new PdsSessionAdapter("ajdhajkhdakjsjdkasj", null);
  }

  @Test
  public void logoutShouldUsePdsHandle() throws Exception {
    PdsClient pdsClient = mock(PdsClient.class);
    PdsSessionAdapter session = new PdsSessionAdapter("XXXXXXXXXX", pdsClient);
    session.close();
    verify(pdsClient).logout("XXXXXXXXXX");
  }
}
