    import java.util.Scanner;

    public class RecipeManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Создание коллекции рецептов
            RecipeCollection recipeCollection = new RecipeCollection();


            while (true) {
                // Главное меню программы
                System.out.println("\n--- Меню ---");
                System.out.println("1. Добавить рецепт блюда");  // Добавление рецепта блюда
                System.out.println("2. Добавить рецепт напитка"); // Добавление рецепта напитка
                System.out.println("3. Удалить рецепт");          // Удаление рецепта
                System.out.println("4. Показать все рецепты");    // Показ всех рецептов
                System.out.println("5. Искать рецепт по ингредиенту"); // Поиск рецептов по ингредиенту
                System.out.println("6. Выйти");                   // Завершение работы программы
                System.out.print("Выберите опцию: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        // Добавление рецепта блюда
                        addDishRecipe(scanner, recipeCollection);
                        break;

                    case "2":
                        // Добавление рецепта напитка
                        addDrinkRecipe(scanner, recipeCollection);
                        break;

                    case "3":
                        // Удаление рецепта
                        removeRecipe(scanner, recipeCollection);
                        break;

                    case "4":
                        // Показ всех рецептов
                        recipeCollection.printAllRecipes();
                        break;

                    case "5":
                        // Поиск рецептов по ингредиенту
                        searchRecipeByIngredient(scanner, recipeCollection);
                        break;

                    case "6":
                        // Выход из программы
                        System.out.println("Выход из программы.");
                        return;

                    default:
                        // Обработка неверного ввода
                        System.out.println("Неверный выбор, попробуйте снова.");
                }
            }
        }

        /**
         * Метод для добавления рецепта блюда.
         * @param scanner - объект Scanner для считывания ввода.
         * @param collection - коллекция рецептов.
         */
        private static void addDishRecipe(Scanner scanner, RecipeCollection collection) {
            System.out.println("Введите название блюда:");
            String name = scanner.nextLine();

            System.out.println("Введите ингредиенты блюда (через запятую):");
            String ingredients = scanner.nextLine();

            System.out.println("Введите инструкции по приготовлению блюда:");
            String instructions = scanner.nextLine();

            // Создание нового рецепта блюда
            DishRecipe dishRecipe = new DishRecipe(name, ingredients, instructions);
            collection.addRecipe(dishRecipe); // Добавление рецепта в коллекцию
            System.out.println("Рецепт блюда добавлен.");
        }

        /**
         * Метод для добавления рецепта напитка.
         * @param scanner - объект Scanner для считывания ввода.
         * @param collection - коллекция рецептов.
         */
        private static void addDrinkRecipe(Scanner scanner, RecipeCollection collection) {
            System.out.println("Введите название напитка:");
            String name = scanner.nextLine();

            System.out.println("Введите ингредиенты напитка (через запятую):");
            String ingredients = scanner.nextLine();

            System.out.println("Введите инструкции по приготовлению напитка:");
            String instructions = scanner.nextLine();

            // Пример ввода дополнительных параметров
            System.out.println("Введите время приготовления напитка (в минутах):");
            String prepTime = scanner.nextLine();

            System.out.println("Введите сложность напитка (например, 'Легко', 'Средне', 'Сложно'):");
            String difficulty = scanner.nextLine();

            // Создание нового рецепта напитка
            DrinkRecipe drinkRecipe = new DrinkRecipe(name, ingredients, instructions, prepTime, difficulty);
            collection.addRecipe(drinkRecipe);
            System.out.println("Рецепт напитка добавлен.");
        }


        /**
         * Метод для удаления рецепта.
         * @param scanner - объект Scanner для считывания ввода.
         * @param collection - коллекция рецептов.
         */
        private static void removeRecipe(Scanner scanner, RecipeCollection collection) {
            if (collection.getRecipes().isEmpty()) {
                System.out.println("Список рецептов пуст. Удаление невозможно.");
                return;
            }

            // Показ списка рецептов с номерами
            System.out.println("\n--- Список рецептов ---");
            int index = 1;
            for (Recipe recipe : collection.getRecipes()) {
                System.out.println(index++ + ". " + recipe.getRecipeName());
            }

            // Ввод номера рецепта для удаления
            System.out.print("Введите номер рецепта для удаления: ");
            int recipeIndex;
            try {
                recipeIndex = Integer.parseInt(scanner.nextLine()); // Проверка ввода на число
                if (recipeIndex < 1 || recipeIndex > collection.getRecipes().size()) {
                    System.out.println("Неверный номер рецепта.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число.");
                return;
            }

            // Удаление рецепта
            Recipe removedRecipe = collection.getRecipes().remove(recipeIndex - 1);
            System.out.println("Рецепт \"" + removedRecipe.getRecipeType() + "\" удалён.");
        }

        /**
         * Метод для поиска рецептов по ингредиенту.
         * @param scanner - объект Scanner для считывания ввода.
         * @param collection - коллекция рецептов.
         */
        private static void searchRecipeByIngredient(Scanner scanner, RecipeCollection collection) {
            System.out.println("Введите ингредиент для поиска:");
            String ingredient = scanner.nextLine();

            // Поиск рецептов по ингредиенту
            collection.searchByIngredient(ingredient);
        }
    }