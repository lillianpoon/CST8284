package postalCodePkg;

import java.util.Random;

public class PostalCodeEntry {
	String prefix;
	String place_name;
	String province;
	String latitude;
	String longitude;

	/**
	 * @param prefix
	 * @param place_name
	 * @param province
	 * @param latitude
	 * @param longitude
	 */
	public PostalCodeEntry(String prefix, String place_name, String province, String latitude,
			String longitude) {
		this.prefix = prefix;
		this.place_name = place_name;
		this.province = province;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * set all instance variables to null
	 */
	public PostalCodeEntry() {
	}
	
	/**
	 * @param fields
	 */
	public PostalCodeEntry(String[] fields) {
		this(fields[0],fields[1],fields[2],fields[3],fields[4]);
	}

	public String getPrefix() {
		return prefix;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s\n",
				prefix, place_name, province, latitude, longitude);
	}

	final static Random rand = new Random(0); // provide a seed value to get
											  // same random sequence
											  // remove seed after testing;
	final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String number = "0123456789";

	public static String getRandomPrefix() {
		int randA = rand.nextInt(alpha.length());
		int randN = rand.nextInt(number.length());

		return "K" + number.charAt(randN) + alpha.charAt(randA);
	}// getRandom()
	
}//class
