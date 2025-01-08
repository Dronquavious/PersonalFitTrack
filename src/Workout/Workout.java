package Workout;

/**
 * 
 * Workout class to represent a workout.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious) 
 */
public class Workout 
{
    private String type;
    private int duration;
    private int caloriesBurned;

    // constructor
    public Workout(String type, int duration, int caloriesBurned)
    {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    // getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getCaloriesBurned() {
        return caloriesBurned;
    }
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    // toString method to display workout details
    @Override
    public String toString() {
        return "Workout: " + type + 
        "\nDuration: " + duration + " minutes" +
        "\nCalories Burned: " + caloriesBurned +
        "\n-----------------------------------------";
    }


}
