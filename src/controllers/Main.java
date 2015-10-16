package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;

public class Main
{
  public static void main(String[] args) throws Exception
  {    
    PacemakerAPI pacemakerAPI = new PacemakerAPI();
    
    pacemakerAPI.createUser("Bart", "Simpson",   "bart@simpson.com", "secret");
    pacemakerAPI.createUser("Homer", "Simpson",  "homer@simpson.com", "secret");
    pacemakerAPI.createUser("Lisa", "Simpson", " lisa@simpson.com", "secret");

    Collection<User> users = pacemakerAPI.getUsers();
    System.out.println(users);
    
    User homer = pacemakerAPI.getUserByEmail("homer@simpson.com");
    System.out.println(homer);
    
    pacemakerAPI.deleteUser(homer.id);
    users = pacemakerAPI.getUsers();
    System.out.println(users);
    
    pacemakerAPI.store(new File("datastore.xml")); 
  }
}