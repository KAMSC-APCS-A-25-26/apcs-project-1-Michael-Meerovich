import java.util.Random;
import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        //Variables
        int resources=20, hp=50, enemyHP, companionHP=50, DMG=3, companionDMG=3;
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        Random rand = new Random();

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
                //Intro - Scene 1 - Forest
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
                //First choice - not major
                System.out.println("What would you like to do\n" +
                        "[1] Go to the left\n[2] Go to the right\n" +
                        "[3] Go forward]\n[4] Look around");
                int choice = sc.nextInt();
                //The switch case for the choice will last until you make it to the river
                //The looking around is optional - you will still need to pick a direction choice
                while (choice == 4)
                {
                    System.out.println ("You spot resources which could be useful on your trip\n" +
                            "Current resources: 15");
                    System.out.println ("You spot a stick. It could be used as a weapon in a pinch." +
                            " Would you like to take it?\n[1] Yes\n[2] No");
                    choice = sc.nextInt();
                    if (choice == 1)
                    {
                        DMG = 5;
                        System.out.println ("DMG: " + DMG);
                    }
                    System.out.println ("What direction do you want to go in?\n[1] Left\n" +
                            "[2] Right\n[3] Forward");
                    choice = sc.nextInt();
                }
                switch (choice)
                {
                    case 1:
                        System.out.println ("You turn left and make your way through the forest.\n" +
                                "As you walk you hear a rustling the canopy above you\n" +
                                "Would you like to investigate?\n[1] Yes\n[2] No");
                        enemyHP = 15;
                        int investigate = sc.nextInt();
                        if (investigate == 2)
                        {
                            hp -= 5;
                            System.out.println ("A monkey leaps down from the trees and attacks you dealing" +
                                    " 5 damage");
                        }
                        else if (investigate == 1)
                        {
                            System.out.println ("You notice a monkey in the trees, which leaps at you attempting to strike");
                            int value = rand.nextInt(10);
                            if (value >= 5)
                            {
                                System.out.println ("However, you successfully dodge the attack");
                            }
                            else
                            {
                                hp -= (5-value);
                                System.out.println ("The monkey's attack connects dealing " + (5-value) + "damage");
                            }
                        }
                        boolean battle = true;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println ("       _-.    _.._ _.-'`\n" +
                                    "     .-; \\ \\-'`    ` _..-'\n" +
                                    "  _.-\\_\\-'`__...__..'\n" +
                                    "-'   __.--'` /\n" +
                                    " _.'`   \\_ _/\n" +
                                    "         |  \\\n" +
                                    "         ;   \\    .-'```'-.\n" +
                                    "          \\\"  \\  /   \"   \" \\\n" +
                                    "           \\\"  \\| \".--.--.  |\n" +
                                    "            \\_  ; / _   _ \\ ;\n" +
                                    "             | ( (  e _ e  ) )\n" +
                                    "              \\ '-|   T   |-'_\n" +
                                    "               \\\" \\   =   /\"  `\\\n" +
                                    "                \\  '-...-' ,  \" \\\n" +
                                    "                 Y  \"    \"  \\    \\\n" +
                                    "                 |\"  .     \" \\  \" \\\n" +
                                    "                 |      \" _.-'   \" )\n" +
                                    "                 \\ \"/\\._;'    \"_.;`\n" +
                                    "                  \\_\\_\\.> \".''`  |\n" +
                                    "                  /_/|_) .'    \" /---..\n" +
                                    "                   \\ '--'    \"     \"   `\\\n" +
                                    "              .-\"\"-.>     \"       ,   \"  |\n" +
                                    "             / \"      \"       \"    |     /\n" +
                                    "             \\   \"  \\  \" _.`--...-'|   \"/\n" +
                                    "              '.\"    \\.-'         / \" .'\n" +
                                    "                '-. \" \\       __.'  .'\n" +
                                    "              jgs  )   `\\    (_   \"(\n" +
                                    "                  /   /\\_)     `\\   \\\n" +
                                    "                 (((_/           \\_)))");
                            System.out.println ("Monkey HP: " + enemyHP + "\nYour HP:" + hp);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run");
                            int decision = sc.nextInt();
                            if (decision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the monkey dealing " + DMG + " damage");
                            }
                            else if (decision == 3)
                            {
                                if (rand.nextInt() > 7)
                                {
                                    System.out.println ("You successfully run away");
                                    battle = false;
                                }
                                else
                                {
                                    System.out.println ("Your attempt to run failed");
                                }
                            }
                            else if (decision == 2)
                            {
                                System.out.println ("You put up your guard");
                            }
                            if (enemyHP > 0 && battle)
                            {
                                int value = rand.nextInt(4) + 1;
                                if (decision == 2)
                                {
                                    hp -= (value - 1);
                                    System.out.println ("The monkey strikes, dealing " + (value - 1) + " damage");
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The monkey strikes, dealing " + value + " damage");
                                }
                            }
                        }
                        System.out.println ("You have successfully defeated the monkey");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }


                //Scene 2 - River


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
