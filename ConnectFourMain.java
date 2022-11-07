import java.util.Scanner;

public class ConnectFourMain {
  public static void main(String[] args) {
    ConnectFour cf; // Creates the ConnectFour object (DO NOT DELETE IT)
    Displayer displayer = new Displayer(); // Creates the Displayer object (DO NOT DELETE IT)
    Scanner input = new Scanner(System.in);

    int num_Round;
    int choice = 0;
    String player;

    displayer.GameHeader();
    System.out.print("Round of games to play? "); // assume correct input
    num_Round = input.nextInt();

    do {
      System.out.println("\nGrid Type?");
      System.out.println("1. Default (6x7)");
      System.out.println("2. Custom");
      System.out.print("Choice: ");
      choice = input.nextInt(); // checking. make sure choice is either 1 or 2. // assume correct input
      if (choice != 2 && choice != 1) {
        System.out.println("choice entered invalid pls enter again ");
      }
    } while (choice != 2 && choice != 1);

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
    if (player== "O") {
      System.out.println("here");
      cf.SetCurrPlayer(0);
    } else {
      cf.SetCurrPlayer(1);
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

    // * Run for {num_round} times
    int curr_round = cf.GetCurrRound();
    while (curr_round <= num_Round) { // every round
      displayer.ScoreBoard(o, x); // printed every round
      displayer.ShowRound(curr_round);

      // * Switch player for every turn
      while (cf.IsGridFull() == false) { // while grid is not full
        // * Get current grid and print grid
        Disc[][] grid = cf.GetGrid(); // get
        displayer.ShowGrid(grid); // print

        // * Ask current player for input
        int status = 0; // 0 is a dummy value
        while (status != 1) { // while insert is unsuccessful
          System.out.print("Player " + cf.GetCurrPlayerChar() + ", pick a column to insert your disc: ");
          int insert_col = input.nextInt();
          status = cf.Insert(insert_col);
          if (status == -1) {
            System.out.println("WARNING: Column " + insert_col + " is not available");
          } else if (status == -2) {
            System.out.println("WARNING: Column " + insert_col + " is invalid");
          }

        }

        // * Check win
        boolean is_round_winner = cf.HasRoundWinner();

        if (is_round_winner) {
          char round_winner = cf.GetCurrPlayerChar();
          int points = cf.NumAvailBlock();
          System.out.println(round_winner + " will get " + points + " points");
        }

        else if (cf.IsGridFull() == true) {
          System.out.println("Round " + curr_round + " is a tie. Grid is full.");
        } else { // * Switch player
          System.out.println("Click 'Enter' to continue next round.");
          input.nextLine();
          cf.SwitchPlayer();
        }

      }
      // move on to next round
      curr_round += 1;
      cf.SetCurrRound(curr_round);

    }
    // *print current score board
    displayer.ScoreBoard(o, x);

    // * print winner or tie
    int status = cf.GetGameWinner();
    if (status == -1) {
      System.out.println("Round " + num_Round + "is a tie");
    } else { // status is 0 or 1, representing the position of winner at all_players[]
      Player winner = all_player[status];
      String player_symbol;
      if (winner.GetDiscType() == Disc.O_DISC) {
        player_symbol = "O";
      } else if (winner.GetDiscType() == Disc.X_DISC) {
        player_symbol = "X";
      } else {
        player_symbol = ""; // if neither is winner, which is impossible. means theres error in code, need
                            // to debug
      }
      System.out.println("The final winner is Player " + player_symbol);
    }

    input.close();
  }

}