import org.junit.Test;
import tools.Validator;

import static junit.framework.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void testIsAlpha(){
        assertTrue(Validator.isAlphaNumeric("ejzai-eajdz_84"));
    }
}
