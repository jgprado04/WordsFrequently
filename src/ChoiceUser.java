import java.util.Scanner;

public class ChoiceUser {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean choice;

    private static boolean  inputChoice() {
        System.out.println("Do you want to read a file in separates lines? ");
        choice = scanner.nextLine().equalsIgnoreCase("yes") ? true : false;
        return choice;
    }

    public static void callMethod() {
        if(inputChoice())  {
            WordsFrequently2.makeReadText("text.txt");
            return;
        }

        WordsFrequently.makeReadText("text.txt");
    }
}
