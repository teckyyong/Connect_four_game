public class example {
    


    private static boolean Check(char ch){
        //creates flag
        boolean flag = true;

        //checks all Xs at once, for clearner main loop
        if(!CheckVertical(ch) || !CheckHorizontal(ch)|| !CheckDiagonalBack(ch)|| !CheckDiagonalForward(ch)){
            flag = false;
        }
        return flag;
    }

    public static boolean CheckVertical(char ch){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag == true){

            //goes through board vertically
            for(int h = 0; HEIGHT > h; h += 1){
                for(int w = 0; WIDTH > w; w += 1){
                    if(grid[w][h] == ch){ //if it finds an O, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an O, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player" + ch + "wins"); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

}
