import com.thoughtworks.bank.Account.Account;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void getBalance() {
        Account account = new Account("sbi-4-123", 1000);
        assertThat(account.getBalance(),is(1000));
    }
    
}
