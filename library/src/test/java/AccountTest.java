import com.thoughtworks.bank.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void getBalance() {
        Account account = new Account("1234-1234", 2000);
        assertEquals(account.getBalance(),2000 );
    }
}
