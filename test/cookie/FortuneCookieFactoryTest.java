package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FortuneCookieFactoryTest {

    private static FortuneCookieFactory factory;

    @BeforeEach
    public void beforeEach() {
        factory = new FortuneCookieFactory(new FortuneConfig(true),
                Collections.singletonList("positive"),
                Collections.singletonList("negative"));
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        factory.bakeFortuneCookie();
        Assertions.assertEquals(1, factory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        Assertions.assertEquals(2, factory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        factory.bakeFortuneCookie();
        factory.resetCookiesCreated();
        Assertions.assertEquals(0, factory.getCookiesBaked());
    }
}