/* To display the grid with the given 2D array */
public class Displayer {
  //======================= CONSTRUCTOR =======================//
  public Displayer() {
    
  }
  
  //====================== PRIVATE METHOD =======================//
  /* (PLACE YOUR PRIVATE METHODS HERE) */   
  
  //====================== PUBLIC METHOD =======================//
  /* Displays the game title screen */
  public void GameHeader() {
    System.out.println("==============================");
    System.out.println("|       CONNECT FOUR         |");
    System.out.println("==============================");
  }
  
  /* Display the player's score on the screen 
   * @param x - Object that represents player x  
   * @param o - Object that represents player o */
  public void ScoreBoard(Player o, Player x) {
    System.out.println("CURRENT SCORE--------------");
    System.out.println("PLAYER 0: "+ o.GetScore()+" points");
    System.out.println("PLAYER X: "+ x.GetScore()+" points");
  }
  
  /* Display the current round number
   * @param roundNum - The current round's number */
  public void ShowRound(int roundNum ) {
    System.out.printf("*******************%6s %1d *******************\n","ROUND", roundNum);
  }
  
  /* Takes in the 2D grid and displays the contains as a 
   * grid on the screen, for players to see the current state
   * @param grid - The 2D array that contains Disc objects */
  public void ShowGrid(Disc[][] grid) {
    int num_col = grid[0].length;
    String separator = "" ;
    for (int i = 0 ; i < num_col; i++){
      separator += "----";
    }

    for (int row = 0; row < grid.length ; row++) {
      System.out.println("     " + separator);
      System.out.print("     "); // for each row, print empty space before first column
      for (int col = 0; col < grid[row].length; col++) { 
        if (grid[row][col] == null){
          System.out.print("|   ");
        }
        else if(grid[row][col].GetDiscType() == Disc.O_DISC){
          System.out.print(" O ");
        }else{  // (grid[row][col].GetDiscType() == Disc.X_DISC)
          System.out.print(" X ");
        }

        if (col == grid[row].length-1){
          System.out.println("|");
        }
       }
       if(row == grid.length-1){
        System.out.println("     " + separator);
        System.out.print("COL  ");
        for(int i=1 ; i<= num_col ; i++){
          System.out.print("  "+ i+ " " );
        }

       }

      }
    }
    
  }