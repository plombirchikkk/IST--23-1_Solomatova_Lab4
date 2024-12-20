// Класс RecipeCollection (группировка рецептов)
import java.util.ArrayList;
import java.util.List;

public class RecipeCollection {
    private List<Recipe> recipes; // Список рецептов

    public RecipeCollection() {
        recipes = new ArrayList<>();
    }

    // Метод для добавления рецепта
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    // Метод для получения всех рецептов
    public List<Recipe> getRecipes() {
        return recipes;
    }

    // Метод для вывода всех рецептов
    public void printAllRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("Список рецептов пуст.");
            return;
        }

        System.out.println("\n--- Все рецепты ---");
        int index = 1;
        for (Recipe recipe : recipes) {
            System.out.println(index++ + ". " + recipe.getRecipeName());  // Печатаем номер и название рецепта
            recipe.printRecipe();  // Печатаем рецепт
        }
    }




    // Новый метод для поиска рецептов по ингредиенту
    public void searchByIngredient(String ingredient) {
        boolean found = false;

        System.out.println("\n--- Рецепты с ингредиентом: " + ingredient + " ---");
        for (Recipe recipe : recipes) {
            if (recipe instanceof DishRecipe && ((DishRecipe) recipe).getIngredients().toLowerCase().contains(ingredient.toLowerCase())) {
                System.out.println(recipe.getRecipeName() +"\n"+ recipe.getDetails());
                found = true;
            } else if (recipe instanceof DrinkRecipe && ((DrinkRecipe) recipe).getIngredients().toLowerCase().contains(ingredient.toLowerCase())) {
                System.out.println(recipe.getRecipeName() +"\n"+ recipe.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Рецепты с этим ингредиентом не найдены.");
        }
    }
}
