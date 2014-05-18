package org.otw.archive;

import org.joda.time.DateTime;

import java.net.URL;
import java.util.List;

public class Work {
  private long id;
  private String title;
  private String summary;
  private String notes;
  private String endnotes;
  private boolean complete;
  private boolean restricted;
  private DateTime revisedAt;
  private long word_count;
  private URL url;
  private URL commentUrl;


  private List<Creator> creators;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getEndnotes() {
    return endnotes;
  }

  public void setEndnotes(String endnotes) {
    this.endnotes = endnotes;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public boolean isRestricted() {
    return restricted;
  }

  public void setRestricted(boolean restricted) {
    this.restricted = restricted;
  }

  public DateTime getRevisedAt() {
    return revisedAt;
  }

  public void setRevisedAt(DateTime revisedAt) {
    this.revisedAt = revisedAt;
  }

  public long getWord_count() {
    return word_count;
  }

  public void setWord_count(long word_count) {
    this.word_count = word_count;
  }

  public URL getUrl() {
    return url;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public URL getCommentUrl() {
    return commentUrl;
  }

  public void setCommentUrl(URL commentUrl) {
    this.commentUrl = commentUrl;
  }

  public List<Creator> getCreators() {
    return creators;
  }

  public void setCreators(List<Creator> creators) {
    this.creators = creators;
  }
}
