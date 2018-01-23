package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*extracts digits from String
 * */
public class RegexSample {
    private String string;

    public RegexSample(String string){
        this.string = string;
    }

    public int containDigits() {
        int y = 0;
        for (int i = 0; i <= 9; i++){
            if (string.contains(String.valueOf(i)))
                y++;
            System.out.println(y);
        }return y;
    }

    public int howMuchDigits() {
        int y = 0;
        //Pattern pattern = Pattern.compile(".*[0-9].*");
        Pattern fromstack = Pattern.compile("\\d+|\\D+");
        Matcher matcher = fromstack.matcher(string);
        if (matcher.matches())
            while (matcher.find())
                return y;
        return y;
    }
}