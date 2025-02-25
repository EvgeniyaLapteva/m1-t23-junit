package account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("RUB");
        assertEquals(0, account.getAmount());
        assertEquals("RUB", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("a", "b");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccount account = new BankAccount("a", "b");
        String[] testArray = new String[] {"a", "b"};
        String[] fullName = account.getFullName();
        assertArrayEquals(fullName, testArray);
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("a", "b");
        final IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                new Executable() {
                    @Override
                    public void execute() {
                        account.getAmount();
                    }
                });
        assertEquals("Счёт не активирован.", exception.getMessage());
        assertNull(account.getCurrency());
    }
}