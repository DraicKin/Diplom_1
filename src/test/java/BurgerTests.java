import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private final float BUN_PRICE = 15.0f;
    private final float INGR_PRICE = 6.0f;
    private final String INGR_NAME = "Кетчуп";
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    private Burger setBurger(Bun bun, Ingredient ingredient){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        return burger;
    }

    @Test
    public void testGetsPrice(){
        // arrange
        Burger burger = setBurger(bun, ingredient);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGR_PRICE);
        //act
        float actualPrice = burger.getPrice();
        //assert
        Assert.assertEquals(BUN_PRICE * 2 + INGR_PRICE, actualPrice, 0.0001f);
    }

    @Test
    public void testGetRecipe() {
        final String BUN_NAME = "Булочка Банни";
        final String EXPECTED_RECEIPT
              = String.format("(==== Булочка Банни ====)%n= sauce Кетчуп =%n(==== Булочка Банни ====)%n%nPrice: " +
                "36,000000%n");
        // arrange
        Burger burger = setBurger(bun, ingredient);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGR_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(INGR_NAME);
        //act
        String actualReceipt = burger.getReceipt();
        //assert
        Assert.assertEquals("Неверный рецепт", EXPECTED_RECEIPT, actualReceipt);
    }
}
