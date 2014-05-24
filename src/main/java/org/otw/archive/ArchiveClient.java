package org.otw.archive;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class ArchiveClient {
  String host = "http://ariana.archiveofourown.org/api/v1";
  String authorizationToken = "Token token=e1b6298a6209dd65e5df95b83b10c0f1";
  WebResource webResource;
  ClientResponse response;

  public ArchiveClient() {
    ClientConfig clientConfig = new DefaultClientConfig();
    Client client = Client.create(clientConfig);

    webResource = client.resource(host);
  }

  public Work[] getWorks() {
    WorkSearch workSearch = new WorkSearch();
    return getWorks(workSearch);
  }

  public Work[] getWorks(WorkSearch workSearch) {
    Work[] works = null;

    try {
      final String string = getResponse("works", workSearch.asQueryParams());
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
      final String string = getResponse("works/" + id.toString(), new MultivaluedMapImpl());
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

  public List<Chapter> getWorkChapterById(final Integer workId) {
      return getWorkById(workId).getChapters();
    }

  // Utilities

  private String getResponse(String requestPath, MultivaluedMap queryParams) {
      final String string = webResource.path(requestPath)
              .queryParams(queryParams)
              .header("Authorization", authorizationToken)
              .accept(MediaType.APPLICATION_JSON_TYPE)
              .get(String.class);
      return string;
  }
}
