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
    System.out.print("PLAYER 0: "+ o.GetScore()+"points");
    System.out.print("PLAYER X: "+ x.GetScore()+"points");
  }
  
  /* Display the current round number
   * @param roundNum - The current round's number */
  public void ShowRound(int roundNum ) {
    System.out.printf("*******************%6s %1d *******************","ROUND", roundNum);
  }
  
  /* Takes in the 2D grid and displays the contains as a 
   * grid on the screen, for players to see the current state
   * @param grid - The 2D array that contains Disc objects */
  public void ShowGrid(Disc[][] grid) {
    
  }
}