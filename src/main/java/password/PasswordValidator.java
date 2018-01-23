package password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private String password;
    private final String [] sign = new String[6];

    public PasswordValidator(String password){
        this.password = password;

        sign[0] = ".";
        sign[1] = ",";
        sign[2] = "-";
        sign[3] = "_";
        sign[4] = "?";
        sign[5] = "!";
    }

    public String getPassword() {
        return password;
    }

    public boolean checkIfContainSpecialSign(){
        for(int i = 0; i < sign.length; i++){
            if (this.getPassword().contains(sign[i]))
                return true;
        }return false;
    }

    public boolean hasBigLetter() {
        Pattern pattern = Pattern.compile(".*[A-Z]++.*");
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches())
            return true;
        else return false;
    }
}