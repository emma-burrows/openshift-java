package com.eburrows.openshift;

import org.otw.archive.ArchiveClient;
import org.otw.archive.Work;

public class ArchiveBean {

  public Work[] getWorks() {
    return works;
  }

  private Work[] works = new ArchiveClient("").getWorks();
}
