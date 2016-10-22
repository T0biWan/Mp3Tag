package de.tobi_wan.mp3tag.setTrackNumberAsTitle;

import java.io.IOException;
import de.tobi_wan.mp3tag.TagOperator;



public class Rename {
   // Attribute
   static String      path;
   static TagOperator tagOperator;

   public static void main(String [] args) {
      initialiseAttributes();
      changeTitle(path);
   }

   public static void initialiseAttributes() {
      path = "data/";
      tagOperator = new TagOperator();
   }

   public static void changeTitle(String path) {
      try {
         tagOperator.changeAllTitlesToTrackNumbers(path);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
