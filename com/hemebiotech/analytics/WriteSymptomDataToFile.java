package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
  private String fileName;

  /**
  * Write a map in a file named result.out.
  * One item by line with this format "key:value".
  *
  *@param symptoms Map with ordered symptoms and their occurences
  */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    
    fileName = "result.out";

    try {
      FileWriter writer = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(writer);

      for (Map.Entry<String, Integer> mapEntry : symptoms.entrySet()) {
        bw.write(mapEntry.getKey() + " : " + mapEntry.getValue());
        bw.newLine();

      }
      bw.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}