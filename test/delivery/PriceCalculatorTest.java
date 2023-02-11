package delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    private Executable generateExecutable(TransportType type, int distance) {
        return () -> priceCalculator.calculatePrice(type, distance);
    }

    @Test
    public void shouldReturn200ForBikeAndDistanceIs20Km() {
        int expectedPrice = 200;
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 20);
        Assertions.assertEquals(expectedPrice, price);
    }

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs21Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 21)
        );
        Assertions.assertEquals("Bike can not go for more than 20 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        int expectedPrice = 7000;
        int price = priceCalculator.calculatePrice(TransportType.CAR, 1000);
        Assertions.assertEquals(expectedPrice, price);
    }

    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs1001Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 1001)
        );
        Assertions.assertEquals("Car can not go for more than 1000 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenTruckAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.TRUCK, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        int expectedPrice = 5000;
        int price = priceCalculator.calculatePrice(TransportType.TRUCK, 1000);
        Assertions.assertEquals(expectedPrice, price);
    }

    @Test
    public void tryDeliveryByDrone() {
        UnsupportedOperationException exception = Assertions.assertThrows(
                UnsupportedOperationException.class,
                generateExecutable(TransportType.DRONE, 500)
                );
        Assertions.assertEquals("transport type '" + TransportType.DRONE + "' is not handled correctly",
                exception.getMessage());
    }
}