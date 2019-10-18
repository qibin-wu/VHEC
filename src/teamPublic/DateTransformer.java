package teamPublic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class DateTransformer {
	
	public static int toWeek(LocalDate date)
	{
		int week;
		WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,4);
		week=date.get(weekFields.weekOfWeekBasedYear()) ;
		
		return week;
		
	}
	
	public static int toYear(LocalDate date)
	{
		int year;
		
		year=date.getYear();
		
		return year;
		
	}
	public static boolean checkSameWeek(LocalDate oldDate,LocalDate newDate)
	{
		boolean result;
		
		if( toWeek(oldDate)== toWeek(newDate) && toYear(oldDate)==toYear(newDate) )
		     result =true;
		else
			result=false;
		
		return result;
		
	}
}
