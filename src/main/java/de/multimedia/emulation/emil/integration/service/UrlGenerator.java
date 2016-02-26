/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
package de.multimedia.emulation.emil.integration.service;

import de.multimedia.emulation.emil.integration.rosetta.model.pid.FilePid;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@Service
public class UrlGenerator {

  private final String urlTemplate;

  @Autowired
  public UrlGenerator(@Value("${urls.deliveryTemplate}") String urlTemplate) {
    this.urlTemplate = urlTemplate;
  }

  public URL generateUrl(FilePid filePid) {
    try {
      return new URL(urlTemplate.replace("[identifier]", filePid.getPid()));
    } catch (MalformedURLException exception) {
      throw new RuntimeException("Could not create URL - actually this should not be possible.", exception);
    }
  }

}
