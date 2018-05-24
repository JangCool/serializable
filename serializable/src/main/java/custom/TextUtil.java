package custom;

public class TextUtil {


    
    public static String nvl(String str, String defaultValue) {

        if (str == null || "".equals(str)) {
            return defaultValue;
        } else {
            return str;
        }

    }

}
