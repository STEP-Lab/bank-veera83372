import com.thoughtworks.bank.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account("1234-1234", 2000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),2000 );
    }

    @Test
    public void getAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234-1234"));
    }
}
