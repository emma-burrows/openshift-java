package org.otw.archive;

import org.junit.Assert;
import org.junit.Test;

public class ArchiveClientIntegrationTest {

  @Test
  public void testConnectToArchive() throws Exception {
    ArchiveClient archiveClient = new ArchiveClient("");

    archiveClient.connectToArchive();

    Assert.assertNotEquals(archiveClient.getWorks(), null);
  }

    @Test
  public void filterArchiveResults() throws Exception {
    ArchiveClient archiveClient = new ArchiveClient("");
    WorkSearch workSearch = new WorkSearch();
    workSearch.setTitle("The");

    archiveClient.connectToArchive();
    Assert.assertNotEquals(archiveClient.getWorks(workSearch), null);
  }

    @Test
    public void getWorkById() throws Exception {
        ArchiveClient archiveClient = new ArchiveClient("");
        archiveClient.connectToArchive();
        Work work = archiveClient.getWorkById(2);
        Assert.assertNotEquals(work, null);
    }
}
