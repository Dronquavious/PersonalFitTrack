import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;

import Goal.Goal;
import Meal.Meal;
import Report.Report;
import User.User;
import Workout.Workout;

import java.util.Scanner;

/**
 * 
 * This is a simple Java application that simulates a personal fitness tracker.
 * Users can create accounts, log in, add workouts, meals, and goals, and
 * generate reports.
 * 
 * @author Amani Kahite (https://github.com/Dronquavious)
 */

public class App {

    private static HashMap<String, User> users = new HashMap<>(); // storing users by username
    private static User loggedInUser; // currently logged in user
    private static boolean isLoggedIn = false;

    /**
     * The main entry point for the Personal FitTrack application.
     * 
     * This method initializes the application, displays a main menu to the user,
     * and provides options for creating a new user, logging in, using the tracker,
     * or exiting the application. The menu loops until the user selects the exit
     * option.
     * 
     * Main Features:
     * ASCII art for an engaging welcome screen.
     * Handles user input for menu selection.
     * Calls specific methods based on user choices.
     * 
     * @param args command-line arguments (not used in this application).
     * @throws Exception if any unexpected error occurs during the execution of the
     *                   program.
     * 
     */

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // loop variables
        boolean mainMenu = true;

        // choice variables
        int choice;

        // main menu loop
        while (mainMenu) {

            // logo ascii art
            System.out.println(
                    " ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄    ▄ ");
            System.out.println(
                    "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌");
            System.out.println(
                    "▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░▌ ▐░▌ ");
            System.out.println(
                    "▐░▌               ▐░▌          ▐░▌          ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌▐░▌  ");
            System.out.println(
                    "▐░█▄▄▄▄▄▄▄▄▄      ▐░▌          ▐░▌          ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌          ▐░▌░▌   ");
            System.out.println(
                    "▐░░░░░░░░░░░▌     ▐░▌          ▐░▌          ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌          ▐░░▌    ");
            System.out.println(
                    "▐░█▀▀▀▀▀▀▀▀▀      ▐░▌          ▐░▌          ▐░▌     ▐░█▀▀▀▀█░█▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌          ▐░▌░▌   ");
            System.out.println(
                    "▐░▌               ▐░▌          ▐░▌          ▐░▌     ▐░▌     ▐░▌  ▐░▌       ▐░▌▐░▌          ▐░▌▐░▌  ");
            System.out.println(
                    "▐░▌           ▄▄▄▄█░█▄▄▄▄      ▐░▌          ▐░▌     ▐░▌      ▐░▌ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░▌ ▐░▌ ");
            System.out.println(
                    "▐░▌          ▐░░░░░░░░░░░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌ ▐░▌");
            System.out.println(
                    " ▀            ▀▀▀▀▀▀▀▀▀▀▀       ▀            ▀       ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀   ▀ ");

            // Main menu options
            System.out.println("+-------------------------------+");
            System.out.println("| Welcome to Personal FitTrack! |");
            System.out.println("+-------------------------------+");
            System.out.println("| 1. Create a new user          |");
            System.out.println("| 2. Login to an existing user  |");
            System.out.println("| 3. Use Tracker                |");
            System.out.println("| 4. Exit                       |");
            System.out.println("+-------------------------------+");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    if (isLoggedIn) {
                        trackerMenu(scanner); // only accessible if logged in
                    } else {
                        System.out.println("You must be logged in to access the tracker.");
                    }
                    break;
                case 4:
                    mainMenu = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the tracker menu and handles user interactions for managing
     * fitness-related data.
     * 
     * This method provides a menu with options for managing goals, meals, and
     * workouts,
     * as well as generating and saving a progress report. It loops until the user
     * chooses
     * to return to the main menu.
     *
     * Main Features:
     * Add a new goal, meal, or workout.
     * View existing goals, meals, or workouts.
     * Edit goals, meals, or workouts through a submenu.
     * Generate and save a report based on the logged-in user's progress.
     * Return to the main menu.
     * 
     *
     * @param scanner a {@link Scanner} object for reading user input.
     * @throws IllegalStateException if no user is currently logged in.
     * 
     */

    public static void trackerMenu(Scanner scanner) {
        boolean choiceMenu = true;

        while (choiceMenu) {

            // tracker menu options
            System.out.println("+-----------------------------------+");
            System.out.println("|           Tracker Menu            |");
            System.out.println("+-----------------------------------+");
            System.out.println("| 1. Add a new Goal                 |");
            System.out.println("| 2. View Goals                     |");
            System.out.println("| 3. Add a new Meal                 |");
            System.out.println("| 4. View Meals                     |");
            System.out.println("| 5. Add a new Workout              |");
            System.out.println("| 6. View Workouts                  |");
            System.out.println("| 7. Generate Report                |");
            System.out.println("| 8. Edit (goals, meals or workout) |");
            System.out.println("| 9. Back to Main Menu              |");
            System.out.println("+-----------------------------------+");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userAddGoal(scanner, loggedInUser);
                    break;
                case 2:
                    System.out.println(loggedInUser.printGoals());
                    break;
                case 3:
                    userAddMeal(scanner, loggedInUser);
                    break;
                case 4:
                    System.out.println(loggedInUser.printMeals());
                    break;
                case 5:
                    userAddWorkout(scanner, loggedInUser);
                    break;
                case 6:
                    System.out.println(loggedInUser.printWorkouts());
                    break;
                case 7:
                    Report report = new Report(loggedInUser);
                    System.out.println(report.generateFullReport());
                    report.saveReportToFile("report.txt");
                    break;
                case 8:
                    userEditMenu(scanner);
                    break;
                case 9:
                    choiceMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }

    /**
     * Creates a new user by taking input for username, age, weight, and height.
     * Validates the inputs and adds the user to the system if the username is
     * unique.
     *
     * @param scanner the Scanner object for reading user input.
     */

    public static void createUser(Scanner scanner) {

        System.out.println("Enter your username:");
        String username = scanner.next().trim().toLowerCase();

        // check if username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }

        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Enter your weight:");
        double weight = scanner.nextDouble();
        System.out.println("Enter your height:");
        double height = scanner.nextDouble();

        User user = new User(username, age, weight, height);
        users.put(username, user);
        System.out.println("User created successfully!");
    }

    /**
     * Logs in a user by validating their username.
     * Displays user details (age, weight, height) upon successful login.
     *
     * @param scanner the Scanner object for reading user input.
     */

    public static void loginUser(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.next().trim().toLowerCase();

        // check if the username exists
        if (!users.containsKey(username)) {
            System.out.println("User not found. Please create an account first.");
            return;
        }

        // grab the user and display their details
        User user = users.get(username);
        System.out.println("Welcome, " + user.getName() + "! Here are your details:");
        System.out.println("Age: " + user.getAge() + " years old");
        System.out.println("Weight: " + user.getWeight() + " lbs");

        // height formatting
        double heightInFeet = user.getHeight();
        int feet = (int) heightInFeet; // the whole feet
        int inches = (int) Math.round((heightInFeet - feet) * 12);

        // printing the height in feet and inches
        System.out.println("Height: " + feet + " feet " + inches + " inches");

        // setting the loggedInUser and setting isLoggedIn to true
        loggedInUser = user;
        isLoggedIn = true;
    }

    /**
     * Prompts the user to add a new goal with details such as type, description,
     * target value, current value, and initial value. Validates the input values
     * to ensure they are non-negative.
     *
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the goal will be added.
     */
    public static void userAddGoal(Scanner scanner, User user) {

        // clearing any leftover nl characters
        scanner.nextLine();

        System.out.println("Enter What Type of Goal this is (ex: Exercise, Nutrion):");
        String type = scanner.nextLine().trim();

        System.out.println("Enter a description of the goal (ex: Run 10 miles):");
        String description = scanner.nextLine().trim();

        // error handling
        double targetValue = -1;
        while (targetValue < 0) {
            try {
                System.out.println("Enter the target value for this goal (ex: 10 miles):");
                targetValue = scanner.nextDouble();
                if (targetValue < 0) {
                    System.out.println("Target value cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the target.");
                scanner.nextLine(); // clear buffer
            }
        }

        double currentValue = -1;
        while (currentValue < 0) {
            try {
                System.out.println("Enter the current value for this goal (where you currently are):");
                currentValue = scanner.nextDouble();
                if (currentValue < 0) {
                    System.out.println("Current value cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the current value.");
                scanner.nextLine(); // clear buffer
            }
        }

        double initialValue = -1;
        while (initialValue < 0) {
            try {
                System.out.println("Enter the initial value for this goal (what you started with):");
                initialValue = scanner.nextDouble();
                if (initialValue < 0) {
                    System.out.println("Initial value cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the initial value.");
                scanner.nextLine(); // clear buffer
            }
        }

        Goal goal = new Goal(type, description, targetValue, currentValue, initialValue, false);
        user.addGoal(goal);
        System.out.println("Goal added successfully!");

    }

    /**
     * Prompts the user to add a new meal with details such as name, type, and
     * calories. Validates the input values to ensure they are non-negative.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the meal will be added.
     * 
     */
    public static void userAddMeal(Scanner scanner, User user) {

        // clearing leftover nl characters
        scanner.nextLine();

        System.out.println("Enter the name of the meal:");
        String name = scanner.nextLine().trim();

        System.out.println("Enter the type of the meal (ex: Breakfast, Lunch, Dinner):");
        String type = scanner.nextLine().trim();

        int calories = -1;
        while (calories < 0) {
            try {
                System.out.println("Enter the caloric count for the meal:");
                calories = scanner.nextInt();
                if (calories < 0) {
                    System.out.println("Caloric count cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the caloric count.");
                scanner.nextLine(); // clear buffer
            }
        }

        Meal meal = new Meal(name, calories, type, new Date());
        user.addMeal(meal);
        System.out.println("Meal added successfully!");

    }

    /**
     * Prompts the user to add a new workout with details such as type, duration,
     * and calories burned. Validates the input values to ensure they are
     * non-negative.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the workout will be added.
     * 
     */
    public static void userAddWorkout(Scanner scanner, User user) {

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println("Enter the type of the workout (ex: Running, Swimming, Cycling):");
        String type = scanner.nextLine().trim();

        int duration = -1;
        while (duration < 0) {
            try {
                System.out.println("Enter the duration of the workout in minutes:");
                duration = scanner.nextInt();
                if (duration < 0) {
                    System.out.println("Duration cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the duration.");
                scanner.nextLine(); // clear buffer
            }
        }

        int caloriesBurned = -1;
        while (caloriesBurned < 0) {
            try {
                System.out.println("Enter the calories burned during the workout:");
                caloriesBurned = scanner.nextInt();
                if (caloriesBurned < 0) {
                    System.out.println("Calories burned cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the calories burned.");
                scanner.nextLine(); // clear buffer
            }
        }

        Workout workout = new Workout(type, duration, caloriesBurned);
        user.addWorkout(workout);
        System.out.println("Workout added successfully!");
    }

    /**
     * 
     * Prompts the user to select which type of data they would like to edit.
     * Users can also remove data. or return to the tracker.
     * 
     * @param scanner the Scanner object for reading user input.
     * 
     */
    public static void userEditMenu(Scanner scanner) {
        boolean choiceMenu = true;

        while (choiceMenu) {
            System.out.println("+----------------------+");
            System.out.println("|      Edit Menu       |");
            System.out.println("+----------------------+");
            System.out.println("| 1. Edit Goals        |");
            System.out.println("| 2. Edit Workouts     |");
            System.out.println("| 3. Edit Meals        |");
            System.out.println("| 4. Remove a Goal     |");
            System.out.println("| 5. Remove a Workout  |");
            System.out.println("| 6. Remove a Meal     |");
            System.out.println("| 7. Return to Tracker |");
            System.out.println("+----------------------+");

            int choice = -1;
            while (choice < 1 || choice > 7) {
                try {
                    System.out.println("Enter your choice (1-7):");
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 7) {
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid numeric value for the choice.");
                    scanner.nextLine(); // clear buffer
                }
            }

            switch (choice) {
                case 1:
                    userEditGoals(scanner, loggedInUser);
                    break;
                case 2:
                    userEditWorkouts(scanner, loggedInUser);
                    break;
                case 3:
                    userEditMeals(scanner, loggedInUser);
                    break;
                case 4:
                    userRemoveGoal(scanner, loggedInUser);
                    break;
                case 5:
                    userRemoveWorkout(scanner, loggedInUser);
                    break;
                case 6:
                    userRemoveMeal(scanner, loggedInUser);
                    break;
                case 7:
                    choiceMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    /**
     * 
     * Prompts the user to edit a goal's details.
     * User can change the goal description, target amount, and goal Type.
     *  
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the goal will be edited.
     * 
     */
    
    public static void userEditGoals(Scanner scanner, User user) {

        // cheking if user has any goals
        if (user.getGoals().isEmpty()) {
            System.out.println("You don't have any goals to edit. Please add a goal first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printGoals());

        int goalIndex = -1;
        while (goalIndex < 0 || goalIndex >= user.getGoals().size()) {
            try {
                System.out.println("which goal would you like to edit? (1-" + (user.getGoals().size()) + ").");
                goalIndex = scanner.nextInt() - 1;
                if (goalIndex < 0 || goalIndex >= user.getGoals().size()) {
                    System.out.println("Please enter a valid goal (1-" + (user.getGoals().size()) + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the goal #.");
                scanner.nextLine(); // clear buffer
            }
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println("Enter What Type of Goal this is (ex: Exercise, Nutrion):");
        String newType = scanner.nextLine().trim();
        user.getGoals().get(goalIndex).setType(newType);

        System.out.println("Enter a Description for this Goal:");
        String newDescription = scanner.nextLine().trim();
        user.getGoals().get(goalIndex).setDescription(newDescription);

        System.out.println("Enter the Target Value for this Goal:");
        double newTargetValue = -1;
        while (newTargetValue < 0) {
            try {
                newTargetValue = scanner.nextDouble();
                if (newTargetValue < 0) {
                    System.out.println("Target value cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the target value.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getGoals().get(goalIndex).setTargetValue(newTargetValue);

        System.out.println("Enter the Current Value for this Goal:");
        double newCurrentValue = -1;
        while (newCurrentValue < 0) {
            try {
                newCurrentValue = scanner.nextDouble();
                if (newCurrentValue < 0) {
                    System.out.println("Current value cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the current value.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getGoals().get(goalIndex).setCurrentValue(newCurrentValue);

        System.out.println("Goal edited successfully!");
    }

    /**
     * 
     * Prompts the user to edit a workout's details.
     * User can change the workout type, duration, and calories burned.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the workout will be edited.
     * 
     */
    
    public static void userEditWorkouts(Scanner scanner, User user) {

        // checking if user has any workouts
        if (user.getWorkouts().isEmpty()) {
            System.out.println("You don't have any workouts to edit. Please add a workout first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printWorkouts());

        int workoutIndex = -1;
        while (workoutIndex < 0 || workoutIndex >= user.getWorkouts().size()) {
            try {
                System.out.println("Which goal would you like to edit (1-" + (user.getWorkouts().size()) + ").");
                workoutIndex = scanner.nextInt() - 1;
                if (workoutIndex < 0 || workoutIndex >= user.getWorkouts().size()) {
                    System.out.print("Please enter a valid workout (1-" + user.getWorkouts().size() + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input please enter a valid numeric value for workout #.");
                scanner.nextLine(); // clear buf
            }

        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println("Enter the type of the workout (ex: Running, Swimming, Cycling):");
        String newType = scanner.nextLine().trim();

        user.getWorkouts().get(workoutIndex).setType(newType);

        int newDuration = -1;
        while (newDuration < 0) {
            try {
                System.out.println("Enter the duration of the workout in minutes:");
                newDuration = scanner.nextInt();
                if (newDuration < 0) {
                    System.out.println("Duration cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the duration.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getWorkouts().get(workoutIndex).setDuration(newDuration);

        int newCaloriesBurned = -1;
        while (newCaloriesBurned < 0) {
            try {
                System.out.println("Enter the calories burned during the workout:");
                newCaloriesBurned = scanner.nextInt();
                if (newCaloriesBurned < 0) {
                    System.out.println("Calories burned cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the calories burned.");
                scanner.nextLine(); // clear buffer
            }
        }

        user.getWorkouts().get(workoutIndex).setCaloriesBurned(newCaloriesBurned);
        System.out.println("Workout edited successfully!");
    }

    /**
     * 
     * Prompts the user to edit a meal's details.
     * User can change the meal name, calories, and Type.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object to which the meal will be edited.
     * 
     */
    
    public static void userEditMeals(Scanner scanner, User user) {

        // checking if user has any meals
        if (user.getMeals().isEmpty()) {
            System.out.println("You don't have any meals to edit. Please add a meal first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printMeals());

        int mealIndex = -1;
        while (mealIndex < 0 || mealIndex >= user.getMeals().size()) {
            try {
                System.out.println("Which meal would you like to edit (1-" + (user.getMeals().size()) + ").");
                mealIndex = scanner.nextInt() - 1;
                if (mealIndex < 0 || mealIndex >= user.getMeals().size()) {
                    System.out.println("Please enter a valid meal (1-" + user.getMeals().size() + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for meal #.");
                scanner.nextLine(); // clear buffer
            }
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println("Enter the name of the meal:");
        String newName = scanner.nextLine().trim();

        user.getMeals().get(mealIndex).setName(newName); // new meal name

        System.out.println("Enter the type of the meal (ex: Breakfast, Lunch, Dinner):");
        String newType = scanner.nextLine().trim();

        user.getMeals().get(mealIndex).setMealType(newType); // new meal type

        int newCalories = -1;
        while (newCalories < 0) {
            try {
                System.out.println("Enter the caloric count for the meal:");
                newCalories = scanner.nextInt();
                if (newCalories < 0) {
                    System.out.println("Caloric count cannot be negative. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for the caloric count.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getMeals().get(mealIndex).setCalories(newCalories); // new meal calories

        System.out.println("Meal edited successfully!");

    }

    /**
     * 
     * Prompts the user to remove a goal from their list.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user    the User object from which the goal will be removed.
     * 
     */
    
    public static void userRemoveGoal(Scanner scanner, User user) {

        // checking if user has any goals
        if (user.getGoals().isEmpty()) {
            System.out.println("You don't have any goals to remove. Please add a goal first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printGoals());

        System.out.println("Which goal would you like to remove (1-" + (user.getGoals().size()) + ").");
        int goalIndex = -1;
        while (goalIndex < 0 || goalIndex >= user.getGoals().size()) {
            try {
                goalIndex = scanner.nextInt() - 1;
                if (goalIndex < 0 || goalIndex >= user.getGoals().size()) {
                    System.out.println("Please enter a valid goal (1-" + user.getGoals().size() + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for goal #.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getGoals().remove(goalIndex);
        System.out.println("Goal removed successfully!");
    }

    
    /**
     * 
     * Prompts the user to remove a workout from their list.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user   the User object from which the workout will be removed.
     * 
     */
    public static void userRemoveWorkout(Scanner scanner, User user) {

        // checking if user has any workouts
        if (user.getWorkouts().isEmpty()) {
            System.out.println("You don't have any workouts to remove. Please add a workout first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printWorkouts());

        System.out.println("Which workout would you like to remove (1-" + (user.getWorkouts().size()) + ").");
        int workoutIndex = -1;
        while (workoutIndex < 0 || workoutIndex >= user.getWorkouts().size()) {
            try {
                workoutIndex = scanner.nextInt() - 1;
                if (workoutIndex < 0 || workoutIndex >= user.getWorkouts().size()) {
                    System.out.println("Please enter a valid workout (1-" + user.getWorkouts().size() + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for workout #.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getWorkouts().remove(workoutIndex);

        System.out.println("Workout removed successfully!");
    }

    /**
     * 
     * prompts the user to remove a meal from their list.
     * 
     * @param scanner the Scanner object for reading user input.
     * @param user   the User object from which the meal will be removed.
     */
    
    public static void userRemoveMeal(Scanner scanner, User user) {
        if (user.getMeals().isEmpty()) {
            System.out.println("You don't have any meals to remove. Please add a meal first.");
            return;
        }

        // clear leftover nl characters
        scanner.nextLine();

        System.out.println(user.printMeals());

        System.out.println("Which meal would you like to remove (1-" + (user.getMeals().size()) + ").");
        int mealIndex = -1;
        while (mealIndex < 0 || mealIndex >= user.getMeals().size()) {
            try {
                mealIndex = scanner.nextInt() - 1;
                if (mealIndex < 0 || mealIndex >= user.getMeals().size()) {
                    System.out.println("Please enter a valid meal (1-" + user.getMeals().size() + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for meal #.");
                scanner.nextLine(); // clear buffer
            }
        }
        user.getMeals().remove(mealIndex);

        System.out.println("Meal removed successfully!");
    }
}
