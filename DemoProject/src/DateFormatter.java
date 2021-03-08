import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public static void main(String[] args) throws ParseException {
		String dateStr = "24-FEB-17";	
		Date date = new Date(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		dateStr = format.format(date);
		System.out.println(dateStr);
		System.out.println(format.parse(dateStr));
	}

}
