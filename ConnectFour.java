/**
 * Code Reference:
 * https://codereview.stackexchange.com/questions/100917/connect-four-game-in-java
 * 
 */

/*
 * The game that keeps track of all the information, such as
 * the grid and which player's turn
 */
public class ConnectFour {
  public final static int DEFAULT_HEIGHT = 6; // The default height of the grid (DO NOT CHANGE)
  public final static int DEFAULT_WIDTH = 7; // The default width of the grid (DO NOT CHANGE)

  private Disc[][] grid; // The grid of the game. A 2D array of Disc objects
  private Player[] allPlayers; // An array that stores all the player's object
  private Player currPlayer; // Keeps track of the current player
  private int numRounds; // Keep track of number of rounds to play
  private int currRound; // Keep track of the current round
  private int height, width; // height and width of the grid

  // ======================= CONSTRUCTOR =======================//
  /* @param numRounds - The number of rounds the user wants to play. */
  public ConnectFour(int numRounds) {
    // Instantiate the grid when ConnectFour object is constructed.
    // Use default values.
    grid = new Disc[DEFAULT_HEIGHT][DEFAULT_WIDTH];
    height = DEFAULT_HEIGHT;
    width = DEFAULT_WIDTH;
    this.numRounds = numRounds;
    // currRound = 1;

    Disc disc_o = new Disc(Disc.O_DISC);
    int disc0 = disc_o.GetDiscType();
    Player player_o = new Player(disc0);

    Disc disc_x = new Disc(Disc.X_DISC);
    int discx = disc_x.GetDiscType();
    Player player_x = new Player(discx);

    allPlayers = new Player[2];
    allPlayers[0] = player_o;
    allPlayers[1] = player_x;

  }

  /*
   * @param numRounds - The number of rounds the user wants to play.
   * 
   * @param height - The grid height.
   * 
   * @param width - The grid width.
   */
  public ConnectFour(int numRounds, int height, int width) {
    grid = new Disc[height][width];
    this.height = height;
    this.width = width;
    this.numRounds = numRounds;
    // currRound = 1;

    Disc disc_o = new Disc(Disc.O_DISC);
    int disc0 = disc_o.GetDiscType();
    Player player_o = new Player(disc0);

    Disc disc_x = new Disc(Disc.X_DISC);
    int discx = disc_x.GetDiscType();
    Player player_x = new Player(discx);

    allPlayers = new Player[2];
    allPlayers[0] = player_o;
    allPlayers[1] = player_x;

  }

  // ====================== PRIVATE METHOD =======================//
  /* (PLACE YOUR PRIVATE METHODS HERE) */
    /*
   *   Check for vertical strike
   * 
   * returns true if a vertical 4-strike exists, else returns false
   */
  private boolean CheckVertical() {
    char player_char = GetCurrPlayerChar(); // "X" or "O"
    int player_disc = currPlayer.GetDiscType(); // 1 or 0

    for (int col = 0; col < GetGridWidth(); col++) { // for each column left to right
      int counter = 0; // to keep track of the number of strike
      for (int row = GetGridHeight() - 1; row >= 0; row--) { // check from bottom to top
        if (grid[row][col] == null) { // if null, then go to next column
          break;
        } else if (grid[row][col].GetDiscType() == player_disc) { // if is the current player's disctype, its a
                                                                  // potential strike
          counter++; // so start counting strike
        } else { // if is opponent's disctype, reset back to 0 and start counting again
          counter = 0;
        }

        if (counter >= 4) { // once there's 4 strike, winner is found, return true.
          System.out.println("Round " + GetCurrRound() + "winner is Player " + player_char);

          return true;
        }
      }
    }
    return false;
  }

    /*
   * Check for horizontal strike
   * 
   * returns true if a horizontal 4-strike exists, else returns false
   */
  private boolean CheckHorizontal() {
    char player_char = GetCurrPlayerChar();
    int player_disc = currPlayer.GetDiscType();

    for (int row = GetGridHeight() - 1; row >= 0; row--) { // for every row from bottom to top
      int counter = 0;
      for (int col = 0; col < GetGridWidth(); col++) { // check every column from left ot right
        if ((grid[row][col] == null) || (grid[row][col].GetDiscType() != player_disc)) { // if null or opponents
                                                                                         // discType
          counter = 0; // counter resets to 0
        } else if (grid[row][col].GetDiscType() == player_disc) { // if is the current player's disctype
          counter++; // counter += 1
        }
        if (counter >= 4) {// once there's 4 strike, winner is found, return true.
          System.out.println("Round " + GetCurrRound() + "winner is Player " + player_char);
          return true;
        }
      }
    }
    return false;
  }

  // ====================== PUBLIC METHOD =======================//
  /*
   * Get the current round number
   * 
   * @return - The current round number.
   */
  public int GetCurrRound() {
    return currRound; // Dummy return value.
  }

  /*
   * Set the current round number.
   * 
   * @param newCurrRound - The current new round number
   */
  public void SetCurrRound(int newCurrRound) {
    currRound = newCurrRound;
  }

  /*
   * Get the total rounds
   * 
   * @return - The total number of rounds.
   */
  public int GetNumRounds() {
    return numRounds; // Dummy return value.
  }

  /*
   * It returns the 2D grid to the caller
   * 
   * @return - The 2D grid containing Disc objects
   */
  public Disc[][] GetGrid() {
    return grid; // Dummy return value.
  }

  /*
   * Get the grid's height.
   * 
   * @return - The grid's height
   */
  public int GetGridHeight() {
    return height;
  }

  /*
   * Get the grid's width.
   * 
   * @return - The grid's width
   */
  public int GetGridWidth() {
    return width;
  }

  /* 
  * Resets the grid so it contains nothing 
  */
  public void ResetGrid() {
    grid = new Disc[height][width];

  }

  /*
   * Get the player object array
   * 
   * @return - The array that contains all the players' object
   */
  public Player[] GetAllPlayers() {
    return allPlayers; // Dummy return value.
  }

  /*
   * Returns the current player object, represented by a number value
   * 
   * @return - The Object that represents the player.
   * Returns the currently playing Player object
   */
  public Player GetCurrPlayer() {
    return currPlayer; // Dummy return value.
  }

  /*
   * Set who will be the current player
   * 
   * @param index - The value that represents the player. This
   * is based on the array position of where the
   * player is stored.
   */
  public void SetCurrPlayer(int index) {
    currPlayer = allPlayers[index];
  }

  /*
   * Check if the grid is full
   * 
   * @return - Returns true, if the grid is full.
   * Returns false, if the grid is not full.
   */
  public boolean IsGridFull() {
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == null) {
          return false;
        }

      }
    }
    return true; // returns true after checking all rows and all cols
  }

  /*
   * Inserts a disc object in the specified column.
   * 
   * @param col - The column that the player wants to insert the disc
   * Note: col = 0 is the 1st column
   * col = 1 is the 2nd column
   * etc...
   * 
   * @return - Returns 1, if the disc is inserted successfully into the column.
   * Returns -1, if the column is full.
   * Returns -2, if the column is invalid.
   */
  public int Insert(int col) {
    int num_col = grid[0].length;
    if (col < 1 || col > num_col) {
      return -2;
    }

    col -= 1; // fixed
    int discType = currPlayer.GetDiscType();
    for (int row = grid.length - 1; row >= 0; row--) {
      if (grid[row][col] == null) {
        grid[row][col] = new Disc(discType);
        break;
      } else if (row == 0) { // not null
        return -1;
      }
    }
    return 1;
  }

  /*
   * Get the number of available (empty) blocks in the grid
   * 
   * @return - The number of empty blocks
   */
  public int NumAvailBlock() {
    // check number of empty block
    int count = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == null) {
          count += 1;
        }
      }
    }
    return count;
  }

  /*
   * Get the current player's name (either X or O)
   * 
   * @return - The player's name, either "X" or "O"
   */
  public char GetCurrPlayerChar() {
    if (currPlayer.GetDiscType() == Disc.O_DISC) {
      return 'O';
    } else {
      return 'X';
    }

  }

  /*
   * Switch player's turn to the next player (If current player is X, then it
   * switches to O. If current player is O, then it switches to X)
   */
  public void SwitchPlayer() {
    if (currPlayer == allPlayers[0]) {
      currPlayer = allPlayers[1];
    } else {
      currPlayer = allPlayers[0];
    }
  }

  /*
   * Check is there is a winner for the current round
   * 
   * @return - Returns true, if there is a winner.
   * Returns false, if there is no winner
   */
  public boolean HasRoundWinner() {
    boolean is_curr_player_win;
    if ((CheckVertical() == true) || (CheckHorizontal() == true)) {
      is_curr_player_win = true;
    }else{
      is_curr_player_win = false;
    }
    
    // calculate score
    if (is_curr_player_win == true) {
      int num_empty = NumAvailBlock();
      currPlayer.AddScore(num_empty);
      return true;
    }

    return false;
  }

  /*
   * Determine the final winner by checking the player's score.
   * 
   * @return - Returns the array position value that represents the player who
   * wins.
   * Returns -1,if there's a tie (same score)
   */
  public int GetGameWinner() {
    int max_score = allPlayers[0].GetScore();
    int position = 0;
    for (int i = 1; i < allPlayers.length; i++) {
      if (allPlayers[i].GetScore() > max_score) { // if player at position 1 has higher score than player at position 0
        max_score = allPlayers[i].GetScore();
        position = i; // change to position 1
      } else if (allPlayers[i].GetScore() == max_score) { // tie
        return -1;
      }
    }

    return position; // return position with highest score
  }
}