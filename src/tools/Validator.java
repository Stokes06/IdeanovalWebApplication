package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isEmail(String email){

        Pattern p = Pattern.compile("^[\\w-]+[@][\\w-]+[.][a-z]+$"); // *******@*****.****
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean isAlphaNumeric(String string){

        Pattern p = Pattern.compile("^[\\w]+$");
        Matcher m = p.matcher(string);
        return m.find();
    }
}
