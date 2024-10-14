import java.util.Random;
import java.util.Scanner;

public class Craps_Game {
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int initSum = 0;
        int pointRoll = 0;
        String done = "";


        do{
            System.out.println("Type 'roll' to roll the dice, or QUIT to quit: ");
            done = in.nextLine().trim();
            if(done.equalsIgnoreCase("roll"))
            {
                System.out.println("Die 1 Die 2   Sum");
                System.out.println("-------------------");
                int initialRoll1 = rnd.nextInt(6) + 1;
                int initialRoll2 = rnd.nextInt(6) + 1;
                initSum = initialRoll1 + initialRoll2;
                System.out.printf("%3d\t %3d\t %3d\n", initialRoll1, initialRoll2, initSum);

                if(initSum == 2 || initSum == 3 || initSum == 12)
                {
                    System.out.println("Craps! You crapped out and the game is over with a lost! ");
                    System.out.println("You rolled: " + initSum);
                }else if (initSum == 7 || initSum == 11)
                {
                    System.out.println("Natural! You got a natural and the game is over with a win! ");
                    System.out.println("You rolled: " + initSum);
                }else{
                    pointRoll = initSum;
                    System.out.println("The point is: "+ pointRoll);
                    System.out.println("You must roll and make this point to win with as many rolls as you can, however if you roll a 7, you lose! ");

                    while(true){
                        System.out.println("Type 'roll to roll again, or 'QUIT' to quit: ");
                        done = in.nextLine().trim();

                        if(done.equalsIgnoreCase("roll"))
                        {
                            System.out.printf("%3d\t %3d\t %3d\n", initialRoll1, initialRoll2, initSum);
                            if(initSum == pointRoll){
                                System.out.println("You win! ");
                                break;
                            }else if(initSum == 7)
                            {
                                System.out.println("You lose! ");
                                break;
                            } else{
                                System.out.println("You have to roll again! ");
                            }
                        }
                    }
                }
            }
        }while(!done.equalsIgnoreCase("quit"));
    }
}