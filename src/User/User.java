package User;

import java.util.ArrayList;
import java.util.List;

import Goal.Goal;
import Meal.Meal;
import Workout.Workout;

/**
 * 
 * User class to represent a user.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious)
 * 
 */

public class User {
    private String name;
    private int age;
    private double weight;
    private double height;
    private List<Workout> workouts; // user's workouts
    private List<Meal> meals; // user's meals
    private List<Goal> goals; // user's goals

    // user's workouts
    public void addWorkout(Workout workout) {
        if (this.workouts == null) {
            this.workouts = new ArrayList<>();
        }
        this.workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        if (this.workouts == null || this.workouts.isEmpty()) {
            return new ArrayList<>();
        }
        return this.workouts;
    }

    // printing the user's workouts
    public String printWorkouts() {
        if (this.workouts == null || this.workouts.isEmpty()) {
            return "No workouts recorded for " + capitalizeName(this.getName()) + ".";
        }

        StringBuilder result = new StringBuilder(capitalizeName(this.getName()) + "'s Workouts:\n");
        for (Workout workout : this.workouts) {
            result.append(workout.toString()).append("\n");
        }
        return result.toString();
    }

    // user's meals
    public void addMeal(Meal meal) {
        if (this.meals == null) {
            this.meals = new ArrayList<>(); // initialize the list if it's null
        }
        this.meals.add(meal);
    }


    // getting the user's meals
    public List<Meal> getMeals() {
        if (this.meals == null || this.meals.isEmpty()) {
            return new ArrayList<>();
        }
        return this.meals;
    }

    // printing the user's meals
    public String printMeals() {
        if (this.meals == null || this.meals.isEmpty()) {
            return "No meals recorded for " + capitalizeName(this.getName()) + ".";
        }

        StringBuilder result = new StringBuilder(capitalizeName(this.getName()) + "'s Meals:\n");
        for (Meal meal : this.meals) {
            result.append(meal.toString()).append("\n");
        }
        return result.toString();
    }

    // user's goals
    public void addGoal(Goal goal) {
        if (this.goals == null) {
            this.goals = new ArrayList<>();
        }
        this.goals.add(goal);
    }

    // getting the user's goals
    public List<Goal> getGoals() {
        if (this.goals == null || this.goals.isEmpty()) {
            return new ArrayList<>();
        }
        return this.goals;
    }

    // printing the user's goals
    public String printGoals() {
        if (this.goals == null || this.goals.isEmpty()) {
            return "No goals recorded for " + capitalizeName(this.getName()) + ".";
        }

        StringBuilder result = new StringBuilder(capitalizeName(this.getName()) + "'s Goals:\n");
        for (Goal goal : this.goals) {
            result.append(goal.toString()).append("\n");
        }
        return result.toString();
    }

    // constructor
    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.workouts = new ArrayList<Workout>();
        this.meals = new ArrayList<Meal>();
        this.goals = new ArrayList<Goal>();
    }

    // getters and setters
    public String getName() {
        return capitalizeName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    // capitalize the first letter of the name
    private String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

}
