package de.tobi_wan.mp3tag;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FileOperator {
   public File [] makeListOfAllFiles(String path) {
      File folder = new File(path);
      return folder.listFiles();
   }

   public void copyFile(String source, String destination) throws IOException {
      Path sourcePath = Paths.get(source);
      Path destinationPath = Paths.get(destination);
      Files.copy(sourcePath, destinationPath);
   }

   public void copyAllFiles(String source, String destination) throws IOException {
      File [] listOfFiles = makeListOfAllFiles(source);
      for (File file : listOfFiles) {
         copyFile(source + file.getName(), destination + file.getName());
      }
   }
}
