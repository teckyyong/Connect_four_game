import java.util.Scanner;
public class ConnectFourMain {
  public static void main(String[] args) {
    ConnectFour cf;                          // Creates the ConnectFour object (DO NOT DELETE IT)
    Displayer displayer = new Displayer();   // Creates the Displayer object (DO NOT DELETE IT)
    Scanner input = new Scanner(System.in);
  
    int num_Round;
    int choice;
    String player;

    displayer.GameHeader();
    System.out.print("Round of games to play? ");
    num_Round= input.nextInt();

    System.out.println("\nGrid Type?");
    System.out.println("1. Default (6x7)");
    System.out.println("2. Custom");
    System.out.print("Choice: ");
    choice= input.nextInt();

    if( choice == 1 ){  // default
      cf= new ConnectFour(num_Round);
    }else if( choice == 2 ){ //custom
      int height , width;
      System.out.print("Please enter custom height: ");
      height = input.nextInt();
      System.out.print("Please enter custom width: ");
      width = input.nextInt();

      cf= new ConnectFour(num_Round , height , width);

    }else{

    }
    
      
    displayer.ScoreBoard(score_O,score_X );
    // System.out.print("Who will start first (O or X)? ");
    // input.nextLine();
    // player = input.nextLine();
    // System.out.println("\n");

   
   // displayer.ScoreBoard(score_O,score_X );
  }
}