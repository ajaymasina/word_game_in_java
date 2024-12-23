package griffith;
import java.util.*;
class Wordle
{
    public static String [] s_arr={"apple","mango","grass","brave","dance"};
    public static final String d = "                                            ";
    public static Scanner sc=new Scanner(System.in);
    public static boolean guess(String s)
    {
        
        int count=0;
        while(count<=5)
        {
            System.out.println(d + "1. Enter a guess");
            System.out.println(d + "2. View rules");
            System.out.println(d + "3. Restart game");
            System.out.println(d + "4. Start a new game");
            System.out.println(d + "5. Quit");
            System.out.print(d + "Choose an option: ");
            int choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                             System.out.println(d +"enter your guess");
                             String guess=sc.next();
			                 count++;
                             if(guess.length()<5)
                             System.out.println(d +"enter a five letter word");
                             else
                             {
                                   if(s.equals(guess))
			                               return true;
                                   else
                                   {
                                         
                                         for(int i=0;i<5;i++)
                                         {
                                             if(guess.charAt(i)==s.charAt(i))
                                             System.out.print(guess.charAt(i)+" ");
                                             else
                                             {
                                                      int f=0;
                                                      for(int j=0;j<5;j++)
                                                      {
                                                            if(s.charAt(j)==guess.charAt(i))
                                                            {
                                                                 f=1;
                                                                 break;
                                                             }
                                                       }
                                                       if(f==1)
                                                         System.out.print("* ");
                                                       else
                                                         System.out.print("_ ");
                                             }
                                           } 
                                           System.out.println();
                                      }
                            }
                            break;
               case 2: displayRules();
                       break;
               case 3: count = 0; 
                       System.out.println("Restarting the game");
                       break;
               case 4: return false;
               case 5:
                       System.out.println("your are quitting the game THANK YOU");
                       System.exit(0);
                     
                         
            }
			
        }
		return false;
    }
     public static void displayRules() {
        System.out.println(d + "Rules of Wordle:");
        System.out.println(d + "1. The word is 5 letters long.");
        System.out.println(d + "2. You have 6 attempts to guess the word.");
        System.out.println(d + "3. Feedback for each guess:");
        System.out.println(d + "   - Correct letters in the correct position are displayed.");
        System.out.println(d + "   - Correct letters in the wrong position are marked with '*'.");
        System.out.println(d + "   - Incorrect letters are marked with '_'.");
        System.out.println(d + "4. At any time, you can:");
        System.out.println(d + "   - Press 2 to see the rules.");
        System.out.println(d + "   - Press 3 to restart the game.");
        System.out.println(d + "   - Press 4 to start a new game.");
        System.out.println(d + "   - Press 5 to quit.");
    }
    public static void main(String[] args) {
        boolean status = true;

        while (status) {
            
            System.out.println(d + "1. Start New Game");
            System.out.println(d + "2. View Rules");
            System.out.println(d + "3. Quit");
            System.out.print(d + "Choose an option: ");
            int choice = sc.nextInt();
            

            switch (choice) {
                case 1:
                    Random random=new Random();
                    int r=random.nextInt(5);
                    String actual = s_arr[r];
                    boolean result = guess(actual);

                    if (result) {
                        System.out.println("Congratulations! You guessed the word: " + actual);
                    } else {
                        System.out.println("You lost the game. The word was: " + actual);
                    }
                    break;

                case 2: 
                    displayRules();
                    break;

                case 3:
                   
                    status = false;
                    break;

            }
        }
    }

}