package com.eburrows.openshift;

import java.io.IOException;

import org.eclipse.egit.github.core.User;

import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHub
{

  public GitHub()
  {
  }

  public static String getRepository()
  {
    String result = "";
    RepositoryService service = new RepositoryService();
    try
    {
      for (Repository repo : service.getRepositories("emma-burrows"))
        result += repo.getName() + " Watchers: " + repo.getWatchers();
    }
    catch (IOException e)
    {
      result = e.getMessage();
    }
    return result;
  }
}
