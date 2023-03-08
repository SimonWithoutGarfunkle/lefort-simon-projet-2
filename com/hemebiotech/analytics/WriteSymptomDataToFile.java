package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

// WRITE YOUR CODE HERE
public class WriteSymptomDataToFile implements ISymptomWriter {
  private String fileName;

  public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    
    fileName = "results.out.txt";

    try {
      FileWriter writer = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(writer);

      for (Map.Entry<String, Integer> mapEntry : symptoms.entrySet()) {
        bw.write(mapEntry.getKey() + "=" + mapEntry.getValue());
        bw.newLine();

      }
      bw.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}