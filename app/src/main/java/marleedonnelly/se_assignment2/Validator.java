package marleedonnelly.se_assignment2;

public class Validator {

    //Static variables for checking rules
    private static final int MIN_LENGTH = 8;
    private static final String WRONG_STR = "password";
    private static  final int NUM_RULES = 5;

    private char[] specialCharacters = {'!','@','#','$','%','^','&','*','(',')','-','_','+','='};
    private  char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};

    public static void main(String [] args){
        Validator validator = new Validator();

        String [] passwords = {"Acc3ptable!!", "$hOrt", "ALL_UPPERCASE1", "NoNumber", "password", "aaa"};
        for(int m=0; m<passwords.length; m++) {
            System.out.println("Validating "+passwords[m]);
            validator.validate(passwords[m]);
        }
    }

    public int validate(String passwordStr) {
        int rulesPassed = NUM_RULES;
        System.out.println("Num rules (total): "+NUM_RULES);

        //Check that the password is long enough
        if(passwordStr.length() < MIN_LENGTH){
            rulesPassed--;
        }

        //Check that the password is not "password"
        if(passwordStr.equalsIgnoreCase(WRONG_STR)){
            rulesPassed--;
        }

        //Check that the password contains at least one special character
        boolean hasSpecialChar = false;
        for(int i=0; i<specialCharacters.length; i++){
            String currentSpecialCharacter = specialCharacters[i]+"";
            if(passwordStr.contains(currentSpecialCharacter)){
                hasSpecialChar = true;
                break;
            }
        }
        if(!hasSpecialChar){
            rulesPassed--;
        }

        //Check that the password contains a mix of uppercase and lowercase letters
        if(passwordStr.equals(passwordStr.toLowerCase())||passwordStr.equals(passwordStr.toUpperCase())){
            rulesPassed--;
        }

        //Check that the password contains at least one number
        boolean hasNumber = false;
        for(int i=0; i<numbers.length; i++){
            String currentNumber = numbers[i]+"";
            if(passwordStr.contains(currentNumber)){
                hasNumber = true;
                break;
            }
        }
        if(!hasNumber){
            rulesPassed--;
        }

        System.out.println("Num rules passed: "+rulesPassed);
        return rulesPassed;
    }
}
