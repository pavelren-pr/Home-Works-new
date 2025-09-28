package attestation01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void registeredUserUnderLimit() {
        BonusService service = new BonusService();
        long actual = service.calculate(1000, true); // 3% = 30
        assertEquals(30, actual);
    }

    @Test
    void registeredUserOverLimit() {
        BonusService service = new BonusService();
        long actual = service.calculate(1000000L, true); // 3% = 30000 -> limited to 500
        assertEquals(500, actual);
    }

    @Test
    void notRegisteredUser() {
        BonusService service = new BonusService();
        long actual = service.calculate(1000, false); // 1% = 10
        assertEquals(10, actual);
    }
}