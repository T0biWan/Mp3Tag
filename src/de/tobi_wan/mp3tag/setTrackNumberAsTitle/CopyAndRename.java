package de.tobi_wan.mp3tag.setTrackNumberAsTitle;

import java.io.IOException;
import de.tobi_wan.mp3tag.FileOperator;
import de.tobi_wan.mp3tag.TagOperator;



public class CopyAndRename {
   // Attribute
   static String       inputPath;
   static String       outputPath;
   static FileOperator fileOperator;
   static TagOperator  tagOperator;

   public static void main(String [] args) {
      initialiseAttributes();
      copy(inputPath, outputPath);
      changeTitle(outputPath);
   }

   public static void initialiseAttributes() {
      inputPath = "data/input/";
      outputPath = "data/output/";
      fileOperator = new FileOperator();
      tagOperator = new TagOperator();
   }

   public static void copy(String source, String destination) {
      try {
         fileOperator.copyAllFiles(source, destination);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void changeTitle(String path) {
      try {
         tagOperator.changeAllTitlesToTrackNumbers(path);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
