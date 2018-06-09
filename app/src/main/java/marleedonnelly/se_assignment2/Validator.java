package marleedonnelly.se_assignment2;

public class Validator {

    //Static variables for checking rules
    private static final int MIN_LENGTH = 8;
    private static final String WRONG_STR = "password";
    private static  final int NUM_RULES = 5;

    private char[] specialCharacters = {'!','@','#','$','%','^','&','*','(',')','-','_','+','='};
    private char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
    private boolean hasSpecialChar = false;
    private boolean hasNumber = false;

    public int validate(String passwordString) {
        int rulesPassed = NUM_RULES;

        //Check that the password is long enough
        if(passwordString.length() < MIN_LENGTH){
            rulesPassed--;
        }

        //Check that the password is not "password"
        if(passwordString.equalsIgnoreCase(WRONG_STR)){
            rulesPassed--;
        }

        //Check that the password contains at least one special character
        for(int i=0; i<specialCharacters.length; i++){
            String currentSpecialCharacter = specialCharacters[i]+"";
            if(passwordString.contains(currentSpecialCharacter)){
                hasSpecialChar = true;
                break;
            }
        }
        if(!hasSpecialChar){
            rulesPassed--;
        }

        //Check that the password contains a mix of uppercase and lowercase letters
        if(passwordString.equals(passwordString.toLowerCase())||passwordString.equals(passwordString.toUpperCase())){
            rulesPassed--;
        }

        //Check that the password contains at least one number
        for(int i=0; i<numbers.length; i++){
            String currentNumber = numbers[i]+"";
            if(passwordString.contains(currentNumber)){
                hasNumber = true;
                break;
            }
        }
        if(!hasNumber){
            rulesPassed--;
        }

        return rulesPassed;
    }

    public int getNumRules() {
        return NUM_RULES;
    }

}
