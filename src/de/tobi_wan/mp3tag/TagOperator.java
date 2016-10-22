package de.tobi_wan.mp3tag;

import java.io.File;
import java.io.IOException;
import com.beaglebuddy.mp3.MP3;
import tobiwan.support.StandardOutput;



public class TagOperator {
   FileOperator   fo = new FileOperator();
   StandardOutput s  = new StandardOutput("*", 80);

   public void changeTitleToTrackNumber(String path) throws IOException {
      MP3 mp3 = new MP3(path);
      int track = mp3.getTrack();
      String formatedTrack = formatTrack(track);
      s.print(mp3.getTitle());
      mp3.setTitle(formatedTrack);
      mp3.save();
      s.println("\t=>\t" + mp3.getTitle());
   }

   public String formatTrack(int track) {
      return addZerosForFormatIfNecessary(track) + track;
   }

   public String addZerosForFormatIfNecessary(int number) {
      if (number < 10)
         return "00";
      else if (number < 100) return "0";
      return "";
   }

   public void changeAllTitlesToTrackNumbers(String path) throws IOException {
      File [] listOfFiles = fo.makeListOfAllFiles(path);
      for (File file : listOfFiles) {
         changeTitleToTrackNumber(path + file.getName());
      }
   }
}
