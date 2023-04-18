import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {

    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTests(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] inputValues() {
        return new Object[][] {
                {IngredientType.FILLING, "Говядина", 52.954f},
                {IngredientType.SAUCE, "", 0.0f},
                {null, "JJJ", -52.954f}
        };
    }

    @Test
    public void testGetsIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Название ингредиента не соответствует ожидаемому", name, actualName);
    }

    @Test
    public void testGetsIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0001f);
    }

    @Test
    public void testGetsIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Тип ингредиента не соответствует ожидаемому", ingredientType, actualType);
    }


}
