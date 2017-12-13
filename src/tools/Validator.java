package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final int passwordSizeMin = 4;
    public static final int passwordSizeMax = 14;

    public static boolean isEmail(String email){

        Pattern p = Pattern.compile("^[\\w-]+[@][\\w-]+[.][a-z]+$"); // *******@*****.****
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean isAlphaNumeric(String string){

        Pattern p = Pattern.compile("^[\\w-]+$");
        Matcher m = p.matcher(string);
        return m.find();
    }

    public static boolean hasLengthBetween(String s, int min, int max){
        return s.length() >= min && s.length() <= max;
    }

    public static boolean verifyPassword(String password)
    {
        return hasLengthBetween(password, passwordSizeMin, passwordSizeMax);
    }
}
