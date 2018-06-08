package marleedonnelly.se_assignment2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorUnitTests {

    Validator validator = new Validator();
    int totalRules = validator.getNumRules();

    @Test
    public void testStrongPassword() {
        assertEquals(totalRules, validator.validate("Very!Str0ngPassw0rd!"));
    }

    @Test
    public void testShortPassword() {
        assertNotEquals(totalRules, validator.validate("Sh0rt"));
    }

    @Test
    public void testUnoriginalPassword() {
        assertNotEquals(totalRules, validator.validate("password"));
    }

    @Test
    public void testAllCapsPassword() {
        assertNotEquals(totalRules, validator.validate("WRITTENINALLCAPS123"));
    }

    @Test
    public void testNumberlessPassword() {
        assertNotEquals(totalRules, validator.validate("$aBcDeFgHiJkLm$"));
    }

    @Test
    public void testMissingSpecialCharPassword() {
        assertNotEquals(totalRules, validator.validate("ThisHasN0SpecialChars"));
    }

}
