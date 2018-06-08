package marleedonnelly.se_assignment2;

public class Validator {

    //Static variables for checking rules
    private static final int MIN_LENGTH = 8;
    private static final String WRONG_STR = "password";
    private static  final int NUM_RULES = 2;

    //Check that password is >8 chars long and not "password"
    public int validate(String passwordStr) {
        int rulesPassed = NUM_RULES;
        if(passwordStr.length() < MIN_LENGTH){
            rulesPassed--;
        }
        if(passwordStr.equalsIgnoreCase(WRONG_STR)){
            rulesPassed--;
        }
        return rulesPassed;
    }
}
