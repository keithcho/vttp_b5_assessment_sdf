package vttp.batch5.sdf.task01;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Helper class to print output

public class OutputHelper {

    public static final String[] POSITION = { "highest", "second highest", "third highest", "fourth highest", "fifth highest" };
    public static final String[] WEATHER = { "Clear, Few clouds, Partly cloudy, Partly cloudy",
    "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist",
    "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds",
    "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog" };

    public static String toPosition(int position) {
		switch (position) {
			case 0:
			case 1:
			case 2:
			case 3:
			default:
				return "not in top 5";
		}
	}

	public static String toWeather(int weather) {
		switch (weather) {
			case 1:
			case 2:
			case 3:
			case 4:
				return WEATHER[weather - 1];
			default:
				return "unreported";
		}
	}

	public static String isHoliday(boolean holiday) {
		if (holiday) {
			return "a holiday";
		} else {
			return "not a holiday";
		}
	}

    public static void printOutput(BikeEntry rowData, int index) {
		int cyclistCount = rowData.getCasual() + rowData.getRegistered();
		System.out.println("The " + POSITION[index] + " (position) recorded number of cyclists was in "
		+ Utilities.toSeason(rowData.getSeason()) + " (season), on a " + Utilities.toWeekday(rowData.getWeekday())
		+ " (day) in the month of " + Utilities.toMonth(rowData.getMonth()) + " (month). There were a total of "
		+ cyclistCount + " (total) cyclists. The weather was " + WEATHER[rowData.getWeather()-1] + " (weather). "
		+ Utilities.toWeekday(rowData.getWeekday()) + " (day) was " + isHoliday(rowData.isHoliday()) + ".");
		System.out.println();
	}
}