package org.otw.archive;

import org.joda.time.DateTime;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class Work {
  private long id;
  private String title;
  private String summary;
  private String notes;
  private String endnotes;
  private boolean complete;
  private boolean restricted;
  private Date revised_at;
  private long word_count;
  private URL url;
  private URL comment_url;

  private List<Creator> creators;

  private List<Chapter> chapters;

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

  public Date getRevised_at() {
    return revised_at;
  }

  public void setRevised_at(Date revisedAt) {
    this.revised_at = revisedAt;
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

  public URL getComment_url() {
    return comment_url;
  }

  public void setComment_url(URL commentUrl) {
    this.comment_url = commentUrl;
  }

  public List<Creator> getCreators() {
    return creators;
  }

  public void setCreators(List<Creator> creators) {
    this.creators = creators;
  }

  public List<Chapter> getChapters() {
    return chapters;
  }

  public void setChapters(List<Chapter> chapters) {
    this.chapters = chapters;
  }
}
