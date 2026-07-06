package Experiment;

import java.util.Date;

public class DateGeneratorMethod {

	public static void main(String[] args) {
		Date date=new Date();
		String stringDate= date.toString();
		String noSpaceString=stringDate.replaceAll("\\s", "");
		String replacedString=noSpaceString.replaceAll("\\:","");
		String emailWithTime=replacedString+"@gmail.com";
		System.out.println(emailWithTime);
		
		

	}
	

}
