package at.ac.fhcampuswien;

import java.util.Locale;
import java.util.Scanner;

public class App
{

    //todo Task 1
    public void largestNumber()
    {
        // input your solution here
        Scanner scan = new Scanner(System.in);
        int counter = 2;
        double firstInput = Double.parseDouble(scan.nextLine().replace(",", "."));
        double largest = firstInput;
        if (firstInput <= 0)
        {
            System.out.print("Number 1: No number entered." + System.lineSeparator());
            return;
        }
        System.out.print("Number 1: ");

        while (true)
        {
            double num = Double.parseDouble(scan.nextLine().replace(",", "."));
            System.out.print("Number " + counter + ": ");

            if (num <= 0)
            {
                System.out.println("The largest number is " + String.format(Locale.ENGLISH, "%.2f", largest) + System.lineSeparator());
                break;
            }

            if (num > largest)
            {
                largest = num;
            }
            counter++;
        }
    }

    //todo Task 2
    public void stairs()
    {
        // input your solution here
        Scanner scan = new Scanner(System.in);
        int ROWS = scan.nextInt();
        int counter = 1;

        for (int i = 1; i <= ROWS; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid()
    {
        // input your solution here

        int ROWS = 6;

        for (int row = 0; row < ROWS; row++)
        {
            for (int column = row; column < ROWS - 1; column++)
            {
                System.out.print(" ");
            }

            for (int starCol = 0; starCol < row * 2 + 1; starCol++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus()
    {
        // input your solution here
        Scanner scan = new Scanner(System.in);
        System.out.print("h: " +
            "c: ");
        int ROWS = scan.nextInt();
        scan.nextLine();
        String userCharacterInput = scan.nextLine();
        char character = userCharacterInput.charAt(0);
        if (ROWS % 2 == 0)
        {
            System.out.print("Invalid number!" + System.lineSeparator());
            return;
        }

        int topRows = ROWS / 2;

        for (int row = 0; row <= topRows; row++)
        {
            for (int column = row; column < topRows; column++)
            {
                System.out.print(" ");
            }

            char lowestCharacter = (char) (character - row);
            boolean midReached = false;
            for (int starCol = 0; starCol < row * 2 + 1; starCol++)
            {
                System.out.print(lowestCharacter);
                if (lowestCharacter == character)
                {
                    midReached = true;
                }

                if (midReached)
                {
                    lowestCharacter--;
                }
                else
                {
                    lowestCharacter++;
                }
            }

            System.out.println();
        }

        int bottomRows = ROWS - topRows;
        for (int row = 1; row < bottomRows; row++)
        {
            for (int col = 0; col < row; col++)
            {
                System.out.print(" ");
            }

            char lowestCharacter = (char) (character - bottomRows + 1 + row);
            boolean midReached = false;
            for (int col = 0; col < (((bottomRows - row) * 2) - 1); col++)
            {
                System.out.print(lowestCharacter);
                if (lowestCharacter == character)
                {
                    midReached = true;
                }

                if (midReached)
                {
                    lowestCharacter--;
                }
                else
                {
                    lowestCharacter++;
                }
            }
            System.out.println();
        }
    }

    //todo Task 5
    public void marks()
    {
        // input your solution here
        int sum = 0;
        int counter = 0;
        int negativeNotes = 0;

        Scanner scan = new Scanner(System.in);
        int input;

        do
        {
            System.out.print("Mark " + (counter + 1) + ": ");
            input = scan.nextInt();
            if (input < 1 || input > 5)
            {
                if (input == 0) {
                    break;
                }
                System.out.print("Invalid mark!" + System.lineSeparator());
                continue;
            }
            sum += input;
            counter++;

            if (input == 5)
            {
                negativeNotes++;
            }
        } while (input != 0);

        if (counter == 0) {
            counter = 1;
        }

        System.out.print("Average: " + String.format(Locale.ENGLISH, "%.2f", (double) sum / (double) counter) + System.lineSeparator() +
            "Negative marks: " + negativeNotes + System.lineSeparator());

    }

    //todo Task 6
    public void happyNumbers()
    {
        // input your solution here
        Scanner scan = new Scanner(System.in);
        System.out.print("n: ");

        int input = scan.nextInt();

        if (input < 1) {
            return;
        }

        int sum = 0;
        int num = input;

        while (true) {
            while (num > 0) {
                int singleDigit = num % 10;
                sum += (singleDigit * singleDigit);

                num = num / 10;
            }

            if (sum == 1) {
                System.out.print("Happy number!" + System.lineSeparator());
                break;
            } else if (sum == 4) {
                System.out.print("Sad number!" + System.lineSeparator());
                break;
            }

            num = sum;
            sum = 0;
        }
    }

    public static void main(String[] args)
    {
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: FrÃ¶hliche Zahlen");
        exercise2.happyNumbers();
    }
}