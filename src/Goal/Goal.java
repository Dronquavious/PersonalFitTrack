package Goal;

/**
 *  Goal class to hold user's fitness goals.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious)
 */

public class Goal {
    private String Type; // type of goal (e.g., weight loss, exercise, etc.)
    private String description;
    private double targetValue;
    private double currentValue; // progress towards the goal
    private double initialValue; // initial value of the goal
    boolean completed;

    // constructor
    public Goal(String Type, String description, double targetValue, double currentValue,
            double initialValue, boolean completed) {
        this.Type = Type;
        this.description = description;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.initialValue = initialValue; // set initial value to current value upon creation
        this.completed = completed;
    }

    // getters and setters

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public boolean isCompleted() {
        if (targetValue == currentValue) {
            return true; // goal achieved
        } 
        
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * 
     * method to calculate progress towards the goal.
     * 
     * @returns the progress as a percentage (0-100)
     * 
     */
    public double calculateProgress() {
        if (targetValue == currentValue) {
            return 100.0; // goal achieved
        } else if (targetValue > initialValue) {
            // for goals where we're trying to increase (e.g., weight gain, muscle gain)
            double totalChange = targetValue - initialValue;
            double actualChange = currentValue - initialValue;
            return (actualChange / totalChange) * 100;
        } else {
            // for goals where we're trying to decrease (e.g., weight loss)
            return ((initialValue - currentValue) / (initialValue - targetValue)) * 100;
        }
    }

    // toString method to display goal details
    @Override
    public String toString() {
        if (calculateProgress() == 100.0) {
            setCompleted(true);
        }

        return "Goal: " + description +
                "\nTarget Value: " + targetValue +
                "\nCurrent Value: " + currentValue +
                "\nProgress: " + String.format("%.2f",calculateProgress()) + "%" +
                "\nCompleted: " + (completed ? "Yes" : "No") +
                "\n-----------------------------------------";
    }

}
