/* The game that keeps track of all the information, such as
 * the grid and which player's turn */
public class ConnectFour {
  public final static int DEFAULT_HEIGHT =  6;    // The default height of the grid (DO NOT CHANGE)
  public final static int DEFAULT_WIDTH  =  7;    // The default width of the grid (DO NOT CHANGE)
  
  private Disc[][] grid;                          // The grid of the game. A 2D array of Disc objects
  private Player[] allPlayers;                    // An array that stores all the player's object
  private Player currPlayer;                      // Keeps track of the current player
  private int numRounds;                          // Keep track of number of rounds to play
  private int currRound;                          // Keep track of the current round
  
  //======================= CONSTRUCTOR =======================//
  /* @param numRounds - The number of rounds the user wants to play. */
  public ConnectFour(int numRounds) {
    // Instantiate the grid when ConnectFour object is constructed. 
    // Use default values.
    grid = new Disc[DEFAULT_HEIGHT][DEFAULT_WIDTH];
    this.numRounds = numRounds;
    currRound = 0;
    allPlayers = { Player(), Player()};
  }
  
  /* @param numRounds - The number of rounds the user wants to play.
   * @param height    - The grid height. 
   * @param width     - The grid width. */
  public ConnectFour(int numRounds, int height, int width) {    
    grid = new Disc[height][width];
    this.numRounds = numRounds;
    currRound = 0;
  }
  
  //====================== PRIVATE METHOD =======================//
  /* (PLACE YOUR PRIVATE METHODS HERE) */
  
  
  //====================== PUBLIC METHOD =======================//
  /* Get the current round number
   * @return - The current round number. */
  public int GetCurrRound() {
    return 0;   // Dummy return value.
  }
  
  /* Set the current round number.
   * @param newCurrRound - The current new round number */
  public void SetCurrRound(int newCurrRound) {
    
  }
  
  /* Get the total rounds
   * @return - The total number of rounds. */
  public int GetNumRounds() {return 0;   // Dummy return value.
  }
  
  /* It returns the 2D grid to the caller
   * @return - The 2D grid containing Disc objects */
  public Disc[][] GetGrid() {
    return null;   // Dummy return value.
  }
  
  /* Get the grid's height.
   * @return - The grid's height */
  public int GetGridHeight() {
    return 0;   // Dummy return value.
  }
  
  /* Get the grid's width.
   * @return - The grid's width */  
  public int GetGridWidth() {
    return 0;   // Dummy return value.
  }
  
  /* Resets the grid so it contains nothing */
  public void ResetGrid() {
    
  }
  
  /* Get the player object array  
   * @return - The array that contains all the players' object */
  public Player[] GetAllPlayers() {
    return null;   // Dummy return value.
  }
    /* Returns the current player object, represented by a number value
   * @return - The Object that represents the player.
   *           Returns the currently playing Player object */
  public Player GetCurrPlayer() {
    return null;   // Dummy return value.
  }
  
  /* Set who will be the current player
   * @param index - The value that represents the player. This
   *                is based on the array position of where the 
   *                player is stored. */
  public void SetCurrPlayer(int index) {
    
  }  
  
  /* Check if the grid is full
   * @return - Returns true, if the grid is full.
   *           Returns false, if the grid is not full. */    
  public boolean IsGridFull() {
    return false;   // Dummy return value.
  }   
  
  /* Inserts a disc object in the specified column.
   * @param col - The column that the player wants to insert the disc
   *              Note: col = 0 is the 1st column 
   *                    col = 1 is the 2nd column
   *                    etc...
   * @return    - Returns 1, if the disc is inserted successfully into the column.
   *              Returns -1, if the column is full. 
   *              Returns -2, if the column is invalid. */    
  public int Insert(int col) {
    return 0;   // Dummy return value.
  }   
  
  /* Get the number of available (empty) blocks in the grid
   * @return - The number of empty blocks */
  public int NumAvailBlock() {
    return 0;   // Dummy return value.
  }   
  
  /* Get the current player's name (either X or O)
   * @return - The player's name, either "X" or "O" */   
  public char GetCurrPlayerChar() {
    return 's';   // Dummy return value.
  }
  
  /* Switch player's turn to the next player (If current player is X, then it 
   * switches to O. If current player is O, then it switches to X) */   
  public void SwitchPlayer() {
    
  }
  
  /* Check is there is a winner for the current round 
   * @return - Returns true, if there is a winner.
   *           Returns false, if there is no winner */      
  public boolean HasRoundWinner() {
    return false;   // Dummy return value.
  }
  
  /* Determine the final winner by checking the player's score. 
   * @return - Returns the array position value that represents the player who wins.
   *           Returns -1,if there's a tie (same score) */
  public int GetGameWinner() {
    return 0;   // Dummy return value.
  }
}