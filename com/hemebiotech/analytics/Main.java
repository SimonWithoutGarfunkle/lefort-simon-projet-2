package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Main {
  /**
  * Read source file, extract and process data.
  * Generate the intended result file.
  *
  */
  public static void main(String[] args) {

    ISymptomReader myReader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter myWriter = new WriteSymptomDataToFile();
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(myReader, myWriter);

    List<String> listOfSymptoms;

    listOfSymptoms = analyticsCounter.getSymptoms();

    Map<String, Integer> counting = analyticsCounter.countSymptoms(listOfSymptoms);

    SortedMap<String, Integer> ordering = analyticsCounter.sortSymptoms(counting);

    analyticsCounter.writeSymptoms(ordering);
  
  }
}