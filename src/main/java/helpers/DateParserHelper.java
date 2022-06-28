package helpers;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateParserHelper {
    private DateParserHelper() {
    }

    /**
     * @param dateToConvert     - date, have to be converted to string
     * @param dateFormatPattern - date have to be converted to format
     * @return строковое значение даты в заданном формате
     */
    public static String convertDateToString(Date dateToConvert, String dateFormatPattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern, Locale.US);
        return dateFormat.format(dateToConvert);
    }

    /**
     * @param stringDateToConvert - string date value for converting
     * @param dateFormatPattern   - date pattern
     * @return object Date
     */
    @SneakyThrows
    public static Date convertStringToDate(String stringDateToConvert, String dateFormatPattern) {
        return new SimpleDateFormat(dateFormatPattern, new Locale("ru")).parse(stringDateToConvert);
    }

    @SneakyThrows
    public static String convertStringToDateRusLocale(String stringDateToConvert, String currentDateFormat, String expectedDateFormatPattern) {
        Locale locale = new Locale("ru");
        SimpleDateFormat formatter = new SimpleDateFormat(currentDateFormat, locale);
        Date date = formatter.parse(stringDateToConvert);
        formatter = new SimpleDateFormat(expectedDateFormatPattern, locale);
        return formatter.format(date).replace(formatter.format(date).charAt(0),Character.toUpperCase(formatter.format(date).charAt(0)));
    }

    /**
     * @param dateFormat   - date format as  dd/MM/yyyy HH:mm:ss
     * @return - String, date format as requested
     */
    public static String getCurrentDate(String dateFormat){
        Locale locale = new Locale("ru");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, locale);
        return formatter.format(date);
    }

    /**
     * @param  sumOfDays - add or minus num of day from current date
     * @param dateFormat - date pattern as dd/MM/yyyy HH:mm:ss
     * @return - String, date format as requested
     */
    public static String getAnyDate(String dateFormat, int sumOfDays){
        Calendar calendar = Calendar.getInstance();
        Locale locale = new Locale("ru");
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, locale);

        calendar.setTime(new Date());              // Now use today date.
        calendar.add(Calendar.DATE, sumOfDays);    // Adds 15 days
        return formatter.format(calendar.getTime());
    }
}
