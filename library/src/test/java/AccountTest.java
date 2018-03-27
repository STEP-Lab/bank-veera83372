import com.thoughtworks.bank.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account(new AccountNumber("1234-1234"), 1100);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),1100,0 );
    }


    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-1234"),200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkAccountNumber() throws InvalidAccountNumberException, MinimumBalanceException {
        new Account(new AccountNumber("1234"),1000);
    }

    @Test
    public void withdraw() throws MinimumBalanceException {
        assertEquals(account.withdraw(100,"veera"),1000,0);
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkInsufficientBalance() throws MinimumBalanceException {
        account.withdraw(1500,"veeru");
    }
    @Test
    public void credit() {
        assertThat(account.credit(200.0,"Account"), is(1300.0));
        assertThat(account.getBalance(), is(1300.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void withdrawMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-1234"), 1000).withdraw(200.0, "Account");
    }
}
