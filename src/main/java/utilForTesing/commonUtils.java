package utilForTesing;

import java.util.Date;

public class commonUtils {
	public static String emailGenerator()
	{
		Date date=new Date();
		String stringDate=date.toString();
		String emailDate=stringDate.replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		return emailDate;
	}

}
