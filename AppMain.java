package projects;
import java.util.*;

public class AppMain {
    
    TreeMap<Integer,  String> result = new TreeMap<>();
    int chances;
    int win=0;
    
    public static void main(String args[]){
        
        System.out.println("******************************* GUESS THE NUMBER *****************************************************************************************************");
       
        System.out.println("\n You can play the game with all your friends and find out who is best in guessing the things!!");
        System.out.println("You will have total 5 chances and every wrong guess will cost you 1 chance.");
        System.out.println("At last you can view the scorecard and fid out who guessed the number fastest.");
        System.out.println("\nSo what are you waiting for? Let's start the game!!!!!!!!!!");
        
        System.out.println("\n******************************************************************************************************************************************************");
        
        AppMain obj= new AppMain();
        obj.start();
    }
    
    public void start(){
        Scanner sc= new Scanner(System.in);
        
        chances=5;
        
        try{
        
            System.out.print("Enter the player's name: ");
            String name= sc.next();

            System.out.print(name+ " enter the range of the number to be guessed within: ");
            int min= sc.nextInt();
            int max= sc.nextInt();

            int randomInt = (int)Math.floor(Math.random() * (max - min + 1) + min);      

            while(chances>0){
                System.out.print("\n"+name+ " guess the number: ");
                int userNo = sc.nextInt();

                if(userNo>randomInt){
                    System.out.println("Your guessed number is greater than the generated number.");                    
                }

                else if(userNo<randomInt){
                    System.out.println("Your guessed number is lesser than the generated number: ");
                }

                else{
                    win=1;
                    break;
                }

                chances--;
                System.out.println("Now you are left with "+ chances);            
            }    

            if(win==1){
                System.out.println("\nCongratulations!! You won the game");
            }

            else{
                System.out.println("\nSorry, Your chance is over!!");
            }

            System.out.print("\nDo you want to continue (y/n): ");
            char ch= sc.next().charAt(0);

            switch(ch){
                case 'y':
                case 'Y':
                    start();
                    break;
                case 'n':
                case 'N':
                    System.out.println("Thanks for playing the game!!");
                    break;
                default:
                    System.out.println("Enter valid choice!!");
            }

            result.put( 5-chances, name);
            printScoreBoard();
            
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            printScoreBoard();
        }
    }
    
    public void printScoreBoard()
    {
        System.out.println("******************************* SCORE BOARD *****************************************************************************************************");
        System.out.println("Your fastest games today out of all tries is "+ result.firstKey() +" by " + result.firstEntry().getValue());
        System.out.println("\n*************************************************************************************************************************************************\n");
    }
    
}
