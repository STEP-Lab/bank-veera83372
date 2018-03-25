import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import org.junit.Test;

import static org.junit.Assert.assertSame;


public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfAccountNumberContainsCharacters() throws InvalidAccountNumberException {
        new AccountNumber("123d-c134");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void mustThrowExceptionIfHyphenIsNotAtCenter() throws InvalidAccountNumberException {
        new AccountNumber("123412-34");
    }
}