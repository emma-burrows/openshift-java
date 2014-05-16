package org.otw.archive;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.ArrayList;
import java.util.List;

public class ArchiveClient {

  public Work work;

  public ArchiveClient(String connectionUrl) {

  }

  public void connectToArchive() {

    work = new Work();

    ClientConfig clientConfig = new DefaultClientConfig();

//    clientConfig.getFeatures().put(
//            JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

    Client client = Client.create(clientConfig);

    WebResource webResource = client
            .resource("http://ariana.archiveofourown.org/api/v1/works/1793");

    ClientResponse response = webResource.accept("application/json")
            .type("application/json").post(ClientResponse.class, work);

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
              + response.getStatus());
    }

  }
}
