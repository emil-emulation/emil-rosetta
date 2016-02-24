package de.multimedia.emulation.emil.integration.rosetta.service;

import com.exlibris.dps.sdk.pds.PdsClient;
import de.multimedia.emulation.emil.integration.rosetta.model.pds.PdsSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service to handle Rosetta PdsSessions.
 */
@Service
public class PdsService {

  private final PdsClient client;

  private final String institution;
  
  private final String user;
  
  private final String password;

  /**
   * Create a new PDSService using a certain URL to contact the PDS service.
   *
   * @param url the URL of PDS service.
   * @param institution
   * @param user
   * @param password
   */
  @Autowired
  public PdsService(
      @Value("${urls.pds}") String url,
      @Value("${rosetta.institution}") String institution,
      @Value("${rosetta.username}") String user,
      @Value("${rosetta.password}") String password) {
    this.institution = institution;
    this.user = user;
    this.password = password;
    client = PdsClient.getInstance();
    client.init(url, false);
  }

  public PdsSession login() throws Exception {
    final String handle = client.login(institution, user, password);
    return new PdsSessionAdapter(handle, client);
  }

}
