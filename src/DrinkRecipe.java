public class DrinkRecipe extends Recipe {
    private String ingredients; // Ингредиенты
    private String prepTime;  // Время приготовления
    private String difficulty; // Сложность

    // Конструктор для DrinkRecipe
    public DrinkRecipe(String name, String ingredients, String instructions, String prepTime, String difficulty) {
        super(name); // Вызов конструктора суперкласса Recipe
        this.ingredients = ingredients;
        this.prepTime = prepTime;
        this.difficulty = difficulty;
    }

    // Геттер для ингредиентов
    public String getIngredients() {
        return ingredients;
    }

    // Геттер для времени приготовления
    public String getPrepTime() {
        return prepTime;
    }

    // Геттер для сложности
    public String getDifficulty() {
        return difficulty;
    }

    // Реализация абстрактного метода getRecipeType()
    @Override
    public String getRecipeType() {
        return "Напиток";
    }

    // Реализация абстрактного метода getDetails()
    @Override
    public String getDetails() {
        return "Ингредиенты: " + ingredients + "\nВремя приготовления: " + prepTime + "\nСложность: " + difficulty;
    }

    // Переопределённый метод для печати рецепта
    @Override
    public void printRecipe() {
        System.out.println(getDetails());    // Выводим детали
    }
}
