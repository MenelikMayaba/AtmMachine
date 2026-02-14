package aCompany;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {

    private ATM atm;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("12345", "0000", 500.00);
        atm = new ATM();
        atm.addAccount(account);
    }

    @Test
    void testLoginSuccess() {
        assertTrue(atm.login("12345", "0000"));
    }

    @Test
    void testLoginFailsWrongPin() {
        assertFalse(atm.login("12345", "9999"));
    }

    @Test
    void testDepositIncreasesBalance() {
        atm.login("12345", "0000");
        atm.deposit(200);

        assertEquals(700, atm.checkBalance());
    }

    @Test
    void testWithdrawDecreasesBalance() {
        atm.login("12345", "0000");
        atm.withdraw(100);

        assertEquals(400, atm.checkBalance());
    }

    @Test
    void testWithdrawFailsIfInsufficientFunds() {
        atm.login("12345", "0000");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            atm.withdraw(1000);
        });

        assertEquals("Insufficient funds", ex.getMessage());
    }

    @Test
    void testDepositFailsIfNegative() {
        atm.login("12345", "0000");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            atm.deposit(-50);
        });

        assertEquals("Deposit amount must be positive", ex.getMessage());
    }

    @Test
    void testWithdrawFailsIfNegative() {
        atm.login("12345", "0000");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            atm.withdraw(-20);
        });

        assertEquals("Withdraw amount must be positive", ex.getMessage());
    }

    @Test
    void testCannotDepositWithoutLogin() {
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            atm.deposit(100);
        });

        assertEquals("No user logged in", ex.getMessage());
    }

    @Test
    void testLogoutEndsSession() {
        atm.login("12345", "0000");
        atm.logout();

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            atm.checkBalance();
        });

        assertEquals("No user logged in", ex.getMessage());
    }
}

