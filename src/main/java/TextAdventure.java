import java.util.Random;
import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        //Variables
        int resources=20, hp=50, enemyHP, companionHP=50, DMG=3, companionDMG=3;
        Scanner sc = new Scanner(System.in);
        boolean play = true, companion=false;
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
                            System.out.println ("Monkey HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
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
                            else if (decision == 3)
                            {
                                System.out.print ("How much hp would you like to heal? ");
                                int value = sc.nextInt();
                                if (resources >= value)
                                {
                                    hp += value;
                                    resources -= value;
                                }
                                else {
                                    System.out.println ("Insufficient Resources");
                                }
                                while (value != resources)
                                {
                                    System.out.print ("How much hp would you like to heal? ");
                                    value = sc.nextInt();
                                    if (resources >= value)
                                    {
                                        hp += value;
                                        resources -= value;
                                    }
                                    else {
                                        System.out.println ("Insufficient Resources");
                                    }
                                }
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
                            if (enemyHP == 0)
                            {
                                System.out.println ("You have successfully defeated the monkey");
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                        }
                        else
                        {
                            System.out.println ("After the battle with the monkey, you continue on your path." +
                                    "\nAfter walking through the forest for a time you find yourself at a river.");
                        }
                        break;
                    case 2:
                        System.out.println ("You head forward and make your way through the forest.\n" +
                                "As you walk you hear a rustling in the trees in front of you\n" +
                                "Would you like to investigate?\n[1] Yes\n[2] No");
                        enemyHP = 30;
                        investigate = sc.nextInt();
                        if (investigate == 2)
                        {
                            hp -= 7;
                            System.out.println ("An axe wielding bandit leaps from the trees in front of you dealing" +
                                    " 7 damage");
                        }
                        else if (investigate == 1)
                        {
                            System.out.println ("You notice an axe wielding bandit among the trees, who leaps at you" +
                                    " attempting to strike");
                            int value = rand.nextInt(10);
                            if (value >= 6)
                            {
                                System.out.println ("However, you successfully dodge the attack");
                            }
                            else
                            {
                                hp -= (7-value);
                                System.out.println ("The bandit's attack connects dealing " + (7-value) + "damage");
                            }
                        }
                        battle = true;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println (" /\\_[]_/\\\n" +
                                    "              |] _||_ [|\n" +
                                    "       ___     \\/ || \\/\n" +
                                    "      /___\\       ||\n" +
                                    "     (|0 0|)      ||\n" +
                                    "   __/{\\U/}\\_ ___/vvv\n" +
                                    "  / \\  {~}   / _|_P|\n" +
                                    "  | /\\  ~   /_/   []\n" +
                                    "  |_| (____)        \n" +
                                    "  \\_]/______\\        -edias-\n" +
                                    "     _\\_||_/_           \n" +
                                    "snd (_,_||_,_)");
                            System.out.println ("Bandit HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
                            int decision = sc.nextInt();
                            if (decision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the bandit dealing " + DMG + " damage");
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
                            else if (decision == 3)
                            {
                                System.out.print ("How much hp would you like to heal? ");
                                int value = sc.nextInt();
                                if (resources >= value)
                                {
                                    hp += value;
                                    resources -= value;
                                }
                                else {
                                    System.out.println ("Insufficient Resources");
                                }
                                while (value != resources)
                                {
                                    System.out.print ("How much hp would you like to heal? ");
                                    value = sc.nextInt();
                                    if (resources >= value)
                                    {
                                        hp += value;
                                        resources -= value;
                                    }
                                    else {
                                        System.out.println ("Insufficient Resources");
                                    }
                                }
                            }
                            if (enemyHP > 0 && battle)
                            {
                                int value = rand.nextInt(4) + 3;
                                if (decision == 2)
                                {
                                    hp -= (value - 1);
                                    System.out.println ("The bandit strikes, dealing " + (value - 1) + " damage");
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The bandit strikes, dealing " + value + " damage");
                                }
                            }
                            if (enemyHP == 0)
                            {
                                System.out.println ("You have successfully defeated the bandit.\nSome of the bandit's items" +
                                        "seem like useful resources. Would you like to take them\n" +
                                        "[1] Yes\n[2] No");
                                int value = sc.nextInt();
                                if (value == 1)
                                {
                                    resources += 3;
                                    System.out.println ("Resources: " + resources);
                                }
                                if (DMG < 7)
                                {
                                    System.out.println ("The bandit's axe seems like a more powerful weapon than you currently have");
                                }
                                else
                                {
                                    System.out.println ("The bandit's axe seems like a worse weapon than you currently have");
                                }
                                System.out.println ("\nWould you like to take the axe\n[1] Yes\n[2] No");
                                value = sc.nextInt();
                                if (value == 1)
                                {
                                    DMG = 7;
                                    System.out.println ("DMG: " + DMG);
                                }

                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                        }
                        else {
                            System.out.println("After the battle with the bandit, you continue on your path." +
                                    "\nAfter walking through the forest for a time you find yourself at a river.");
                        }
                        break;
                    case 3:
                        System.out.println ("You turn right and make your way through the forest.\n" +
                                "As you walk you hear a rustling in the trees in front of you\n" +
                                "Would you like to investigate?\n[1] Yes\n[2] No");
                        enemyHP = 40;
                        investigate = sc.nextInt();
                        if (investigate == 2)
                        {
                            hp -= 7;
                            System.out.println ("A bear leaps from the trees in front of you dealing 7 damage");
                        }
                        else if (investigate == 1)
                        {
                            System.out.println ("You notice a bear among the trees, which leaps at you attempting to strike");
                            int value = rand.nextInt(10);
                            if (value >= 3)
                            {
                                System.out.println ("However, you successfully dodge the attack");
                            }
                            else
                            {
                                hp -= (7-value);
                                System.out.println ("The bear's attack connects dealing " + (7-value) + "damage");
                            }
                        }
                        battle = true;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println (" _      _                        \n" +
                                    " : `.--.' ;              _....,_  \n" +
                                    " .'      `.      _..--'\"'       `-._\n" +
                                    ":          :_.-'\"                  .`.\n" +
                                    ":  6    6  :                     :  '.;\n" +
                                    ":          :                      `..';\n" +
                                    "`: .----. :'                          ;\n" +
                                    "  `._Y _.'               '           ;\n" +
                                    "    'U'      .'          `.         ; \n" +
                                    "       `:   ;`-..___       `.     .'`.\n" +
                                    "jgs    _:   :  :    ```\"''\"'``.    `.  `.\n" +
                                    "     .'     ;..'            .'       `.'`\n" +
                                    "    `.......'              `........-'`");
                            System.out.println ("Bear HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
                            int decision = sc.nextInt();
                            if (decision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the bear dealing " + DMG + " damage");
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
                            else if (decision == 3)
                            {
                                System.out.print ("How much hp would you like to heal? ");
                                int value = sc.nextInt();
                                if (resources >= value)
                                {
                                    hp += value;
                                    resources -= value;
                                }
                                else {
                                    System.out.println ("Insufficient Resources");
                                }
                                while (value != resources)
                                {
                                    System.out.print ("How much hp would you like to heal? ");
                                    value = sc.nextInt();
                                    if (resources >= value)
                                    {
                                        hp += value;
                                        resources -= value;
                                    }
                                    else {
                                        System.out.println ("Insufficient Resources");
                                    }
                                }
                            }
                            if (enemyHP > 0 && battle)
                            {
                                int value = rand.nextInt(6) + 1;
                                if (decision == 2)
                                {
                                    hp -= (value - 1);
                                    System.out.println ("The bear strikes, dealing " + (value - 1) + " damage");
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The bear strikes, dealing " + value + " damage");
                                }
                            }
                            if (enemyHP == 0)
                            {
                                System.out.println ("You have successfully defeated the bear.\nSome parts of the bear" +
                                        "seem like they could be useful resources. Would you like to take them\n" +
                                        "[1] Yes\n[2] No");
                                int value = sc.nextInt();
                                if (value == 1)
                                {
                                    resources += 3;
                                    System.out.println ("Resources: " + resources);
                                }
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                            play = false;
                        }
                        else
                        {
                            System.out.println ("After the battle with the bear, you continue on your path." +
                                    "\nAfter walking through the forest for a time you find yourself at a river.");
                        }
                        break;
                }
                //Scene 2 - River
                if (play) {
                    System.out.println("(              ````                                            \n" +
                            ";`             ;;                                               \n" +
                            " ;;  -\"\"-.   ;;                 -;'  -.                         \n" +
                            "   \"\"     ``                      `.   `.                       \n" +
                            "                                    ;    `                      \n" +
                            "           `;                  -          ;         -.        ;`\n" +
                            "             `-  `.         .'`  .-'             .--`  ;     ;  \n" +
                            "              ;    `-.   ;    `-'             .;`     ;       `.\n" +
                            "              .        ``                                       \n" +
                            "               `            .--------.             .'           \n" +
                            "             ...        .--'``````````'--.        ;.            \n" +
                            "            `      . .-' .``          ``. '-. .      `.         \n" +
                            "          ;-.;  .  .' .`                  `. '.  .    ;         \n" +
                            "              .' .' .`                      `. '. '.    .       \n" +
                            "_____/'.-..___________________________ mvn,, ___________________\n" +
                            "                             )\\     nMmIEFooPTn                 \n" +
                            "                            ( (    Li1iiJl1ItTIjp               \n" +
                            "                             ) \\  i i_BP_LWmKK`  J  `           \n" +
                            "`                .          /  (   i1 LL 1I`L            .      \n" +
                            "             ..             \\   \\  i   X  Y o1                  \n" +
                            "                        .    )   )  `   l   p      ..           \n" +
                            ";                           /   (,      l(@) l                ..\n" +
                            "  q      ` .  '            (     \\.     i    p   R          .;  \n" +
                            "   \\  t            ;        )     \\`   j,.. ,.q,/Pqoj          `\n" +
                            "    \\/            `       ./       \\`;     `'     `          .. \n" +
                            "  '-     \\;            -'.'    ;    \\ `                     `. `\n" +
                            ".--.`.; ,-.. ,.-, ;' `.-'       `    `.'.   .--.\"\"-._        .; \n" +
                            "    `............---\"\"     ;_.         )   (  '=    /         `-\n" +
                            " ~                                    /     `------'     .      \n" +
                            "                 ~                  ,'  \\|//            `'      \n" +
                            "                ~           ~       ; `. \"\"                   ..\n" +
                            "                                     `.  )     \\\"       .--\"\"\"");
                    System.out.println("As you approach the river, you notice your reflection" +
                            ", you look human, though, not quite. You feel as if you look less real than you should. Less alive." +
                            "\nYou decide that you should go along the river. \nWhat method of travel would you like to do?" +
                            "\n[1] Walk alongside the river\n[2] Ride down the river on a raft - 7 resources");
                    int value = sc.nextInt();
                    while (value == 2 && resources < 7) {
                        System.out.println("Insufficient resources\nResources: " + resources + "\nWhat would you like to do?" +
                                "\n[1] Walk alongside the river\n[2] Ride down the river on a raft - 7 resources");
                    }
                    if (value == 2) {
                        resources -= 7;
                        System.out.println ("Resources: " + resources);
                        System.out.println ("You construct a raft, and travel down the river.\nYour raft flows along the river" +
                                "for a time, until finally you return to shore. You find that you have arrived at a desert");
                    }
                    else if (value ==1)
                    {
                        System.out.println ("You walk along the river for a time");
                        System.out.println ("\nAs you walk you hear a rustling in the brush beside you\n" +
                                "Would you like to investigate?\n[1] Yes\n[2] No");
                        enemyHP = 20;
                        int investigate = sc.nextInt();
                        if (investigate == 2)
                        {
                            hp -= 4;
                            System.out.println ("A wolf lunges at you dealing 7 damage");
                        }
                        else if (investigate == 1)
                        {
                            System.out.println ("You notice a wolf among the brush, which leaps at you attempting to strike");
                            value = rand.nextInt(10);
                            if (value >= 4)
                            {
                                System.out.println ("However, you successfully dodge the attack");
                            }
                            else
                            {
                                hp -= (7-value);
                                System.out.println ("The wolf's attack connects dealing " + (4-value) + "damage");
                            }
                        }
                        boolean battle = true;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println ("  ,     ,\n" +
                                    "                        |\\---/|\n" +
                                    "                       /  , , |\n" +
                                    "                  __.-'|  / \\ /\n" +
                                    "         __ ___.-'        ._O|\n" +
                                    "      .-'  '        :      _/\n" +
                                    "     / ,    .        .     |\n" +
                                    "    :  ;    :        :   _/\n" +
                                    "    |  |   .'     __:   /\n" +
                                    "    |  :   /'----'| \\  |\n" +
                                    "    \\  |\\  |      | /| |\n" +
                                    "     '.'| /       || \\ |\n" +
                                    "     | /|.'       '.l \\\\_\n" +
                                    "snd  || ||             '-'\n" +
                                    "     '-''-'");
                            System.out.println ("Wolf HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
                            int decision = sc.nextInt();
                            if (decision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the wolf dealing " + DMG + " damage");
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
                            else if (decision == 3)
                            {
                                System.out.print ("How much hp would you like to heal? ");
                                value = sc.nextInt();
                                if (resources >= value)
                                {
                                    hp += value;
                                    resources -= value;
                                }
                                else {
                                    System.out.println ("Insufficient Resources");
                                }
                                while (value != resources)
                                {
                                    System.out.print ("How much hp would you like to heal? ");
                                    value = sc.nextInt();
                                    if (resources >= value)
                                    {
                                        hp += value;
                                        resources -= value;
                                    }
                                    else {
                                        System.out.println ("Insufficient Resources");
                                    }
                                }
                            }
                            if (enemyHP > 0 && battle)
                            {
                                value = rand.nextInt(3) + 1;
                                if (decision == 2)
                                {
                                    hp -= (value - 1);
                                    System.out.println ("The wolf strikes, dealing " + (value - 1) + " damage");
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The wolf strikes, dealing " + value + " damage");
                                }
                            }
                            if (enemyHP == 0)
                            {
                                System.out.println ("You have successfully defeated the wolf.\nSome parts of the wolf" +
                                        "seem like they could be useful resources. Would you like to take them\n" +
                                        "[1] Yes\n[2] No");
                                value = sc.nextInt();
                                if (value == 1)
                                {
                                    resources += 1;
                                    System.out.println ("Resources: " + resources);
                                }
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                            play = false;
                        }
                        else
                        {
                            System.out.println ("After the battle with the wolf, you continue on your path.");
                        }
                        System.out.println ("As you continue walking, eventually, you hear yet more rustling in the brush\n" +
                                "Would you like to investigate?\n[1] Yes\n[2] No");
                        value = sc.nextInt();
                        if (value == 1)
                        {
                            System.out.println ("You look around and notice a rabbit in the brush\n((`\\\n" +
                                    "            ___ \\\\ '--._\n" +
                                    "         .'`   `'    o  )\n" +
                                    "        /    \\   '. __.'\n" +
                                    "       _|    /_  \\ \\_\\_\n" +
                                    "jgs   {_\\______\\-'\\__\\_\\");
                            System.out.println ("You notice some items in the brush that look somewhat useful\n" +
                                    "Would you like to take them?\n[1] Yes\n[2] No");
                            value = sc.nextInt();
                            if (value == 1)
                            {
                                resources += 2;
                                System.out.println ("Resources: " + resources);
                                System.out.println ("You continue on your way");
                            }
                            else
                            {
                                System.out.println ("You continue on your way");
                            }
                        }
                        else
                        {
                            System.out.println ("You continue on your way");
                        }
                        System.out.println ("As you continue walking, eventually you find that you have arrived at a desert");
                    }
                }
                //Scene 3 - desert
                if (play)
                {
                    System.out.println ("    .    _    +     .  ______   .          .\n" +
                            " (      /|\\      .    |      \\      .   +\n" +
                            "     . |||||     _    | |   | | ||         .\n" +
                            ".      |||||    | |  _| | | | |_||    .\n" +
                            "   /\\  ||||| .  | | |   | |      |       .\n" +
                            "__||||_|||||____| |_|_____________\\__________\n" +
                            ". |||| |||||  /\\   _____      _____  .   .\n" +
                            "  |||| ||||| ||||   .   .  .         ________\n" +
                            " . \\|`-'|||| ||||    __________       .    .\n" +
                            "    \\__ |||| ||||      .          .     .\n" +
                            " __    ||||`-'|||  .       .    __________\n" +
                            ".    . |||| ___/  ___________             .\n" +
                            "   . _ ||||| . _               .   _________\n" +
                            "_   ___|||||__  _ \\\\--//    .          _\n" +
                            "     _ `---'    .)=\\oo|=(.   _   .   .    .\n" +
                            "_  ^      .  -    . \\.|");
                    System.out.println ("You begin to walk, and make your way through the desert\n" +
                            "Eventually, you notice someone else leaning against a cactus");
                    //Maybe put some ascii art of the companion here
                    //Major decision 1
                    System.out.println ("As you look at them, you realize that they have a bunch of stuff that could be very useful");
                    System.out.println ("They notice you and say: \"Hey could you help me out here\"");
                    System.out.println ("How would you like to reply\n[1] Why should I?\n[2] Sure - 5 resources\n" +
                            "[3] I'd rather just take your stuff");
                    int response = sc.nextInt();
                    switch (response) {
                        case 1:
                            System.out.println("\"Its easier to do stuff as a group than it is alone, if you helped me I could help you" +
                                    "\nBesides, I have some useful items that could help you\"");
                            System.out.println("Resources: " + resources +
                                    "\nWhat would you like to do?\n[1] Help them - 5 resources\n[2] Rob them");
                            int value = sc.nextInt();
                            while (value == 1 && resources < 5) {
                                System.out.println("Insufficient resources\nWhat would you like to do?" +
                                        "\n[1] Help them - 5 resources\n[2] Rob them");
                            }
                            if (value == 1) {
                                resources -= 5;
                                companion = true;
                                System.out.println("Resources: " + resources);
                                System.out.println("Thank you, I swear I'll be useful");
                            } else if (value == 2) {
                                boolean battle = true;
                                enemyHP = 40;
                                while (hp >= 0 && enemyHP >= 0 && battle) {
                                    System.out.println("  .-\"\"-.\n" +
                                            "      /-.{}  \\\n" +
                                            "      | _\\__.|\n" +
                                            "      \\/^)^ \\/\n" +
                                            "       \\ =  /\n" +
                                            "  .---./`--`\\.--._\n" +
                                            " /     `;--'`     \\\n" +
                                            ";        /`       ;\n" +
                                            "|       |*        |\n" +
                                            "/   |   |     |    \\\n" +
                                            "|    \\  |*    /    |\n" +
                                            "\\_   |\\_|____/|  __/\n" +
                                            "  \\__//======\\\\__/\n" +
                                            "  / //_      _\\\\ \\\n" +
                                            "  -'  |`\"\"\"\"`|  `-\n" +
                                            "      |  L   |\n" +
                                            "      >_ || _<\n" +
                                            "      |  ||  |\n" +
                                            "      |  ||  |\n" +
                                            "     /   ||   \\\n" +
                                            "    /    /,    \\\n" +
                                            "     `|\"|`\"|\"|\"`\n" +
                                            "     /  )  /  )  nic/jgs\n" +
                                            "    /__/  /__/");
                                    System.out.println("Enemy HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                                    System.out.println("What would you like to do?\n[1] Attack\n[2] Block\n" +
                                            "[3] Heal - 1 resource = 1 hp");
                                    int decision = sc.nextInt();
                                    if (decision == 1) {
                                        enemyHP -= DMG;
                                        System.out.println("You strike at the person dealing " + DMG + " damage");
                                    } else if (decision == 2) {
                                        System.out.println("You put up your guard");
                                    } else if (decision == 3) {
                                        System.out.print("How much hp would you like to heal? ");
                                        value = sc.nextInt();
                                        if (resources >= value) {
                                            hp += value;
                                            resources -= value;
                                        } else {
                                            System.out.println("Insufficient Resources");
                                        }
                                        while (value != resources) {
                                            System.out.print("How much hp would you like to heal? ");
                                            value = sc.nextInt();
                                            if (resources >= value) {
                                                hp += value;
                                                resources -= value;
                                            } else {
                                                System.out.println("Insufficient Resources");
                                            }
                                        }
                                    }
                                    if (enemyHP > 0 && battle) {
                                        value = rand.nextInt(3) + 1;
                                        if (decision == 2) {
                                            hp -= (value - 1);
                                            System.out.println("The person strikes, dealing " + (value - 1) + " damage");
                                        } else {
                                            hp -= value;
                                            System.out.println("The person strikes, dealing " + value + " damage");
                                        }
                                    }
                                    if (enemyHP == 0) {
                                        System.out.println("You have successfully defeated the person.\nThey seem to have" +
                                                "some valuable items\nAs you look through their items, you find a vague map" +
                                                " which will help you on your journey\n In addition, you find some tools" +
                                                " which will make it easier to gather resources");
                                        value = sc.nextInt();
                                        resources += 5;
                                        System.out.println("Resources: " + resources);

                                    }
                                }
                                if (hp <= 0) {
                                    System.out.println("You have died");
                                    play = false;
                                } else {
                                    System.out.println("After the battle with the person, you continue on your way");
                                }
                            }
                            break;
                        case 2:
                            resources -= 5;
                            companion = true;
                            System.out.println("Resources: " + resources);
                            System.out.println("Thank you, I swear I'll be useful");
                            break;
                        case 3:
                            boolean battle = true;
                            enemyHP = 40;
                            while (hp >= 0 && enemyHP >= 0 && battle) {
                                System.out.println("  .-\"\"-.\n" +
                                        "      /-.{}  \\\n" +
                                        "      | _\\__.|\n" +
                                        "      \\/^)^ \\/\n" +
                                        "       \\ =  /\n" +
                                        "  .---./`--`\\.--._\n" +
                                        " /     `;--'`     \\\n" +
                                        ";        /`       ;\n" +
                                        "|       |*        |\n" +
                                        "/   |   |     |    \\\n" +
                                        "|    \\  |*    /    |\n" +
                                        "\\_   |\\_|____/|  __/\n" +
                                        "  \\__//======\\\\__/\n" +
                                        "  / //_      _\\\\ \\\n" +
                                        "  -'  |`\"\"\"\"`|  `-\n" +
                                        "      |  L   |\n" +
                                        "      >_ || _<\n" +
                                        "      |  ||  |\n" +
                                        "      |  ||  |\n" +
                                        "     /   ||   \\\n" +
                                        "    /    /,    \\\n" +
                                        "     `|\"|`\"|\"|\"`\n" +
                                        "     /  )  /  )  nic/jgs\n" +
                                        "    /__/  /__/");
                                System.out.println("Enemy HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                                System.out.println("What would you like to do?\n[1] Attack\n[2] Block\n" +
                                        "[3] Heal - 1 resource = 1 hp");
                                int decision = sc.nextInt();
                                if (decision == 1) {
                                    enemyHP -= DMG;
                                    System.out.println("You strike at the person dealing " + DMG + " damage");
                                } else if (decision == 2) {
                                    System.out.println("You put up your guard");
                                } else if (decision == 3) {
                                    System.out.print("How much hp would you like to heal? ");
                                    value = sc.nextInt();
                                    if (resources >= value) {
                                        hp += value;
                                        resources -= value;
                                    } else {
                                        System.out.println("Insufficient Resources");
                                    }
                                    while (value != resources) {
                                        System.out.print("How much hp would you like to heal? ");
                                        value = sc.nextInt();
                                        if (resources >= value) {
                                            hp += value;
                                            resources -= value;
                                        } else {
                                            System.out.println("Insufficient Resources");
                                        }
                                    }
                                }
                                if (enemyHP > 0 && battle) {
                                    value = rand.nextInt(3) + 1;
                                    if (decision == 2) {
                                        hp -= (value - 1);
                                        System.out.println("The person strikes, dealing " + (value - 1) + " damage");
                                    } else {
                                        hp -= value;
                                        System.out.println("The person strikes, dealing " + value + " damage");
                                    }
                                }
                                if (enemyHP == 0) {
                                    System.out.println("You have successfully defeated the person.\nThey seem to have" +
                                            "some valuable items\nAs you look through their items, you find a vague map" +
                                            " which will help you on your journey\n In addition, you find some tools" +
                                            " which will make it easier to gather resources");
                                    value = sc.nextInt();
                                    resources += 5;
                                    System.out.println("Resources: " + resources);

                                }
                            }
                            if (hp <= 0) {
                                System.out.println("You have died");
                                play = false;
                            } else {
                                System.out.println("After the battle with the person, you continue on your way");
                            }
                            break;
                    }
                }
                if (play)
                {
                    if (companion)
                    {
                        System.out.println ("\"I'm on a journey, though I'm not exactly sure where I need to go" +
                                "\nDo you know?\"");
                        System.out.println ("Companion: \"I'm fairly certain we need to head through the mountains, and " +
                                "then follow the lights on the other side\"");
                        System.out.println ("You and your companion begin walking towards the mountains");
                    }
                    else
                    {
                        System.out.println ("You look at the map you took, and decide that you need to head through the mountains" +
                                "\nYou continue on your journey, and head towards the mountains");
                    }
                }
                //Scene 4 - right before the mountains
                if (play)
                {
                    System.out.println (" .                  .-.    .  _   *     _   .\n" +
                            "           *          /   \\     ((       _/ \\       *    .\n" +
                            "         _    .   .--'\\/\\_ \\     `      /    \\  *    ___\n" +
                            "     *  / \\_    _/ ^      \\/\\'__        /\\/\\  /\\  __/   \\ *\n" +
                            "       /    \\  /    .'   _/  /  \\  *' /    \\/  \\/ .`'\\_/\\   .\n" +
                            "  .   /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _\n" +
                            "     /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\\n" +
                            "   /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\\n" +
                            "  /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.\n" +
                            "@/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%\n" +
                            "@&8jgs@@%% @)&@&(88&@.-_=_-=_-=_-=_-=_.8@% &@&&8(8%@%8)(8@%8 8%@)%\n" +
                            "@88:::&(&8&&8:::::%&`.~-_~~-~~_~-~_~-~~=.'@(&%::::%@8&8)::&#@8::::\n" +
                            "`::::::8%@@%:::::@%&8:`.=~~-.~~-.~~=..~'8::::::::&@8:::::&8:::::'\n" +
                            " `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::.'");
                    System.out.println ("As you approach the mountains, some 2 thugs step out in front of you" +
                            " and attack you");
                    //Battle against 2 enemies - I need to change the code for 2 enemies

                    boolean battle = true;
                    int enemy1hp = 30, enemy2hp = 30;
                    while (hp >= 0 && (enemy1hp >= 0 || enemy2hp >= 0) && battle)
                    {
                        System.out.println (" .---.             .---.    \n" +
                                "     /_____\\           /_____\\       \n" +
                                "     ( '.' )           ( '.' )         \n" +
                                "      \\_-_/_            \\_-_/_       \n" +
                                "   .-\"`'V'//-.       .-\"`'V'//-.      \n" +
                                "  / ,   |// , \\     / ,   |// , \\    \n" +
                                " / /|Ll //Ll|\\ \\   / /|Ll //Ll|\\ \\  \n" +
                                "/ / |__//   | \\_\\ / / |__//   | \\_\\ \n" +
                                "\\ \\/---|[]==| / / \\ \\/---|[]==| / / \n" +
                                " \\/\\__/ |   \\/\\/   \\/\\__/ |   \\/\\\n" +
                                "  |/_   | Ll_\\|     |/_   | Ll_\\|     \n" +
                                "    |`^\"\"\"^`|         |`^\"\"\"^`|   \n" +
                                "    |   |   |         |   |   |        \n" +
                                "    |   |   |         |   |   |        \n" +
                                "    |   |   |         |   |   |         \n" +
                                "    |   |   |         |   |   |         \n" +
                                "    L___l___J         L___l___J         \n" +
                                "     |_ | _|           |_ | _|         \n" +
                                "jgs (___|___)         (___|___)       \n" +
                                "     ^^^ ^^^           ^^^ ^^^       ");
                        System.out.println ("Enemy 1 HP: " + enemy1hp + "Enemy 2 HP: " + enemy2hp +
                                "\nYour HP:" + hp + "\nResources: " + resources);
                        if (companion)
                        {
                            System.out.println ("Companion HP: " + companionHP);
                        }
                        System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                "[4] Heal - 1 resource = 1 hp");
                        int decision = sc.nextInt();
                        if (decision == 1)
                        {
                            System.out.println ("Which enemy would you like to attack");
                            int target = sc.nextInt();
                            if (target == 1)
                            {
                                enemy1hp -= DMG;
                                System.out.println("You strike at the enemy dealing " + DMG + " damage");
                            }
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
                        else if (decision == 3)
                        {
                            System.out.print ("How much hp would you like to heal? ");
                            int value = sc.nextInt();
                            if (resources >= value)
                            {
                                hp += value;
                                resources -= value;
                            }
                            else {
                                System.out.println ("Insufficient Resources");
                            }
                            while (value != resources)
                            {
                                System.out.print ("How much hp would you like to heal? ");
                                value = sc.nextInt();
                                if (resources >= value)
                                {
                                    hp += value;
                                    resources -= value;
                                }
                                else {
                                    System.out.println ("Insufficient Resources");
                                }
                            }
                        }
                        if (companion)
                        {
                            if (enemy1hp <= enemy2hp && enemy1hp > 0)
                            {
                                System.out.println ("The companion strikes enemy 1 dealing " + companionDMG + " damage");
                                enemy1hp -= companionDMG;
                            }
                            else
                            {
                                System.out.println ("The companion strikes enemy 2 dealing" + companionDMG + " damage");
                                enemy2hp -= companionDMG;
                            }
                        }
                        if (enemy1hp > 0 && battle)
                        {
                            int value = rand.nextInt(3) + 1;
                            if (decision == 2)
                            {
                                if (companion)
                                {
                                    boolean target = rand.nextBoolean();
                                    if (target)
                                    {
                                        System.out.println ("The enemy strikes, dealing " + (value - 1) + " damage");
                                        hp -= (value - 1);
                                    }
                                    else
                                    {
                                        System.out.println ("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                        companionHP -= (value - 1);
                                    }
                                }
                                else
                                {
                                    hp -= (value - 1);
                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                }
                            }
                            else
                            {
                                hp -= value;
                                System.out.println ("The enemy strikes, dealing " + value + " damage");
                            }
                        }
                        if (enemy2hp > 0 && battle)
                        {
                            int value = rand.nextInt(3) + 1;
                            if (decision == 2)
                            {
                                if (companion)
                                {
                                    boolean target = rand.nextBoolean();
                                    if (target)
                                    {
                                        System.out.println ("The enemy strikes, dealing " + (value - 1) + " damage");
                                        hp -= (value - 1);
                                    }
                                    else
                                    {
                                        System.out.println ("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                        companionHP -= (value - 1);
                                    }
                                }
                                else
                                {
                                    hp -= (value - 1);
                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                }
                            }
                            else
                            {
                                hp -= value;
                                System.out.println ("The enemy strikes, dealing " + value + " damage");
                            }
                            if (enemy1hp <= 0 && enemy2hp <= 0)
                            {
                                System.out.println ("You have successfully defeated the enemies.\nThey seem to have some" +
                                        "useful resources.\n Would you like to take them\n" +
                                        "[1] Yes\n[2] No");
                                value = sc.nextInt();
                                if (value == 1)
                                {
                                    if (companion)
                                    {
                                        resources += 3;
                                        System.out.println ("Resources: " + resources);
                                    }
                                    else
                                    {
                                        resources += 6;
                                        System.out.println("Resources: " + resources);
                                    }
                                }
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                            play = false;
                        }
                        else
                        {
                            System.out.println ("After the battle with the enemies, you continue on your towards the mountains.");
                        }
                    }

                    //Encounter some bandits - then go to the mountains - second major decision - cave or cliff
                    //Second major decision
                    int decision;
                    if (companion)
                    {
                        System.out.println ("Companion: \"There are two methods to get past the mountains\n" +
                                "We can either go over the mountains, or we can go through a cave system.\n" +
                                "Which method should we choose?\"");
                        System.out.println ("[1] We should go over the mountains\n[2] We should go through the cave system");
                    }
                    else
                    {
                        System.out.println ("You look at the map you took, and see two paths through the mountains" +
                                "You can either go over the mountains, or you can go through a cave system");
                        System.out.println ("Which path will you take?\n[1] Over the mountains\n[2] Through the caves");
                    }
                    decision = sc.nextInt();
                    if (decision == 1)
                    {
                        //Scene 5 - cliffs
                        System.out.println ("You continue walking and attempt to scale the mountain");
                    }
                    else if (decision == 2)
                    {
                        //Scene 6 - caves
                        int path = 0;
                        System.out.println ("You continue walking and make your way into the entrance of the cave system");
                        System.out.println ("From their you see 3 paths you can take to get deeper into the caves");
                        System.out.println ("You can either go left, right, or forward.\n Which direction do you want to go in?");
                        System.out.println ("[1] Left\n[2] Right\n[3] Forward");

                    }

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

                }

            }
        }
    }}
