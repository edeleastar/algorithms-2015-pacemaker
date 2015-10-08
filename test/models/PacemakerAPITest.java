package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.PacemakerAPI;
import static models.Fixtures.users;
import static models.Fixtures.activities;
import static models.Fixtures.locations;

public class PacemakerAPITest
{
  private PacemakerAPI pacemaker;

  @Before
  public void setup()
  {
    pacemaker = new PacemakerAPI();
  }

  @After
  public void tearDown()
  {
    pacemaker = null;
  }
  
  @Test
  public void testUser()
  {
    assertEquals (0, pacemaker.getUsers().size());
  } 
}

