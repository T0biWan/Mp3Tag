package de.tobi_wan.mp3tag.setTrackNumberAsTitle;

import java.io.File;
import java.io.IOException;
import de.tobi_wan.mp3tag.FileOperator;
import de.tobi_wan.mp3tag.TagOperator;
import tobiwan.support.StandardOutput;



public class RenameInMultipleFolders {
   // Attribute
   static String         path;
   static FileOperator   fileOperator;
   static TagOperator    tagOperator;
   static StandardOutput s;

   public static void main(String [] args) {
      initialiseAttributes();
      changeTitlesInMultipleFiles(path);
   }

   public static void initialiseAttributes() {
      path = "data/";
      fileOperator = new FileOperator();
      tagOperator = new TagOperator();
      s = new StandardOutput("*", 80);
   }

   public static void changeTitle(String path) {
      try {
         tagOperator.changeAllTitlesToTrackNumbers(path);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void changeTitlesInMultipleFiles(String path) {
      File [] files = fileOperator.makeListOfAllFiles(path);
      for (File file : files) {
         s.printlnSeparation();
         s.println(file.getName());
         changeTitle(file.toString() + "/");
         s.printlnSeparation();
      }
   }
}