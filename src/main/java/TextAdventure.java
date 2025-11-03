import java.util.Random;
import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        //Variables
        int resources=20, hp=50, enemyHP, companionHP=50, DMG=3, companionDMG=5;
        Scanner sc = new Scanner(System.in);
        boolean play, companion=false, run = true;
        Random rand = new Random();

        while (run)
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
                play = true;
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
                            else if (decision == 4)
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
                            else if (decision == 4)
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
                            else if (decision == 4)
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
                            else if (decision == 4)
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
                        else if (decision == 4)
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
                    if (decision == 1 && play)
                    {
                        //Scene 5 - cliffs
                        System.out.println ("You continue walking and attempt to scale the mountain");
                        //Scene 5 battle 1
                        System.out.println ("As you make your way up the mountain you stumble onto a massive nest\n" +
                                "A massive gryphon swoops down and attacks you");
                        battle = true;
                        enemyHP = 50;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println ("                       ______\n" +
                                    "             ______,---'__,---'\n" +
                                    "         _,-'---_---__,---'\n" +
                                    "  /_    (,  ---____',\n" +
                                    " /  ',,   `, ,-'\n" +
                                    ";/)   ,',,_/,'\n" +
                                    "| /\\   ,.'//\\\n" +
                                    "`-` \\ ,,'    `.\n" +
                                    "     `',   ,-- `.\n" +
                                    "     '/ / |      `,         _\n" +
                                    "     //'',.\\_    .\\\\      ,{==>-\n" +
                                    "  __//   __;_`-  \\ `;.__,;'\n" +
                                    "((,--,) (((,------;  `--' jv");
                            System.out.println ("Gryphon HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
                            int battleDecision = sc.nextInt();
                            if (battleDecision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the gryphon dealing " + DMG + " damage");
                            }
                            else if (battleDecision == 3)
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
                            else if (battleDecision == 2)
                            {
                                System.out.println ("You put up your guard");
                            }
                            else if (battleDecision == 4)
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
                                enemyHP -= companionDMG;
                                System.out.println("Your companion strike at the gryphon dealing " + DMG + " damage");
                            }
                            if (enemyHP > 0 && battle)
                            {
                                int value = rand.nextInt(6) + 1;
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
                                        System.out.println("The gryphon strikes, dealing " + (value - 1) + " damage");
                                    }
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The gryphon strikes, dealing " + value + " damage");
                                }
                            }
                            if (enemyHP <= 0)
                            {
                                System.out.println ("You have successfully defeated the gryphon\n" +
                                        "Some parts of it seem usable, so you take them");
                                if (companion)
                                {
                                    resources += 2;
                                }
                                else
                                {
                                    resources += 4;
                                }
                                System.out.println ("Resources: " + resources);
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                            play = false;
                        }
                        //Scene 5 battle 2
                        System.out.println ("You crest the mountains, and once again stumble on a nest\nLodged in the middle" +
                                " of the nest, you find a glorious silver spear, it seems a far better weapon than the one you currently wield");
                        System.out.println ("Would you like to take it\n[1] Yes\n[2] No");
                        int value = sc.nextInt();
                        if (value == 1)
                        {
                            if (companion)
                            {
                                if (companionDMG < DMG)
                                {
                                    System.out.println ("Since your old weapon is still better than your companion's weapon, you give it to them");
                                    companionDMG = DMG;
                                    System.out.println ("Companion DMG: " + companionDMG);
                                }
                            }
                            DMG = 15;
                            System.out.println ("You take the spear\nDMG: " + DMG);
                        }
                        else if (value == 2)
                        {
                            System.out.println ("Distrustful of the beautiful spear, you ignore it");
                            if (companion)
                            {
                                System.out.println ("Since you don't seem to want the spear, I'll take it");
                                companionDMG = 15;
                                System.out.println ("Companion DMG: " + DMG);
                            }
                        }
                        System.out.println ("A dragon sees you in its nest, swoops down and attacks you");
                        battle = true;
                        enemyHP = 70;
                        while (hp >= 0 && enemyHP >= 0 && battle)
                        {
                            System.out.println ("   -,,,__\n" +
                                    "                     \\    ``~~--,,__                /   /\n" +
                                    "                     /              ``~~--,,_     //--//\n" +
                                    "          _,,,,-----,\\              ,,,,---- >   (c  c)\\\n" +
                                    "      ,;''            `\\,,,,----''''   ,,-'''---/   /_ ;___        -,_\n" +
                                    "     ( ''---,;====;,----/             (-,,_____/  /'/ `;   '''''----\\ `:.\n" +
                                    "     (                 '               `      (oo)/   ;~~~~~~~~~~~~~/--~\n" +
                                    "      `;_           ;    \\            ;   \\   `  ' ,,'\n" +
                                    "         ```-----...|     )___________|    )-----'''\n" +
                                    "Art by               \\   /             \\   \\\\\n" +
                                    "  Korrath            /  /,              `\\   \\\\\n" +
                                    "                   ,'---\\ \\              ,---`,;,\n" +
                                    "                         ```");
                            System.out.println ("Dragon HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                            System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                    "[4] Heal - 1 resource = 1 hp");
                            int battleDecision = sc.nextInt();
                            if (battleDecision == 1)
                            {
                                enemyHP -= DMG;
                                System.out.println("You strike at the dragon dealing " + DMG + " damage");
                            }
                            else if (battleDecision == 3)
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
                            else if (battleDecision == 2)
                            {
                                System.out.println ("You put up your guard");
                            }
                            else if (battleDecision == 4)
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
                            if (companion)
                            {
                                enemyHP -= companionDMG;
                                System.out.println("Your companion strike at the dragon dealing " + DMG + " damage");
                            }
                            if (enemyHP > 0 && battle)
                            {
                                value = rand.nextInt(6) + 1;
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
                                        System.out.println("The dragon strikes, dealing " + (value - 1) + " damage");
                                    }
                                }
                                else
                                {
                                    hp -= value;
                                    System.out.println ("The dragon strikes, dealing " + value + " damage");
                                }
                            }
                            if (enemyHP <= 0)
                            {
                                System.out.println ("You have successfully defeated the dragon\n" +
                                        "Some parts of it seem usable, so you take them");
                                if (companion)
                                {
                                    resources += 5;
                                }
                                else
                                {
                                    resources += 10;
                                }
                                System.out.println ("Resources: " + resources);
                            }
                        }
                        if (hp <= 0)
                        {
                            System.out.println ("You have died");
                            play = false;
                        }
                        System.out.println ("Having defeated the dragon, you now descend the mountain, and arrive on the other side");
                    }
                    else if (decision == 2 && play)
                    {
                        //Scene 6 - caves
                        int path = 0;
                        System.out.println ("You continue walking and make your way into the entrance of the cave system");

                        while (path < 20 && play)
                        {
                            System.out.println("You see 3 paths you can take to get deeper into the caves");
                            System.out.println("You can either go left, right, or forward.\n Which direction do you want to go in?");
                            System.out.println("[1] Left\n[2] Right\n[3] Forward");
                            int value = sc.nextInt();
                            path += value;

                            if (path == 16)
                            {
                                //Scene 7 - Secret Ending - Hell
                                //Play game with devils - if you can survive certain amount of time against them, you can stay and live in luxury
                                System.out.println ("To your surprise, as you enter this cavern you find a gate, and no other tunnels out");
                                System.out.println ("As you look behind you, shockingly, the tunnel you just entered from has vanished");
                                if (companion)
                                {
                                    System.out.println ("Companion: \"Well this is creepy. But I guess the only way out is through\"");
                                }
                                System.out.println ("In spite of your inhibitions, since there are no other options. You go through the gate");
                                System.out.println ("On the other side you find yourself in a strange land.\n" +
                                        "Two demons approach you");
                                System.out.println ("Demon 1: \"Let's play a game, you and I\"");
                                System.out.println ("Demon 2: \"If you survive 5 rounds against us in a battle, we will grant you an endless life of luxury\"");
                                System.out.println ("Demon 1: \"But if you fail, your soul will be forfeit\"");
                                System.out.println ("Demon 2: \"It's not like you have a choice. By entering here, you agreed to never leave\"");
                                enemy1hp = 100;
                                enemy2hp = 100;
                                for (int round = 0 ; round < 5 ; round++)
                                {
                                    System.out.println("                                ,   ,\n" +
                                            "   ,    ,    /\\   /\\             /(   )\\\n" +
                                            "  /( /\\ )\\  _\\ \\_/ /_            \\ \\_/ /   , /\\ ,\n" +
                                            "  |\\_||_/| < \\_   _/ >           /_   _\\  /| || |\\\n" +
                                            "  \\______/  \\|0   0|/           | \\> ");
                                    System.out.println("Enemy 1 HP: " + enemy1hp + "Enemy 2 HP: " + enemy2hp +
                                            "\nYour HP:" + hp + "\nResources: " + resources);
                                    if (companion) {
                                        System.out.println("Companion HP: " + companionHP);
                                    }
                                    System.out.println("What would you like to do?\n[1] Attack\n[2] Block\n" +
                                            "[3] Heal - 1 resource = 1 hp");
                                    int battleDecision = sc.nextInt();
                                    if (battleDecision == 1) {
                                        System.out.println("Which enemy would you like to attack");
                                        int target = sc.nextInt();
                                        if (target == 1) {
                                            enemy1hp -= DMG;
                                            System.out.println("You strike at the enemy dealing " + DMG + " damage");
                                        }
                                    }
                                    else if (battleDecision == 2)
                                    {
                                        System.out.println("You put up your guard");
                                    }
                                    else if (battleDecision == 3) {
                                        System.out.print("How much hp would you like to heal? ");
                                        value = sc.nextInt();
                                        if (resources >= value) {
                                            hp += value;
                                            resources -= value;
                                        } else {
                                            System.out.println("Insufficient Resources");
                                        }
                                        while (value > resources) {
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
                                    if (companion) {
                                        if (enemy1hp <= enemy2hp && enemy1hp > 0) {
                                            System.out.println("The companion strikes enemy 1 dealing " + companionDMG + " damage");
                                            enemy1hp -= companionDMG;
                                        } else {
                                            System.out.println("The companion strikes enemy 2 dealing" + companionDMG + " damage");
                                            enemy2hp -= companionDMG;
                                        }
                                    }
                                    if (enemy1hp > 0 && battle) {
                                        value = rand.nextInt(20) + 1;
                                        if (decision == 2) {
                                            if (companion) {
                                                boolean target = rand.nextBoolean();
                                                if (target) {
                                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                                    hp -= (value - 1);
                                                } else {
                                                    System.out.println("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                                    companionHP -= (value - 1);
                                                }
                                            } else {
                                                hp -= (value - 1);
                                                System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                            }
                                        } else {
                                            hp -= value;
                                            System.out.println("The enemy strikes, dealing " + value + " damage");
                                        }
                                    }
                                    if (enemy2hp > 0 && battle) {
                                        value = rand.nextInt(20) + 1;
                                        if (decision == 2) {
                                            if (companion) {
                                                boolean target = rand.nextBoolean();
                                                if (target) {
                                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                                    hp -= (value - 1);
                                                } else {
                                                    System.out.println("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                                    companionHP -= (value - 1);
                                                }
                                            } else {
                                                hp -= (value - 1);
                                                System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                            }
                                        } else {
                                            hp -= value;
                                            System.out.println("The enemy strikes, dealing " + value + " damage");
                                        }
                                    }
                                }
                                if (hp <= 0)
                                {
                                    System.out.println ("After everything that happened, your soul is now forfeight");
                                }
                                else
                                {
                                    System.out.println ("Demon 1: \"Well played\"");
                                    System.out.println ("Demon 2: \"We'll keep to our word\"");
                                    System.out.println ("Demon 1: \"Eternal luxury for you it will be\"");
                                    if (companion) {
                                        System.out.println("Companion : \"It's a bit disappointing that we'll never reach our destination, but somehow it doesn't seem so bad\"");
                                    }
                                    System.out.println ("Your soul calms, and seems okay with remaining, so you accept the eternity of luxury");
                                    System.out.println ("You never quite feel truly fulfilled, but, everything seems good enough, so you don't care too much");
                                    play = false;
                                }
                            }
                            else if (path ==11)
                            {
                                //Get OP weapon
                                System.out.println ("As you enter the cavern, you notice a majestic blade embedded into the stone." +
                                        "\nIt seems far more powerful than the weapon you are currently wielding");
                                System.out.println ("Would you like to take it?\n[1] Yes\n[2] No");
                                value = sc.nextInt();
                                if (value == 1)
                                {
                                    if (companion)
                                    {
                                        if (companionDMG < DMG)
                                        {
                                            System.out.println ("Since your old weapon is still better than your companion's weapon, you give it to them");
                                            companionDMG = DMG;
                                            System.out.println ("Companion DMG: " + companionDMG);
                                        }
                                    }
                                    DMG = 15;
                                    System.out.println ("You take the spear\nDMG: " + DMG);
                                }
                                else if (value == 2)
                                {
                                    System.out.println ("Distrustful of the beautiful sword, you ignore it");
                                    if (companion)
                                    {
                                        System.out.println ("Since you don't seem to want the sword, I'll take it");
                                        companionDMG = 15;
                                        System.out.println ("Companion DMG: " + DMG);
                                    }
                                }
                            }
                            else if (path % 7 == 0)
                            {
                                System.out.println ("You encounter some abandoned items, they seem like they could be useful resources.");
                                if (companion)
                                {
                                    resources += 3;
                                    System.out.println ("Resources: " + resources);
                                }
                                else
                                {
                                    resources += 6;
                                    System.out.println ("Resources: " + resources);
                                }
                            }
                            else if (path % 5 == 0)
                            {
                                battle = true;
                                enemyHP = 15;
                                while (hp >= 0 && enemyHP >= 0 && battle)
                                {
                                    System.out.println ("           ____                      ,\n" +
                                            "          /---.'.__             ____//\n" +
                                            "               '--.\\           /.---'\n" +
                                            "          _______  \\\\         //\n" +
                                            "        /.------.\\  \\|      .'/  ______\n" +
                                            "       //  ___  \\ \\ ||/|\\  //  _/_----.\\__\n" +
                                            "      |/  /.-.\\  \\ \\:|< >|// _/.'..\\   '--'\n" +
                                            "         //   \\'. | \\'.|.'/ /_/ /  \\\\\n" +
                                            "        //     \\ \\_\\/\" ' ~\\-'.-'    \\\\\n" +
                                            "       //       '-._| :H: |'-.__     \\\\\n" +
                                            "      //           (/'==='\\)'-._\\     ||\n" +
                                            "      ||                        \\\\    \\|\n" +
                                            "      ||                         \\\\    '\n" +
                                            "snd   |/                          \\\\\n" +
                                            "                                   ||\n" +
                                            "                                   ||\n" +
                                            "                                   \\\\\n" +
                                            "                                    '\n");
                                    System.out.println ("Spider HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                                    System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                            "[4] Heal - 1 resource = 1 hp");
                                    int battleDecision = sc.nextInt();
                                    if (battleDecision == 1)
                                    {
                                        enemyHP -= DMG;
                                        System.out.println("You strike at the spider dealing " + DMG + " damage");
                                    }
                                    else if (battleDecision == 3)
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
                                    else if (battleDecision == 2)
                                    {
                                        System.out.println ("You put up your guard");
                                    }
                                    else if (battleDecision == 4)
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
                                        while (value > resources)
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
                                        enemyHP -= companionDMG;
                                        System.out.println("Your companion strike at the spider dealing " + DMG + " damage");
                                    }
                                    if (enemyHP > 0 && battle)
                                    {
                                        value = rand.nextInt(6) + 1;
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
                                                System.out.println("The spider strikes, dealing " + (value - 1) + " damage");
                                            }
                                        }
                                        else
                                        {
                                            hp -= value;
                                            System.out.println ("The spider strikes, dealing " + value + " damage");
                                        }
                                    }
                                    if (enemyHP == 0)
                                    {
                                        System.out.println ("You have successfully defeated the Spider.");
                                    }
                                }
                                if (hp <= 0)
                                {
                                    System.out.println ("You have died");
                                    play = false;
                                }
                            }
                            else if (path % 2 == 0)
                            {
                                battle = true;
                                enemy1hp = 10;
                                enemy2hp = 10;
                                while (hp >= 0 && (enemy1hp >= 0 || enemy2hp >= 0) && battle) {
                                    System.out.println("  =/\\                 /\\=\n" +
                                            "    / \\'._   (\\_/)   _.'/ \\       (_                   _)\n" +
                                            "   / .''._'--(o.o)--'_.''. \\       /\\                 /\\\n" +
                                            "  /.' _/ |`'=/ \" \\='`| \\_ `.\\     / \\'._   (\\_/)   _.'/ \\\n" +
                                            " /` .' `\\;-,'\\___/',-;/` '. '\\   /_.''._'--('.')--'_.''._\\\n" +
                                            "/.-' jgs   `\\(-V-)/`       `-.\\  | \\_ / `;=/ \" \\=;` \\ _/ |\n" +
                                            "             \"   \"               \\/  `\\__|`\\___/`|__/`  \\/\n" +
                                            "                                  `       \\(/|\\)/       `\n" +
                                            "                                           \" ` \"");
                                    System.out.println("Enemy 1 HP: " + enemy1hp + "Enemy 2 HP: " + enemy2hp +
                                            "\nYour HP:" + hp + "\nResources: " + resources);
                                    if (companion) {
                                        System.out.println("Companion HP: " + companionHP);
                                    }
                                    System.out.println("What would you like to do?\n[1] Attack\n[2] Block\n[3] Run\n" +
                                            "[4] Heal - 1 resource = 1 hp");
                                    int battleDecision = sc.nextInt();
                                    if (battleDecision == 1) {
                                        System.out.println("Which enemy would you like to attack");
                                        int target = sc.nextInt();
                                        if (target == 1) {
                                            enemy1hp -= DMG;
                                            System.out.println("You strike at the enemy dealing " + DMG + " damage");
                                        }
                                    } else if (battleDecision == 3) {
                                        if (rand.nextInt() > 7) {
                                            System.out.println("You successfully run away");
                                            battle = false;
                                        } else {
                                            System.out.println("Your attempt to run failed");
                                        }
                                    } else if (battleDecision == 2) {
                                        System.out.println("You put up your guard");
                                    } else if (battleDecision == 4) {
                                        System.out.print("How much hp would you like to heal? ");
                                        value = sc.nextInt();
                                        if (resources >= value) {
                                            hp += value;
                                            resources -= value;
                                        } else {
                                            System.out.println("Insufficient Resources");
                                        }
                                        while (value > resources) {
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
                                    if (companion) {
                                        if (enemy1hp <= enemy2hp && enemy1hp > 0) {
                                            System.out.println("The companion strikes enemy 1 dealing " + companionDMG + " damage");
                                            enemy1hp -= companionDMG;
                                        } else {
                                            System.out.println("The companion strikes enemy 2 dealing" + companionDMG + " damage");
                                            enemy2hp -= companionDMG;
                                        }
                                    }
                                    if (enemy1hp > 0 && battle) {
                                        value = rand.nextInt(3) + 1;
                                        if (decision == 2) {
                                            if (companion) {
                                                boolean target = rand.nextBoolean();
                                                if (target) {
                                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                                    hp -= (value - 1);
                                                } else {
                                                    System.out.println("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                                    companionHP -= (value - 1);
                                                }
                                            } else {
                                                hp -= (value - 1);
                                                System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                            }
                                        } else {
                                            hp -= value;
                                            System.out.println("The enemy strikes, dealing " + value + " damage");
                                        }
                                    }
                                    if (enemy2hp > 0 && battle) {
                                        value = rand.nextInt(3) + 1;
                                        if (decision == 2) {
                                            if (companion) {
                                                boolean target = rand.nextBoolean();
                                                if (target) {
                                                    System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                                    hp -= (value - 1);
                                                } else {
                                                    System.out.println("The enemy strikes your companion, dealing " + (value - 1) + " damage");
                                                    companionHP -= (value - 1);
                                                }
                                            } else {
                                                hp -= (value - 1);
                                                System.out.println("The enemy strikes, dealing " + (value - 1) + " damage");
                                            }
                                        } else {
                                            hp -= value;
                                            System.out.println("The enemy strikes, dealing " + value + " damage");
                                        }
                                        if (enemy1hp <= 0 && enemy2hp <= 0) {
                                            System.out.println("You have successfully defeated the enemies.\nThey seem to have some" +
                                                    "useful resources.\n Would you like to take them\n" +
                                                    "[1] Yes\n[2] No");
                                            value = sc.nextInt();
                                            if (value == 1) {
                                                if (companion) {
                                                    resources += 3;
                                                    System.out.println("Resources: " + resources);
                                                } else {
                                                    resources += 6;
                                                    System.out.println("Resources: " + resources);
                                                }
                                            }
                                        }
                                    }
                                    if (hp <= 0) {
                                        System.out.println("You have died");
                                        play = false;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println ("There appears to be nothing inside of this cavern");
                            }
                            if (companion)
                            {
                                resources -= 2;
                                System.out.println ("You have consumed 2 resources\nResources: " + resources);
                            }
                            else
                            {
                                resources -= 1;
                                System.out.println ("You have consumed 1 resource\nResources: " + resources);
                            }
                            if (resources < 0)
                            {
                                System.out.println("You have run out of resources and died");
                                play = false;
                            }
                        }
                        System.out.println ("You have come out of the caves on the other side of the mountains");
                    }
                    //Scene 8 - plains + aurora borealis
                    System.out.println (" ` : | | | |:  ||  :     `  :  |  |+|: | : : :|   .        `              .\n" +
                            "      ` : | :|  ||  |:  :    `  |  | :| : | : |:   |  .                    :\n" +
                            "         .' ':  ||  |:  |  '       ` || | : | |: : |   .  `           .   :.\n" +
                            "                `'  ||  |  ' |   *    ` : | | :| |*|  :   :               :|\n" +
                            "        *    *       `  |  : :  |  .      ` ' :| | :| . : :         *   :.||\n" +
                            "             .`            | |  |  : .:|       ` | || | : |: |          | ||\n" +
                            "      '          .         + `  |  :  .: .         '| | : :| :    .   |:| ||\n" +
                            "         .                 .    ` *|  || :       `    | | :| | :      |:| |\n" +
                            " .                .          .        || |.: *          | || : :     :|||\n" +
                            "        .            .   . *    .   .  ` |||.  +        + '| |||  .  ||`\n" +
                            "     .             *              .     +:`|!             . ||||  :.||`\n" +
                            " +                      .                ..!|*          . | :`||+ |||`\n" +
                            "     .                         +      : |||`        .| :| | | |.| ||`     .\n" +
                            "       *     +   '               +  :|| |`     :.+. || || | |:`|| `\n" +
                            "                            .      .||` .    ..|| | |: '` `| | |`  +\n" +
                            "  .       +++                      ||        !|!: `       :| |\n" +
                            "              +         .      .    | .      `|||.:      .||    .      .    `\n" +
                            "          '                           `|.   .  `:|||   + ||'     `\n" +
                            "  __    +      *                         `'       `'|.    `:\n" +
                            "\"'  `---\"\"\"----....____,..^---`^``----.,.___          `.    `.  .    ____,.,-\n" +
                            "    ___,--'\"\"`---\"'   ^  ^ ^        ^       \"\"\"'---,..___ __,..---\"\"'\n" +
                            "--\"'                           ^                         ``--..,__ D. Rice");
                    System.out.println ("Once you arrived on the other side of the mountains, you now see a majestic sight." +
                            "\nAbove the plains, in the sky, you see a beautiful path.\nSomehow, you can tell that " +
                            "if you follow that path, you will arrive at the destination you've been seeking.");
                    if (companion)
                    {
                        System.out.println ("Companion: \"It's there isn't it. It's even more beautiful than I imagined\"");
                        System.out.println ("\"Probably. Shall we.\"");
                    }

                    System.out.println ("You walk, following the path in the sky, until eventually you see something.\n" +
                            "The place that the light goes to. An enormous majestic gate.");
                    //The gate + battle with gatekeeper?
                    System.out.println (" ==                     ==\n" +
                            "                 <^\\()/^>               <^\\()/^>\n" +
                            "                  \\/  \\/                 \\/  \\/\n" +
                            "                   /__\\      .  '  .      /__\\ \n" +
                            "      ==            /\\    .     |     .    /\\            ==\n" +
                            "   <^\\()/^>       !_\\/       '  |  '       \\/_!       <^\\()/^>\n" +
                            "    \\/  \\/     !_/I_||  .  '   \\'/   '  .  ||_I\\_!     \\/  \\/\n" +
                            "     /__\\     /I_/| ||      -== + ==-      || |\\_I\\     /__\\\n" +
                            "     /_ \\   !//|  | ||  '  .   /.\\   .  '  || |  |\\\\!   /_ \\\n" +
                            "    (-   ) /I/ |  | ||       .  |  .       || |  | \\I\\ (=   )\n" +
                            "     \\__/!//|  |  | ||    '     |     '    || |  |  |\\\\!\\__/\n" +
                            "     /  \\I/ |  |  | ||       '  .  '    *  || |  |  | \\I/  \\\n" +
                            "    {_ __}  |  |  | ||                     || |  |  |  {____}\n" +
                            " _!__|= ||  |  |  | ||   *      +          || |  |  |  ||  |__!_\n" +
                            " _I__|  ||__|__|__|_||          A          ||_|__|__|__||- |__I_\n" +
                            " -|--|- ||--|--|--|-||       __/_\\__  *    ||-|--|--|--||= |--|-\n" +
                            "  |  |  ||  |  |  | ||      /\\-'o'-/\\      || |  |  |  ||  |  |\n" +
                            "  |  |= ||  |  |  | ||     _||:<_>:||_     || |  |  |  ||= |  |\n" +
                            "  |  |- ||  |  |  | || *  /\\_/=====\\_/\\  * || |  |  |  ||= |  |\n" +
                            "  |  |- ||  |  |  | ||  __|:_:_[I]_:_:|__  || |  |  |  ||- |  | \n" +
                            " _|__|  ||__|__|__|_||:::::::::::::::::::::||_|__|__|__||  |__|_\n" +
                            " -|--|= ||--|--|--|-||:::::::::::::::::::::||-|--|--|--||- |--|-\n" +
                            "  jgs|- ||  |  |  | ||:::::::::::::::::::::|| |  |  |  ||= |  | \n" +
                            "~~~~~~~~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~");
                    System.out.println ("you approach the gate, but as you try to enter a figure steps out and stops you");
                    System.out.println (" .--.-.\n" +
                            " ( (    )__ \n" +
                            "(_,  \\ ) ,_)\n" +
                            "  '- \\\\---'\n" +
                            "     _\\\\\n" +
                            "    \\\\ .\n" +
                            "    '.\\:.'\n" +
                            "    .':`(\\\n" +
                            "      '  \\\\\n" +
                            "          \\\\\n" +
                            "           \\\\\n" +
                            "            \\\\\n" +
                            "             \\\\\n" +
                            "              \\\\\n" +
                            "               \\\\  _\n" +
                            "                \\\\/@)\n" +
                            "                /(&\\\n" +
                            "               (@(\\&\\       <*****> \n" +
                            "                ` \\/ \\.=^=.  .\"\"\".  .=^=.\n" +
                            "                   \\  \\```\\\\(/a a\\)//```\\\\\n" +
                            "                    \\  \\    (  L  )      }}\n" +
                            "                    {\\  \\ __ \\ = /       }}\n" +
                            "                    {{\\  '--,/'-'\\,---.  }}\n" +
                            "                    {{ \\ |`-._/\\_.-'|  \\ }}\n" +
                            "                    {{  \\|    ||    |\\  \\}}\n" +
                            "                    {{   |___o()o___| >  )}\n" +
                            "                    {{   |__((<>))__|` .'}}\n" +
                            "                    {{   \\   o\\/o   /``  }}\n" +
                            "                    {{  ,'\\   ||   / ',  }}\n" +
                            "                    {{.'   \\  ||  /|   '.}}\n" +
                            "                           |'.||.' |\n" +
                            "                           |    :  |\n" +
                            "                           |    :  |\n" +
                            "                           |    :  |\n" +
                            "                           |    :  |\n" +
                            "                           |    :  |\n" +
                            "                           |    :  |\n" +
                            "                      jgs  |____:__|\n" +
                            "                            (_/ \\_)");
                    System.out.println ("\"Bound ones such as yourselves are forbidden to pass through these gates.\n" +
                            "If you attempt to pass, I will be forced to eliminate you\nAnd do not hope for a drawn out battle" +
                            "for I grow stronger the longer I remain in battle");
                    enemyHP = 100;
                    for (int enemyDMG = 1 ; enemyHP > 0  && hp > 0; enemyDMG++)
                    {
                        System.out.println (" .--.-.\\n\" +\n" +
                                "                            \" ( (    )__ \\n\" +\n" +
                                "                            \"(_,  \\\\ ) ,_)\\n\" +\n" +
                                "                            \"  '- \\\\\\\\---'\\n\" +\n" +
                                "                            \"     _\\\\\\\\\\n\" +\n" +
                                "                            \"    \\\\\\\\ .\\n\" +\n" +
                                "                            \"    '.\\\\:.'\\n\" +\n" +
                                "                            \"    .':`(\\\\\\n\" +\n" +
                                "                            \"      '  \\\\\\\\\\n\" +\n" +
                                "                            \"          \\\\\\\\\\n\" +\n" +
                                "                            \"           \\\\\\\\\\n\" +\n" +
                                "                            \"            \\\\\\\\\\n\" +\n" +
                                "                            \"             \\\\\\\\\\n\" +\n" +
                                "                            \"              \\\\\\\\\\n\" +\n" +
                                "                            \"               \\\\\\\\  _\\n\" +\n" +
                                "                            \"                \\\\\\\\/@)\\n\" +\n" +
                                "                            \"                /(&\\\\\\n\" +\n" +
                                "                            \"               (@(\\\\&\\\\       <*****> \\n\" +\n" +
                                "                            \"                ` \\\\/ \\\\.=^=.  .\\\"\\\"\\\".  .=^=.\\n\" +\n" +
                                "                            \"                   \\\\  \\\\```\\\\\\\\(/a a\\\\)//```\\\\\\\\\\n\" +\n" +
                                "                            \"                    \\\\  \\\\    (  L  )      }}\\n\" +\n" +
                                "                            \"                    {\\\\  \\\\ __ \\\\ = /       }}\\n\" +\n" +
                                "                            \"                    {{\\\\  '--,/'-'\\\\,---.  }}\\n\" +\n" +
                                "                            \"                    {{ \\\\ |`-._/\\\\_.-'|  \\\\ }}\\n\" +\n" +
                                "                            \"                    {{  \\\\|    ||    |\\\\  \\\\}}\\n\" +\n" +
                                "                            \"                    {{   |___o()o___| >  )}\\n\" +\n" +
                                "                            \"                    {{   |__((<>))__|` .'}}\\n\" +\n" +
                                "                            \"                    {{   \\\\   o\\\\/o   /``  }}\\n\" +\n" +
                                "                            \"                    {{  ,'\\\\   ||   / ',  }}\\n\" +\n" +
                                "                            \"                    {{.'   \\\\  ||  /|   '.}}\\n\" +\n" +
                                "                            \"                           |'.||.' |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                           |    :  |\\n\" +\n" +
                                "                            \"                      jgs  |____:__|\\n\" +\n" +
                                "                            \"                            (_/ \\\\_)");
                        System.out.println ("Spider HP: " + enemyHP + "\nYour HP:" + hp + "\nResources: " + resources);
                        System.out.println ("What would you like to do?\n[1] Attack\n[2] Block\n" +
                                "[3] Heal - 1 resource = 1 hp");
                        int battleDecision = sc.nextInt();
                        if (battleDecision == 1)
                        {
                            enemyHP -= DMG;
                            System.out.println("You strike at the Gatekeeper dealing " + DMG + " damage");
                        }
                        else if (battleDecision == 2)
                        {
                            System.out.println ("You put up your guard");
                        }
                        else if (battleDecision == 3)
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
                                if (resources > value)
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
                            enemyHP -= companionDMG;
                            System.out.println("Your companion strike at the Gatekeeper dealing " + companionDMG + " damage");
                        }
                        if (enemyHP > 0 && battle)
                        {
                            if (decision == 2)
                            {
                                if (companion)
                                {
                                    boolean target = rand.nextBoolean();
                                    if (target)
                                    {
                                        System.out.println ("The Gatekeeper strikes, dealing " + enemyDMG + " damage");
                                        hp -= (enemyDMG - 1);
                                    }
                                    else
                                    {
                                        System.out.println ("The enemy strikes your companion, dealing " + enemyDMG + " damage");
                                        companionHP -= (enemyDMG - 1);
                                    }
                                }
                                else
                                {
                                    hp -= (enemyDMG - 1);
                                    System.out.println("The Gatekeeper strikes, dealing " + (enemyDMG - 1) + " damage");
                                }
                            }
                            else
                            {
                                hp -= enemyDMG;
                                System.out.println ("The Gatekeeper strikes, dealing " + enemyDMG + " damage");
                            }
                        }
                        if (hp <= 0)
                        {
                            play = false;
                            System.out.println ("You have perished in your battle against the Gatekeeper, your soul forever lost to the abyss");
                        }
                    }
                    if (play)
                    {
                        if (companion)
                        {
                            System.out.println ("Companion: \"We really did it didn't we\"");
                            System.out.println ("\"Yes, I suppose we did. We should go through shouldn't we.\"");
                        }
                        System.out.println ("You step through the gate into that which lies beyond, and your soul finally knew peace\n" +
                                "For it had finally reached the destination that it had so longed for.");
                    }

                    //Once you finish playing it will end here
                    play = false;
                }}
            else if (menuOption == 2)
            {
                System.out.println("Just select the option you wish to perform.");
            }
            else if (menuOption == 3)
            {
                System.out.print("Goodbye");
                run = false;
            }

        }
    }
}
