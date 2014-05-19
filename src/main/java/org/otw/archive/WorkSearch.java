package org.otw.archive;

import com.sun.jersey.api.representation.Form;
import org.joda.time.DateTime;

import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class WorkSearch {

  private static final Logger LOGGER = Logger.getLogger(WorkSearch.class.getName());

  private String title;
  private Creator creator;
  private DateTime revised_at;
  private String language_id;
  private Boolean complete;
//          :single_chapter,
//          :word_count,
//          :hits,
//          :kudos_count,
//          :bookmarks_count,
//          :comments_count,
//          :pseud_ids,
//          :collection_ids,
//          :tag,
//          :other_tag_names,
//          :filter_ids,
//          :fandom_names,
//          :fandom_ids,
//          :rating_ids,
//          :category_ids,
//          :warning_ids,
//          :character_names,
//          :character_ids,
//          :relationship_names,
//          :relationship_ids,
//          :freeform_names,
//          :freeform_ids,
//          :sort_column,
//          :sort_direction,
//          :show_restricted,
  private Integer page;

  public MultivaluedMap<String,String> asQueryParams() {
    final MultivaluedMap<String, String> queryParams = new Form();
    final Field[] fields = getClass().getDeclaredFields();
    for (Field field : fields) {
      final boolean accessible = field.isAccessible();
      try {
        field.setAccessible(true);
        final Object value = field.get(this);
        if (value != null && field.getName() != "LOGGER") {
          final String name = field.getName();
          queryParams.add(name, value.toString());
        }
      }
      catch (IllegalAccessException e) {
        LOGGER.severe("Error accessing a field: " + e.getMessage());
      }
      finally {
        field.setAccessible(accessible);
      }
    }
    return queryParams;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Creator getCreator() {
    return creator;
  }

  public void setCreator(Creator creator) {
    this.creator = creator;
  }

  public DateTime getRevised_at() {
    return revised_at;
  }

  public void setRevised_at(DateTime revised_at) {
    this.revised_at = revised_at;
  }

  public String getLanguage_id() {
    return language_id;
  }

  public void setLanguage_id(String language_id) {
    this.language_id = language_id;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }
}
