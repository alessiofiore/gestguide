package it.mdps.gestguide.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date parseDate(String sDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return sdf.parse(sDate);
	}
}
