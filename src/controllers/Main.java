package controllers;

import java.io.File;
import java.util.Collection;

import utils.Serializer;
import utils.XMLSerializer;
import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.User;


public class Main
{
  public PacemakerAPI paceApi;

  public Main() throws Exception
  {
    File datastore = new File("datastore.xml");
    Serializer serializer = new XMLSerializer(datastore);

    paceApi = new PacemakerAPI(serializer);
    if (datastore.isFile())
    {
      paceApi.load();
    }
  }

  @Command(description="Get all users details")
  public void getUsers ()
  {
    Collection<User> users = paceApi.getUsers();
    System.out.println(users);
  }
  
  public static void main(String[] args) throws Exception
  {
    Main main = new Main();

    Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to pacemaker-console - ?help for instructions", main);
    shell.commandLoop();

    main.paceApi.store();
  }
}