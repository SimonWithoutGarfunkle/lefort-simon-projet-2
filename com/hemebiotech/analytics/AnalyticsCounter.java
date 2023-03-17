package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * count symptoms and alphabetically order the list from extracted data 
 * 
 * @version 1.0
 *
 * @author Simon Lefort
 */
public class AnalyticsCounter {
  ISymptomReader reader;
  ISymptomWriter writer;
  
  /**
  * Class constructor.
  * @param reader extract data from the source file
  * @param writer write the processed data in the result file
  */
  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
    
  }
  
  /**
  * Call the file reader.
  *
  * @return symptom list from source file
  * @see ReadSymptomDataFromFile#getSymptoms
  */
  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
    
  }

  /**
  * Call the file writer.
  *
  * @see WriteSymptomDataToFile#writeSymptoms
  */
  public void writeSymptoms(Map<String, Integer> symptomsWithOrder) {
    this.writer.writeSymptoms(symptomsWithOrder); 

  }
  
  /**
  * Generate a map of unique symptom with the corresponding number of occurrences.
  * 
  * @param symptoms symptom list from getSymptoms method
  * @return map of unique symptom with the corresponding number of occurrences
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> counter = new HashMap<String, Integer>();
    for (String symptom: symptoms) {
      if (counter.get(symptom) == null) {
        counter.put(symptom, 1);        
      } else {
        counter.put(symptom, counter.get(symptom) + 1); 
      }
    }
    return counter;
  }

  /**
  * Re-order a map in a ascii-betical order.
  * 
  * @param symptoms symptom map from countSymptoms method
  * @return re-ordered a map in a ascii-betical order
  */
  public SortedMap<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    SortedMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>();
    sortedSymptoms.putAll(symptoms);
    return sortedSymptoms;
  }
  
}