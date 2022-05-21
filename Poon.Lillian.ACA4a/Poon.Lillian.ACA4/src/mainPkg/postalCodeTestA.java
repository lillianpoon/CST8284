package mainPkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import postalCodePkg.PostalCodeEntry;

/**
 * this program reads a file and stores the data in a Map. Then, it generates a
 * random postal code prefix and attempts to match it with the location listed
 * in the file. If it is successful, it will print the information found.
 * Otherwise, it will say 'NOT found'
 * 
 * Written for CST8284
 * 
 * @author Lillian Poon
 * 
 * @version 1.0
 * 
 */

public class postalCodeTestA {

	public static void main(String[] args) throws IOException {

		Map<String, String> myMap = new HashMap<>();
		createMap(myMap);
		printMap(myMap);
	}// close main

	/**
	 * This method populates the map
	 * 
	 * @param map is a map with keys and values
	 * 
	 * @exception e
	 *
	 */
	private static void createMap(Map<String, String> map) {

		// retrieving file
		Path path = Paths.get("ottawa_postal_codes.csv");

		// reading file
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			String line;
			line = reader.readLine();

			// populating map
			while ((line = reader.readLine()) != null) {
				String[] splitline = line.split(",");
				map.put(splitline[0], line);
			} // close while loop
		} catch (Exception e) {
			e.printStackTrace();
		} // close catch

	}// end createMap

	/**
	 * This method gets the random Prefix from PostalCodeEntry.java and prints the
	 * data if it's finds a matching key.
	 * 
	 * @param map is a map with keys and values
	 */
	private static void printMap(Map<String, String> map) {

		// loop that generates prefixes and then checks if its in the map, then outputs
		for (int x = 0; x <= 9; x++) {
			String rand = PostalCodeEntry.getRandomPrefix();

			System.out.printf("Retrieving: %s\n", rand);

			if (map.containsKey(rand)) {
				System.out.printf("\t%s\n", map.get(rand));
			} else
				System.out.printf("\t%s\n", "NOT found");
		} // close for loop

	}// end printMap

} // end class
