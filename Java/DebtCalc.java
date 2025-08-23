import java.io.FileWriter;
import java.io.PrintWriter;

public class DebtPayoffCalculator {

    public static double MonthlyCalc(double principal, float interest, int months){
            double monthlyAmount = -Math.log(principal / months) / -Math.log(1 + interest);
            monthlyAmount = Math.round(monthlyAmount);
            return monthlyAmount;

    }

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

            double principal = 0;
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


            float interest = 0;
            while (true) {
                System.out.println("Please enter the interest rate:");
                try {
                    interest = input.nextFloat();
                    input.nextLine();
                    if (interest < 0) {
                        System.out.println("Error: Interest rate cannot be negative. Please try again.");
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    input.nextLine();
                }
            }

            int months = 0;
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

            double userAmount = MonthlyCalc(principal, interest, months);
            double userAccuredInterest = InterestCalc(principal, interest, months);

            System.out.println("Monthly Amount: $" + userAmount + " for " + months + " months");
            System.out.println("Accured Interest: $" + userAccuredInterest);

            System.out.println("What would you like to do?");
            System.out.println("Type 'Exit', 'Restart Calculations', 'Export Data', or 'See Calcuations'.");

            String choice = input.nextLine();

            if(choice.equalsIgnoreCase("Exit")){
                input.close();
                break;
            } else if (choice.equalsIgnoreCase("Restart Calculations")) {
                continue;
            } else if (choice.equalsIgnoreCase("Export Data")) {
                System.out.println("What would you like to name the file?");
                String fileName = input.nextLine();
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }

                try {
                    // Read existing file to count lines
                    int lineCount = 0;
                    java.io.File file = new java.io.File(fileName);
                    if (file.exists()) {
                        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
                            while (reader.readLine() != null) {
                                lineCount++;
                            }
                        }
                    }

                    // Write new data with line number
                    try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileName, true);
                         java.io.PrintWriter out = new java.io.PrintWriter(fileWriter)) {

                        lineCount++; // Increment for the new entry
                        out.println(lineCount + ". Monthly Payment: $" + String.format("%.2f", userAmount) +
                                " | Accrued Interest: $" + String.format("%.2f", userAccuredInterest) +
                                " | Principal: $" + String.format("%.2f", principal) +
                                " | Interest Rate: " + interest + "% | Months: " + months);

                        System.out.println("Data successfully exported to " + fileName);
                    }

                } catch (java.io.IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }




            } else if (choice.equalsIgnoreCase("See Calculations")) {
                System.out.println("Monthly Amount Calculation:");
                System.out.println("N = -Math.log(" + principal + " / " + months + ") / -Math.log(1 + " + interest + ")");
                System.out.println("Calculated Monthly Amount = $" + userAmount);

                System.out.println("\nInterest Calculation:");
                System.out.println("dailyInterest = " + interest + " / 365");
                System.out.println("dailyAccural = principal * dailyInterest = " + (principal * (interest / 365)));
                System.out.println("Total Accrued Interest over " + months + " months = " + userAccuredInterest);
            } else{
                System.out.println("Invalid choice");
            }
        }}

}







