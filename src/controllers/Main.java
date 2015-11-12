package controllers;

import java.io.File;
import utils.Serializer;
import utils.XMLSerializer;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;


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

  public static void main(String[] args) throws Exception
  {
    Main main = new Main();

    Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to pacemaker-console - ?help for instructions", main);
    shell.commandLoop();

    main.paceApi.store();
  }
}