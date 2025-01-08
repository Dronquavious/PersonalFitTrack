package Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Goal.Goal;
import Meal.Meal;
import User.User;
import Workout.Workout;

/**
 * 
 * This class generates a report for a user.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious)
 * 
 */

public class Report 
{
    private User user;
    private String reportContent; // content of the report
    private File reportFile; // file to save the report to (maybe)

    // constructor
    public Report(User user) {
        this.user = user;
        this.reportContent = "";
    }

    // summary of all workouts
    public String generateWorkoutSummary(){
        StringBuilder summary = new StringBuilder();

        List<Workout> workouts = user.getWorkouts();

        summary.append("Workout Summary:\n");
        summary.append("-----------------\n");

        if (workouts.isEmpty()) {
            summary.append("No workouts recorded yet.\n");
        } else {
            int totalDuration = 0;
            int totalCalories = 0;

            for (Workout workout : workouts) {
                summary.append(String.format(
                    "- %s | Duration: %d mins | Calories Burned: %d\n",
                    workout.getType(),
                    workout.getDuration(),
                    workout.getCaloriesBurned()
                ));
                totalDuration += workout.getDuration();
                totalCalories += workout.getCaloriesBurned();
            }

            summary.append("\nTotal Workouts: ").append(workouts.size()).append("\n");
            summary.append("Total Duration: ").append(totalDuration).append(" mins\n");
            summary.append("Total Calories Burned: ").append(totalCalories).append("\n");
        }

        summary.append("\n");
        return summary.toString();
    }

    // Generate a summary of meals
    public String generateMealSummary() {
        StringBuilder summary = new StringBuilder();
        List<Meal> meals = user.getMeals();

        summary.append("Meal Summary:\n");
        summary.append("-------------\n");

        if (meals.isEmpty()) {
            summary.append("No meals logged yet.\n");
        } else {
            int totalCalories = 0;

            for (Meal meal : meals) {
                summary.append(String.format(
                    "- %s | Calories: %d | Type: %s\n",
                    meal.getName(),
                    meal.getCalories(),
                    meal.getMealType()
                ));
                totalCalories += meal.getCalories();
            }

            summary.append("\nTotal Meals Logged: ").append(meals.size()).append("\n");
            summary.append("Total Calories Consumed: ").append(totalCalories).append(" kcal\n");
        }

        summary.append("\n");
        return summary.toString();
    }

    // Generate a summary of goals
    public String generateGoalSummary() {
        StringBuilder summary = new StringBuilder();
        List<Goal> goals = user.getGoals();

        summary.append("Goal Summary:\n");
        summary.append("-------------\n");

        if (goals.isEmpty()) {
            summary.append("No goals set yet.\n");
        } else {
            for (Goal goal : goals) {
                summary.append(String.format(
                    "- %s | Target: %.2f | Progress: %.2f | Status: %s\n",
                    goal.getType(),
                    goal.getTargetValue(),
                    goal.getCurrentValue(),
                    goal.isCompleted() ? "Completed" : "In Progress"
                ));
            }
        }

        summary.append("\n");
        return summary.toString();
    }

    // Generate a full report
    public String generateFullReport() {
        StringBuilder fullReport = new StringBuilder();

        fullReport.append("Fitness Tracker Report for ").append(user.getName()).append("\n");
        fullReport.append("=================================================\n\n");

        fullReport.append(generateWorkoutSummary());
        fullReport.append(generateMealSummary());
        fullReport.append(generateGoalSummary());

        reportContent = fullReport.toString();
        return reportContent;
    }

    // Save the report to a file
    public void saveReportToFile(String fileName) {
        try {
            // replace spaces with underscores and convert to lowercase for file name consistency
            File file = new File( user.getName().replaceAll("\\s+", "_").toLowerCase() + fileName);
            FileWriter writer = new FileWriter(file);

            if (reportContent == null || reportContent.isEmpty()) {
                generateFullReport(); // generate the report if it hasn't been generated yet
            }

            writer.write(reportContent);
            writer.close();

            System.out.println("Report saved successfully to " + file.getAbsolutePath()); // print the file path
        } catch (IOException e) {
            System.out.println("Error saving report to file: " + e.getMessage());
        }
    }
}
