import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        //Variables
        int resources, hp;
        Scanner sc = new Scanner(System.in);

        //Title Screen
        System.out.println (" _____ _ _   _      \n" +
                "|_   _(_) |_| | ___ \n" +
                "  | | | | __| |/ _ \\\n" +
                "  | | | | |_| |  __/\n" +
                "  |_| |_|\\__|_|\\___|");
        System.out.println ("[1] Play");
        System.out.println ("[2] Quit");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                //Play the game
                System.out.println ("You wake up in a forest with no memory of who you are \n" +
                        "though . . . you feel as if you should remember.\n" +
                        "You know only that there is a destination that you need to reach \n" +
                        "Though, . . . you're not quite sure where it is . . . or why you need to reach it");
                break;
            case 2:
                System.out.print ("What are you doing here then?");
        }
    }
}
