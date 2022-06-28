package helpers;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsHelper {
    private StringsHelper() {
    }

    /**
     * @return random string uuid
     */
    public static String getRandomString() {
        return UUID.randomUUID().toString();
    }

    /**
     * @return random string uuid with prefix
     */
    public static String getRandomString(String prefix, int count) {
        return prefix + RandomStringUtils.randomAlphanumeric(count);
    }

    /**
     * @return random string uuid from digitals
     */
    public static String getRandomNumberString(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public static String getRandomNumberString(int from, int to) {
        int num = new Random().ints(from, to)
                .findFirst()
                .getAsInt();
        return String.valueOf(num);
    }

    public static String getRandomCyrillicString(int count) {
    String cyrillicAlphabet = "AaBbCcDdEeFfGgHhIiJjIiKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        return RandomStringUtils.random(count, cyrillicAlphabet);
    }

    /**
     * @param count - number of characters per line
     * @return random string from digitals
     */
    public static String getRandomString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    /**
     * @param count - number of characters per line
     * @return random string from letters
     */
    public static String getRandomLetterString(int count) { return RandomStringUtils.randomAlphabetic(count);}

    public static String getSubstringByRegEx(String regEx, String fullString){
        Pattern pattern = Pattern.compile(regEx,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(fullString);

        if (matcher.find()) {
            String tmp =  matcher.group(1);
            return tmp;
        }else{
            return null;
        }
    }

    public static boolean isStringCorrespondToRegEx(String regEx, String fullString){
        Pattern pattern = Pattern.compile(regEx,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(fullString);
        boolean isMatch = matcher.find();
        return isMatch;
    }

    public static String getGuid(int length){
        return UUID.randomUUID().toString().replace('-','g').substring(0,length);
    }
    public static String getNumBasedOnCLock(){
        return String.valueOf(new Random(System.currentTimeMillis()).hashCode());
    }
}
