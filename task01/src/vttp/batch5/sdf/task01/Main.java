package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static Map<Integer, BikeEntry> readCSV(Reader reader) throws IOException {
		Map<Integer, BikeEntry> dataMap = new TreeMap<>();
		BufferedReader br = new BufferedReader(reader);
		String line;

		// Allocate first line to headers
        String[] cellHeader = br.readLine().split(",");

		// Read .csv file using BufferedReader
		while ((line = br.readLine()) != null) {
            String[] cellRow = line.split(",");
			Integer totalCyclists = Integer.parseInt(cellRow[8]) + Integer.parseInt(cellRow[9]);
			dataMap.put(totalCyclists, BikeEntry.toBikeEntry(cellRow));
        }
		return dataMap;
	}

	public static void main(String[] args) throws IOException {

		String csvPath = "day.csv";
		Reader reader = new FileReader(csvPath);

		Map<Integer, BikeEntry> dataMap = readCSV(reader);

		// Sort data into descending order
		Map<Integer, BikeEntry> dataMapDescending = new TreeMap<>(Collections.reverseOrder());
		dataMapDescending.putAll(dataMap);

		// Print top 5 days with the most cyclists
		Object[] outputArr = dataMapDescending.keySet().toArray();
		for (int i = 0; i < 5; i++) {
			OutputHelper.printOutput(dataMapDescending.get(outputArr[i]), i);
		}
	}
}