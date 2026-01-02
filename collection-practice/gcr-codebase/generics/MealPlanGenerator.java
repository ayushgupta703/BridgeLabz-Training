interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    T mealType;

    Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Your personalized meal plan: " + meal.getMealType().getMealType());
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());

        generateMealPlan(vegMeal);
        generateMealPlan(ketoMeal);
    }
}