package org.otw.archive;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchiveClient {

  public Work[] works;

  WebResource webResource;
  ClientResponse response;

  public ArchiveClient(String connectionUrl) {

  }

  public void connectToArchive() throws IOException {

    ClientConfig clientConfig = new DefaultClientConfig();
    Client client = Client.create(clientConfig);

    webResource = client
            .resource("http://ariana.archiveofourown.org/api/v1/works");

    works = getResponse();
  }

  public Work[] getResponse() throws IOException {
    try {
      final String string = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
      ObjectMapper mapper = new ObjectMapper();
      // Don't fail if there are properties we don't care about
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      works = mapper.readValue(string, Work[].class);
    }
    catch (Exception e) {
      System.out.println("There has been an error!" + e.getMessage());
      throw e;
    }
    return works;
  }
}
