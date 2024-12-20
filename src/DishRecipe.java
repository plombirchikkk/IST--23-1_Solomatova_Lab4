public class DishRecipe extends Recipe {
    private String ingredients; // Ингредиенты
    private String instructions; // Инструкции приготовления

    // Конструктор для инициализации рецепта
    public DishRecipe(String recipeName, String ingredients, String instructions) {
        super(recipeName); // Вызов конструктора родительского класса с названием рецепта
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Переопределение метода getDetails для вывода деталей рецепта
    @Override
    public String getDetails() {
        return "Ингредиенты: " + ingredients + "\nИнструкции: " + instructions;
    }

    // Метод для получения списка ингредиентов
    public String getIngredients() {
        return ingredients;
    }

    // Реализация абстрактного метода getRecipeType()
    @Override
    public String getRecipeType() {
        return "Блюдо"; // Возвращаем тип рецепта как "Блюдо"
    }

    // Переопределение метода для печати рецепта
    @Override
    public void printRecipe() {
        System.out.println(getDetails());    // Выводим детали
    }
}
