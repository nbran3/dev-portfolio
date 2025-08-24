import java.io.FileWriter;
import java.io.PrintWriter;

// DebtPayoffCalculator is a program that estimates the monthly payment 
// and interest accrued on a debt based on user inputs (principal, interest rate, and months).
// It allows users to restart calculations, export results to a file, or view the formulas used.
public class DebtPayoffCalculator {

    // MonthlyCalc takes in the principal balance, the interest rate, and the number of months. 
    // It returns the estimated monthly payment amount the user would need to pay.
    public static double MonthlyCalc(double principal, float interest, int months){
            double monthlyAmount = -Math.log(principal / months) / -Math.log(1 + interest);
            monthlyAmount = Math.round(monthlyAmount);
            return monthlyAmount;
    }

    // InterestCalc takes in the principal balance, the interest rate, and the number of months. 
    // It returns the estimated total interest accrued over the given number of months.
    public static double InterestCalc(double principal, float interest, int months){
        double dailyInterest = interest / 365;
        double dailyAccural = principal * dailyInterest;
        double days = months * 30;
        return Math.round(dailyAccural * days);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Java Debt Payoff Calculator");

            java.util.Scanner input = new java.util.Scanner(System.in);

            // Initialize principal variable
            double principal = 0;
            
            // Prompt the user for the principal balance of the debt. 
            // If the input is invalid (negative or not a number), the program asks again until a valid input is given.
            while (true) {
                System.out.println("Please enter the principal balance of your debt:");
                try {
                    principal = input.nextDouble();
                    input.nextLine();
                    if (principal <= 0) {
                        System.out.println("Error: Principal balance must be a positive number. Please try again.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    input.nextLine();
                }
            }

            // Initialize interest variable
            float interest = 0;
            
            // Prompt the user for the interest rate. 
            // If the input is invalid (negative, zero, or not a number), the program asks again until a valid input is given.
            while (true) {
                System.out.println("Please enter the interest rate:");
                try {
                    interest = input.nextFloat();
                    input.nextLine();
                    if (interest <= 0) {
                        System.out.println("Error: Interest rate cannot be negative or zero. Please try again.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    input.nextLine();
                }
            }

            // Initialize months variable
            int months = 0;
            
            // Prompt the user for the number of months to pay off the debt. 
            // If the input is invalid (negative, zero, or not an integer), the program asks again until a valid input is given.
            while (true) {
                System.out.println("Please enter the number of months you want to pay off your debt:");
                try {
                    months = input.nextInt();
                    input.nextLine();
                    if (months <= 0) {
                        System.out.println("Error: Number of months must be a positive integer. Please try again.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid integer.");
                    input.nextLine();
                }
            }

            // userAmount stores the estimated monthly payment calculated from MonthlyCalc
            double userAmount = MonthlyCalc(principal, interest, months);

            // userAccuredInterest stores the estimated total interest calculated from InterestCalc
            double userAccuredInterest = InterestCalc(principal, interest, months);

            // Display the results of the calculations to the user
            System.out.println("Monthly Amount: $" + userAmount + " for " + months + " months");
            System.out.println("Accured Interest: $" + userAccuredInterest);

            // Prompt the user for the next action
            System.out.println("What would you like to do?");
            System.out.println("Type 'Exit', 'Restart Calculations', 'Export Data', or 'See Calculations'.");

            String choice = input.nextLine();

            // Exit option: closes the scanner and ends the program
            if(choice.equalsIgnoreCase("Exit")){
                input.close();
                break;
            } 
            // Restart Calculations option: clears inputs and starts the program over from the beginning
            else if (choice.equalsIgnoreCase("Restart Calculations")) {
                continue;
            } 
            // Export Data option: saves the results to a text file
            else if (choice.equalsIgnoreCase("Export Data")) {
                System.out.println("What would you like to name the file?");
                String fileName = input.nextLine();
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }

                try {
                    // Count the existing lines in the file to number each new entry
                    int lineCount = 0;
                    java.io.File file = new java.io.File(fileName);
                    if (file.exists()) {
                        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
                            while (reader.readLine() != null) {
                                lineCount++;
                            }
                        }
                    }

                    // Append new data to the file with the next line number
                    try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileName, true);
                         java.io.PrintWriter out = new java.io.PrintWriter(fileWriter)) {

                        lineCount++; 
                        out.println(lineCount + ". Monthly Payment: $" + String.format("%.2f", userAmount) +
                                " | Accrued Interest: $" + String.format("%.2f", userAccuredInterest) +
                                " | Principal: $" + String.format("%.2f", principal) +
                                " | Interest Rate: " + interest + "% | Months: " + months);

                        System.out.println("Data successfully exported to " + fileName);
                    }
                } catch (java.io.IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            } 
            // See Calculations option: shows the formulas and intermediate values used in the calculations
            else if (choice.equalsIgnoreCase("See Calculations")) {
                System.out.println("Monthly Amount Calculation:");
                System.out.println("N = -Math.log(" + principal + " / " + months + ") / -Math.log(1 + " + interest + ")");
                System.out.println("Calculated Monthly Amount = $" + userAmount);

                System.out.println("\nInterest Calculation:");
                System.out.println("dailyInterest = " + interest + " / 365");
                System.out.println("dailyAccural = principal * dailyInterest = " + (principal * (interest / 365)));
                System.out.println("Total Accrued Interest over " + months + " months = " + userAccuredInterest);
            } 
            // Handles any input that does not match the menu options
            else{
                System.out.println("Invalid choice");
            }
        }

        // The program will continue looping until the user chooses to exit
    }
}







