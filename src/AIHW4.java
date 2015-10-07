/**
 * 
 */
import java.util.Random;
import java.io.BufferedReader;
import java.util.Scanner;
/**
 * @author Cody
 *
 */
public class AIHW4 
{

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
		int i;
		int j=0;
		
		// Player 'x' places a mark in the top right corner row 0, column 2
		// These values are based on a zero index array, so you may need to simply take in a row 1 and subtract 1 from it if you want that.
	
	/*	game.changePlayer();
		game.placeMark(4,4);
		game.placeMark(4,3);
		game.placeMark(4,2);
		game.placeMark(3,4);
		game.placeMark(3,3);
		game.placeMark(3,2);
		
		game.changePlayer();
		game.placeMark(0,0);
		game.placeMark(0,1);
		game.placeMark(0,2);
		game.placeMark(1,0);
		game.placeMark(1,1);
		game.placeMark(1,2);*/
		
		int chosen_row;
		int chosen_column;
		int row;
		int column;
		int move_selected = 0;
		
		while (game.checkForWin() == false)	
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the row you would like to select (0-4)");
			chosen_row = scan.nextInt();
			System.out.println("Enter the column you would like to select (0-4)");
			chosen_column = scan.nextInt();
			
			game.placeMark(chosen_row, chosen_column);
			
			game.changePlayer();
			
			game.printBoard();
			
			System.out.println("Now for the Beginner's turn");
			
			chosen_row = -1;
			chosen_column = -1;
			row = -1;
			column = -1;
			move_selected = 0;
			
			//double for loop to check if there is 3-in-a-row in a row
			for (i=0; i<=4; i++) 
			{
				for (j=0; j<=2; j++)
				{
					if (TicTacToe.board[i][j] != '-' && TicTacToe.board[i][j+1] == TicTacToe.board[i][j]  && TicTacToe.board[i][j+2] == TicTacToe.board[i][j])
					{
						row = i;
						if (j==2)
						{
							column = 1;
							if(TicTacToe.board[row][column] != '-')
							{
								column = 10;
							}
							if (column == 1)
							{
								move_selected = 1;
							}
						}
						else if (j == 0)	
						{
							column = j+3;
							if(TicTacToe.board[row][column] != '-')
							{
								column = 10;
							}
							if (column != 10)
							{
								move_selected = 1;
									
							}
						
						}
						else if (j == 1)
						{
							column = j+3;
							if(TicTacToe.board[row][column] != '-')
							{
								column = 0;
								if(TicTacToe.board[row][column] != '-')
								{
									column = 10;
									
								}
							}
							if (column != 10)
							{
								move_selected = 1;
							}
						}
						
					}
					if (move_selected == 1)
					{
						break;
					}
				}
				if (move_selected == 1)
				{
					break;
				}
			}
			
			//double for loop to check if there is 3-in-a-row in a column
			
			for (j=0; j<=4; j++)
			{
				for (i=0; i<=2; i++)
				{
					if (TicTacToe.board[i][j] != '-' && TicTacToe.board[i+1][j] == TicTacToe.board[i][j]  && TicTacToe.board[i+2][j] == TicTacToe.board[i][j])
					{
						column = j;
						if (i==2)
						{
							row = 1;
							if(TicTacToe.board[row][column] != '-')
							{
								row = 10;
							}
							if (row == 1)
							{
								move_selected = 1;
							}
						}
						else if (i == 0)	
						{
							row = i+3;
							if(TicTacToe.board[row][column] != '-')
							{
								row = 10;
							}
							if (row != 10)
							{
								move_selected = 1;
									
							}
						
						}
						else if (i == 1)
						{
							row = i+3;
							if(TicTacToe.board[row][column] != '-')
							{
								row = i-1;
								if(TicTacToe.board[row][column] != '-')
								{
									row = 10;
									
								}
							}
							if (row != 10)
							{
								move_selected = 1;
							}
						}
						
					}
					if (move_selected == 1)
					{
						break;
					}
				}
				if (move_selected == 1)
				{
					break;
				}
			}
			
			if (move_selected == 1)
			{
				game.placeMark(row, column);
				
				game.printBoard();
			}
			else
			{
				
			
				Random rn = new Random();
			
				row = rn.nextInt(5);
				column = rn.nextInt(5);
				System.out.println(row);
				System.out.println(column);
			
				while (TicTacToe.board[row][column] != '-' )
				{
					row = rn.nextInt(5);
					column = rn.nextInt(5);
				}
			
				game.placeMark(row,column);
			
				game.printBoard();
			}
				
			if (game.checkForWin()) 
			{
				System.out.println("We have a winner! Congrats!");
				System.exit(0);
			}
			else if (game.isBoardFull()) 
			{
				System.out.println("We have a tie!");
				System.exit(0);
			}
			
			game.changePlayer();
			
		//scan.close();
		// Lets print the board
		//game.printBoard();

		// Did we have a winner?
		/*if (game.checkForWin()) 
		{
			System.out.println("We have a winner! Congrats!");
			System.exit(0);
		}i
		else if (game.isBoardFull()) 
		{
			System.out.println("Appears we have a draw!");
			System.exit(0);
		}*/

		// No winner or draw, switch players to 'o'
		//game.changePlayer();
		}
	}

}
