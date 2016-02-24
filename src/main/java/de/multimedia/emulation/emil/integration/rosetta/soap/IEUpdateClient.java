/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.rosetta.soap;

import com.exlibris.rosetta.ieupdate.GetIE;
import com.exlibris.rosetta.ieupdate.GetIEResponse;
import com.exlibris.rosetta.ieupdate.ObjectFactory;
import de.multimedia.emulation.emil.integration.rosetta.model.pds.PdsSessionInfo;
import de.multimedia.emulation.emil.integration.rosetta.model.pid.IEPid;
import java.io.IOException;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.xml.sax.SAXException;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@Component
public class IEUpdateClient extends WebServiceGatewaySupport {

  private static final Logger LOGGER = LoggerFactory.getLogger(IEUpdateClient.class);

  @Autowired
  public IEUpdateClient(@Value("${urls.ieUpdate}") String defaultUri) {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.exlibris.rosetta.ieupdate");
    setDefaultUri(defaultUri);
    setMarshaller(marshaller);
    setUnmarshaller(marshaller);
  }

  @SuppressWarnings("unchecked")
  protected GetIEResponse getIEResponse(PdsSessionInfo session, IEPid iePid) {
    ObjectFactory objectFactory = new ObjectFactory();
    GetIE request = new GetIE();
    request.setIePid(iePid.getPid());
    request.setPdsHandle(session.getHandle());
    LOGGER.info("Requesting IE metadata.");
    JAXBElement<GetIEResponse> response = (JAXBElement<GetIEResponse>) getWebServiceTemplate()
        .marshalSendAndReceive(objectFactory.createGetIE(request), new SoapActionCallback("getIE"));
    return response.getValue();
  }

  public String getXml(PdsSessionInfo session, IEPid iePid) throws IOException, SAXException {
    return getIEResponse(session, iePid).getGetIE();
  }

}

