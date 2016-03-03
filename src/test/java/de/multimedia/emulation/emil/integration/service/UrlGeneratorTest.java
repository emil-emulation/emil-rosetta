package de.multimedia.emulation.emil.integration.service;

import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class UrlGeneratorTest {

  @Test
  public void generateUrlShouldGenerateExpectedUrl() throws MalformedURLException {
    UrlGenerator urlGenerator = new UrlGenerator("http://example.com/DeliveryManagerServlet?dps_pid=[identifier]&dps_func=stream");
    assertThat(
        urlGenerator.generateUrl(new FilePid("FL12345")),
        is(new URL("http://example.com/DeliveryManagerServlet?dps_pid=FL12345&dps_func=stream")));
  }

}
