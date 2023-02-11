package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FortuneCookieControllerTest {
    static FortuneСookieController goodFactoryController;
    static FortuneСookieController badFactoryController;

    @BeforeAll
    public static void beforeAll() {
        goodFactoryController = new FortuneСookieController(new FortuneCookieFactory(new FortuneConfig(true),
                Collections.singletonList("positive"), Collections.singletonList("negative")));
        badFactoryController = new FortuneСookieController(new FortuneCookieFactory(new FortuneConfig(false),
                Collections.singletonList("positive"), Collections.singletonList("negative")));

    }

    @Test
    public void shouldReturnPositiveFortune() {
        FortuneCookie cookie = goodFactoryController.tellFortune();
        Assertions.assertEquals("positive",cookie.getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        FortuneCookie cookie = badFactoryController.tellFortune();
        Assertions.assertEquals("negative", cookie.getFortuneText());
    }
}
