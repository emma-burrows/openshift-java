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

public class ArchiveClient {

  WebResource webResource;
  ClientResponse response;

  public ArchiveClient(String connectionUrl) {

  }

  public void connectToArchive() throws IOException {

    ClientConfig clientConfig = new DefaultClientConfig();
    Client client = Client.create(clientConfig);

    webResource = client
            .resource("http://ariana.archiveofourown.org/api/v1/works");

  }

  public Work[] getWorks() {
    WorkSearch workSearch = new WorkSearch();
    return getWorks(workSearch);
  }

  public Work[] getWorks(WorkSearch workSearch) {
    Work[] works = null;

    try {
      connectToArchive();

      final String string = webResource.queryParams(workSearch.asQueryParams())
              .accept(MediaType.APPLICATION_JSON_TYPE)
              .header("Authorization", "Token token=e1b6298a6209dd65e5df95b83b10c0f1")
              .get(String.class);
      ObjectMapper mapper = new ObjectMapper();
      // Don't fail if there are properties we don't care about
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      works = mapper.readValue(string, Work[].class);
    }
    catch (Exception e) {
      System.out.println("There has been an error!" + e.getMessage());
    }
    return works;
  }

    public Work getWorkById(final Integer id) {
        Work work = null;
        try {
            connectToArchive();

            final String string = webResource.path(id.toString())
                    .header("Authorization", "Token token=e1b6298a6209dd65e5df95b83b10c0f1")
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            // Don't fail if there are properties we don't care about
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            work = mapper.readValue(string, Work.class);
        }
        catch (Exception e) {
            System.out.println("There has been an error!" + e.getMessage());
        }
        return work;
    }
}
