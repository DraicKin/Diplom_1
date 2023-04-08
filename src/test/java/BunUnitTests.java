import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunUnitTests {

    private Bun bun;
    private final String NAME = "Флюоресцентная булка R2-D3";
    private final float PRICE = 988.5246f;

    @Test
    public void testGetsName() {
        // arrange
        bun = new Bun(NAME, PRICE);
        // act
        String actualName = bun.getName();
        // assert
        Assert.assertEquals("Неверное имя булки!", NAME, actualName);
    }

    @Test
    public void testGetsPrice() {
        // arrange
        bun = new Bun(NAME, PRICE);
        // act
        float actualPrice = bun.getPrice();
        // assert
        Assert.assertEquals(PRICE, actualPrice, 0.0001f);
    }
}
