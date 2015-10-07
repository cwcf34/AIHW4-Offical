import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Cody
 *
 */
public class AIHW4 {
	public static String[][] s = new String[11][11];
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Create game and initialize it.
				// First player will be 'x'
				TicTacToe game = new TicTacToe();

				// Player 'x' places a mark in the top right corner row 0, column 2
				// These values are based on a zero index array, so you may need to simply take in a row 1 and subtract 1 from it if you want that.
				/*game.placeMark(0,0);
				game.placeMark(1,0);
				game.placeMark(0,1);
				game.placeMark(1,1);
				game.placeMark(0,2);
				game.placeMark(1,2);
				game.placeMark(0,3);*/
				
				
				// Lets print the board
				game.printBoard();
				
				/*Scanner e = new Scanner (System.in);
				Random r = new Random();
				 int low =0; 
				 int high =3;
				 
				 AIPlayer ai = new AIPlayer();
				 int a; 
				 int row,col; //entered row and column
				 
				 for(int i=0;i<3;i++){
					 for(int j=0;j<3;j++){
						 s[i][j] =" ";
					 }
				 }
				 System.out.print("Welcome to AI Tic-Tac_toe in Console \n");

				 int temp = 16;
				 for(a=1;a<10;a++){
					 game.printBoard();
				 
				 
				 if(a%2 !=0){
					 System.out.println("Enter the row and column for player A (X) ");
					 game.changePlayer();
					 row= e.nextInt();
					 col =e.nextInt();
					 do{
						 	if((row<0&&row>3)&& (col<0&&col>3)){
							 System.out.println("Wrong Enter,Please enter row and col again");
							 row= e.nextInt();
							 col =e.nextInt();

						 	}
						 	
						 	if(s[row][col]!=" "){
						 		System.out.println("Wrong Enter,Please enter row and col again");
						 		row= e.nextInt();
						 		col =e.nextInt();
						 	}
					 } while(s[row][col]!=" ");
				 
					 System.out.println("\n");
					 game.placeMark(row, col);
					 ?????t.check_A();

				 }
				 
				 else{
					game.changePlayer();
				 
					int [] result = ai.minimax(temp, player);
					//temp--;
					row = result[1];
					col = result[2];
					//System.out.println("BestScore"+result[0]);
					//System.out.println("Col is "+col);
					System.out.println("\n");
					game.placeMark(row, col);
					?????t.check_B();
				 
				 }
				 }//if for a%2!=0 closed
				 
				 System.out.println("Draw match");
				 }
				}*/

				// Did we have a winner?
				if (game.checkForWin()) {
				   System.out.println("We have a winner! Congrats!");
				   System.exit(0);
				}
				else if (game.isBoardFull()) {
				   System.out.println("Appears we have a draw!");
				   System.exit(0);
				}

				// No winner or draw, switch players to 'o'
				game.changePlayer();

	}

}
