package com.eburrows.openshift;

import org.otw.archive.ArchiveClient;
import org.otw.archive.Work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchiveBean {

  private Work[] works = new ArchiveClient("").getWorks();

  public Work[] getWorks() {
    return works;
  }

  public Work getWork(Integer id) {
    return new ArchiveClient("").getWorkById(id);
  }

  public String formatDate(Date date) {
    return new SimpleDateFormat("dd MMM yyyy").format(date);
  }
}
