import java.util.Scanner;

public class ConnectFourMain {
  public static void main(String[] args) {
    ConnectFour cf; // Creates the ConnectFour object (DO NOT DELETE IT)
    Displayer displayer = new Displayer(); // Creates the Displayer object (DO NOT DELETE IT)
    Scanner input = new Scanner(System.in);

    int num_Round;
    int choice;
    String player;

    displayer.GameHeader();
    System.out.print("Round of games to play? ");
    num_Round = input.nextInt();

    System.out.println("\nGrid Type?");
    System.out.println("1. Default (6x7)");
    System.out.println("2. Custom");
    System.out.print("Choice: ");
    choice = input.nextInt(); // checking.make sur echoice is either 1 or 2
    // if choice != 1 or choice !=2

    if (choice == 1) { // default
      cf = new ConnectFour(num_Round);
    } else { // choice ==2 --> custom
      int height, width;
      System.out.print("Please enter custom height: ");
      height = input.nextInt();
      System.out.print("Please enter custom width: ");
      width = input.nextInt();

      cf = new ConnectFour(num_Round, height, width);
    }

    System.out.print("Who will start first (O or X)? ");
    input.nextLine();
    player = input.nextLine();
    System.out.println("\n");

    // set current round
    cf.SetCurrRound(1);
    // set current player 
    if (player == "O") {
      cf.SetCurrPlayer(Disc.O_DISC);
    } else {
      cf.SetCurrPlayer(Disc.X_DISC);
    }

    Player[] all_player = cf.GetAllPlayers();
    Player o;
    Player x;
    if (all_player[0].GetDiscType() == Disc.O_DISC) {
      o = all_player[0];
      x = all_player[1];
    } else {
      x = all_player[0];
      o = all_player[1];
    }

    displayer.ScoreBoard(o, x);
    int curr_round = cf.GetCurrRound();
    displayer.ShowRound(curr_round);
    Disc[][] grid = cf.GetGrid();
    displayer.ShowGrid(grid);

    input.close();
  }

}