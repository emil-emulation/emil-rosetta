package de.multimedia.emulation.emil.integration.rosetta.service;

import com.exlibris.dps.sdk.pds.PdsClient;
import de.multimedia.emulation.emil.integration.rosetta.model.pds.PdsSession;



/**
 * Adapter to implement a PdsSession delegating operations to ExLibris PdsClient.
 */
public class PdsSessionAdapter implements PdsSession {

    private final String pdsHandle;
    private final PdsClient pdsClient;

    PdsSessionAdapter(String pdsHandle, PdsClient pdsClient) {
        if (pdsHandle == null) {
            throw new IllegalArgumentException("PdsHandle must not be null.");
        }
        if (pdsClient == null) {
            throw new IllegalArgumentException("PdsClient must not be null.");
        }
        this.pdsHandle = pdsHandle;
        this.pdsClient = pdsClient;
    }

    @Override
    public void close() throws Exception {
        pdsClient.logout(pdsHandle);
    }

    @Override
    public String getHandle() {
        return pdsHandle;
    }
}
