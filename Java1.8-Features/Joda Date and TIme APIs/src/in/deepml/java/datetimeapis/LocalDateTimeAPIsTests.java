package in.deepml.java.datetimeapis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeAPIsTests {

	public static void main(String[] args) {

		// Current system date & time
		LocalDate date = LocalDate.now();
		System.out.println("Current system date "+date);
		
		LocalTime time = LocalTime.now();
		System.out.println("Current system time "+time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Current system datetime "+dateTime);
		
		System.out.println(date.getYear());
		System.out.println(date.getMonth()+" ("+date.getMonthValue()+")");
		System.out.println(date.getDayOfMonth());
		
		System.out.printf("%d-%d-%d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		
		System.out.println();
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(time.getNano());
		
		// Change 
		System.out.println(date.plusYears(5));
		System.out.println(date.minusYears(3));
		
		System.out.println(date.plusMonths(2));
		System.out.println(date.minusMonths(1));
		
		System.out.println(date.plusDays(20));
		System.out.println(date.minusDays(12));
		
		// Some Other Date
		LocalDate someDate = LocalDate.of(1986, 12, 25);
		LocalTime someTime = LocalTime.of(15, 45, 58);
		LocalDateTime dateTimeObj = LocalDateTime.of(someDate, someTime);
		System.out.println(dateTimeObj);
		
		// Period
		LocalDate birthDate = LocalDate.of(1982, 11, 9);
		Period period = Period.between(birthDate, LocalDate.now());
		System.out.println(period.getYears()+" Years "+period.getMonths()+" Months "+period.getDays()+" Days");
		
		// Zone
		ZoneId zId = ZoneId.systemDefault();
		System.out.println(zId);
		
		//Print all available Zones
		System.out.println(ZoneId.getAvailableZoneIds());
		
		//Print datetime in a zone
		ZoneId laZoneId = ZoneId.of("America/Los_Angeles");
		ZonedDateTime laDateTime = ZonedDateTime.now(laZoneId);
		System.out.println(laDateTime);
		//.......
	}
}
