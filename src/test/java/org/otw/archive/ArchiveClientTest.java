package org.otw.archive;

import org.junit.Assert;
import org.junit.Test;

public class ArchiveClientTest {

  @Test
  public void testConnectToArchive() throws Exception {
    ArchiveClient archiveClient = new ArchiveClient("");

    archiveClient.connectToArchive();

    Assert.assertNotEquals(archiveClient.works, null);
  }
}
