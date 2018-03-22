import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InsufficientFundsException;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account("1234-1234", 1000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),1000 );
    }

    @Test
    public void getAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234-1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-1234",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkAccountNumber() throws InvalidAccountNumberException, MinimumBalanceException {
        new Account("1234",1000);
    }

    @Test
    public void withdraw() throws InsufficientFundsException {
        assertEquals(account.withdraw(100),900,0);
    }

    @Test(expected = InsufficientFundsException.class)
    public void checkInsufficientBalance() throws InsufficientFundsException {
        account.withdraw(1500);
    }
}
