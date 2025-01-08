package Meal;
import java.util.Date;

/**
 * 
 * Meal class to hold user's meal details.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious)
 */

public class Meal 
{
    private String name;
    private int calories;
    private String mealType; // can be Breakfast, Lunch, Dinner, Snack, etc. 
    private Date date;

    // constructor
    public Meal(String name, int calories, String mealType, Date date) 
    {
        this.name = name;
        this.calories = calories;
        this.mealType = mealType;
        this.date = date;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // toString method to print meal details
    @Override
    public String toString() 
    {
        
        return "Meal : " + name +
                "\nCalories : " + calories +
                "\nMeal Type : " + mealType +
                "\nDate : " + date +
                "\n-----------------------------------------";
    }
}
