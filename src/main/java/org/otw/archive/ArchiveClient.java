package org.otw.archive;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.ArrayList;
import java.util.List;

public class ArchiveClient {

  public ArchiveClient(String connectionUrl) {

  }

  public void connectToArchive() {
    List<Work> works = new ArrayList<>();

    ClientConfig clientConfig = new DefaultClientConfig();

//    clientConfig.getFeatures().put(
//            JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

    Client client = Client.create(clientConfig);

    WebResource webResource = client
            .resource("http://ariana.archiveofourown.org/api/v1/works");

    ClientResponse response = webResource.accept("application/json")
            .type("application/json").post(ClientResponse.class, works);

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
              + response.getStatus());
    }

  }
}
