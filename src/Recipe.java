public abstract class Recipe {
    private String recipeName; // Название рецепта

    // Конструктор для инициализации названия рецепта
    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    // Метод для получения названия рецепта
    public String getRecipeName() {
        return recipeName;
    }

    // Абстрактный метод для получения деталей рецепта
    public abstract String getDetails();

    // Абстрактный метод для получения типа рецепта
    public abstract String getRecipeType();

    // Метод для печати рецепта
    public void printRecipe() {
        System.out.println(getDetails());
    }

    // Переопределение метода toString для вывода информации о рецепте
    @Override
    public String toString() {
        return getDetails();
    }
}
