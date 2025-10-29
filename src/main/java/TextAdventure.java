import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        //Variables
        int resources=20, hp=50, EnemyHP, companionHP=50, DMG=3, companionDMG=3;
        Scanner sc = new Scanner(System.in);
        boolean play = true;

        while (play)
        {
            //Title Screen
            System.out.println (" _____ _ _   _      \n" +
                    "|_   _(_) |_| | ___ \n" +
                    "  | | | | __| |/ _ \\\n" +
                    "  | | | | |_| |  __/\n" +
                    "  |_| |_|\\__|_|\\___|");
            System.out.println ("[1] Play");
            System.out.println ("[2] Controls");
            System.out.println ("[3] Quit");
            int menuOption = sc.nextInt();
            if (menuOption == 1)
            {
                //Play the game
                //Intro - Scene 1
                System.out.println("⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⣠⣴⣶⡾⠛⡻⡷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢀⣼⣿⠟⠁⠀⢀⣠⢔⡽⡿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢹⣿⣛⢤⠂⠰⣴⣷⡟⣡⠐⢽⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⣿⡿⣏⣴⣟⣯⢿⣽⣿⢽⣴⣿⣸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢻⣧⠿⢏⢈⢄⣱⣺⣿⣷⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠈⢻⣿⢋⣏⣾⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⢻⡄⠀⠀⠀⠀⠀⠀⠀⢐⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠙⢷⣿⣿⣿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠻⣄⠀⠀⠀⠀⠀⠀⠆⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣏⢀⡀⣄⣽⣄⡀⠀⠀⠀⠀⡀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⢸⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⢾⣿⣿⡿⣿⣧⠀⠀⠀⠀⠀⠁⠀⠀⠐\n" +
                        "⠀⠀⠀⢀⡀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣷⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣲⣿⣿⣿⣾⣿⣿⣿⣿⣷⠂⠀⠀⠀⠃⠀⠀⠀\n" +
                        "⠀⠀⠀⣀⡕⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣦⣀⣀⣀⡖⠀⠀⠀\n" +
                        "⠀⠀⡄⠀⠑⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣟⣿⣷⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣦⡀⠀⣆⠀⠀⠀\n" +
                        "⠀⠐⠁⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢻⣟⣽⣿⣿⣿⣍⠁⠀⠀⠀⠀⠈⣱⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠉⡇⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣾⣯⣴⠤⢾⢿⣿⣿⠿⠿⣿⡷⠂⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣧⡅⠀⠀⠀\n" +
                        "⠀⠄⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠾⠿⢯⣿⣿⣿⣿⣿⣿⣿⣾⣿⣍⣀⣀⠀⡀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⡷⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣟⣦⡀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠲⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠈\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢙⠺⠿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠉⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⣿⣿⣿⣿⡇⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⠁⠀⠀⣴⣿⣿⣫⣿⣷⣾⣿⣿⣿⣿⣿⣽⣿⣿⢿⡞⠋⢝⣿⣿⣿⣧⠂⠀⠀\n" +
                        "⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣩⡽⡷⣞⣿⣿⣿⣿⣿⣶⣾⣯⡿⢿⣿⣿⠿⠿⠿⢿⣿⣿⣻⡿⠿⡽⣟⣳⠜⠉⠽⠿⣿⡇⠀⠀⠀\n" +
                        "⠘⠪⠟⠿⢶⣤⣠⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⠽⠾⠶⢛⣿⣿⣿⣿⡷⣿⣿⣟⡺⡿⠒⠒⠂⠀⣰⣿⣿⣿⡟⢃⠀⣹⠟⠁⠘⠐⠀⢐⠚⣏⠀⠀⢀\n" +
                        "⠀⠀⠀⠀⠄⠈⢻⣶⣤⣴⣶⠿⠿⠿⠛⠿⣷⣲⣤⣠⣶⣾⣿⣿⣟⡀⠀⣠⢀⢡⣿⣿⣿⣿⣿⣺⣿⣟⠀⣀⣠⣀⣠⣼⣿⣿⣿⣟⣵⣹⢛⣁⣠⠴⠢⡄⣶⣬⣿⠷⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢀⡁⠀⠀⠀⢀⡤⠤⢬⢹⣿⣿⣏⣽⣿⣿⣟⣁⣤⣠⠄⣂⣀⣾⢿⣿⣿⣿⣿⣯⢻⣿⡒⠚⠪⡍⢻⣿⣿⣿⣣⣿⡿⣋⣾⣉⣠⠀⠀⡀⡠⢀⣹⠀⠀⠀⠠\n" +
                        "⠀⠀⠀⠀⠀⠀⠺⡂⠀⠁⠀⠀⠀⠠⣿⠿⢉⢸⠿⠛⣛⣗⣻⡿⠟⡛⠞⣿⣿⣯⠿⣿⣩⣟⣛⣿⣿⣿⣿⣯⢿⣽⣿⣿⣽⣿⣯⡽⣻⣽⣉⠉⠭⠉⠉⠃⠀⠹⣿⢃⠀⠀⠈\n" +
                        "⠀⠀⠀⠀⠀⠀⠠⠂⠀⠀⢀⣠⣰⣾⣟⣴⡿⠇⡦⣖⣵⡿⣿⣿⣿⣽⣽⣿⣿⣾⡿⠾⢔⣗⣾⣿⣿⣿⣿⢽⣿⣿⣿⣿⢿⢿⣾⢶⣟⡿⢻⣳⣶⠾⠒⢀⠐⠐⣺⡠⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⡆⠀⢠⢛⣾⣿⣧⣿⡿⣢⣮⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣉⣅⣽⣽⣶⣿⣿⣿⣿⣿⣿⣿⣿⣾⣵⣿⣵⣿⣼⣯⣶⡞⠱⡷⣶⠒⠃⠈⠚⢿⠀⠀⠀⠀\n");
                System.out.println("You wake up in a forest with no memory of who you are \n" +
                        "though . . . you feel as if you should remember.\n" +
                        "You know only that there is a destination that you need to reach \n" +
                        "Though, . . . you're not quite sure where it is . . . or why you need to reach it");
                //keep adding more to the intro - it isn't done!!
                System.out.println("What would you like to do\n" +
                        "[1] Go to the left\n[2] Go to the right\n" +
                        "[3] Go forward]\n[4] Look around");
                int choice = sc.nextInt();
                

                //Once you finish playing it will end here
                play = false;
            }
            else if (menuOption == 2)
            {
                System.out.println("Just select the option you wish to perform.");
            }
            else if (menuOption == 3)
            {
                System.out.print("What are you doing here then?");
                play = false;
            }
        }
    }
}
