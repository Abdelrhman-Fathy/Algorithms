import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		new Test().calculate(1);
		new Test().calculate(2);
		new Test().calculate(3);
		new Test().calculate(4);
		new Test().calculate(5);
		new Test().calculate(6);
		new Test().calculate(7);
		new Test().calculate(8);
		new Test().calculate(9);
	}
	private Date calculate(int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, day-1);
		System.out.println("Current Date and Time = " + cal.getTime());
		return cal.getTime();
	}

}
