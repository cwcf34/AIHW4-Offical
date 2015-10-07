import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.pipe.NextAction;


public class AIPlayer extends AIHW4 {
//public static String[][] s = new String[11][11];
 
 //player may be computer(29) or opponent(21)
 public int[] minimax(int depth,int player){
	 
 
	 List<int[]> nextMoves = generateMoves();
	 //System.out.println(player);
	 int bestScore = (player==29)?Integer.MIN_VALUE:Integer.MAX_VALUE;
	 //System.out.println(bestScore);
	 int currentScore;
	 int bestRow =-1;
	 int bestCol =-1;

	 if(nextMoves.isEmpty() || depth ==0 ) {
		 	//System.out.print("nextMoveEmpty()");
		 	bestScore = evaluate();
 
	 }
	 else {
 
		 for (int[] moves:nextMoves){
			 if(player == 21){
				 s[moves[0]][moves[1]] = "X";
			 }else if(player ==29){
				 s[moves[0]][moves[1]] = "O";
 
			 }
 
			 if(player == 29){
 
			currentScore =minimax(depth-1, 21)[0]; 
		
			if(currentScore >bestScore){
 
				bestScore = currentScore;
				bestRow = moves[0];
				bestCol = moves[1];
			}
			} else {
				currentScore =minimax(depth-1, 29)[0]; 
				if(currentScore <bestScore){
					bestScore = currentScore;
					bestRow = moves[0];
					bestCol = moves[1];
				}
 
 
			}
	
			s[moves[0]][moves[1]] = " ";
		 }
	}
 
 return new int[] { bestScore,bestRow,bestCol};
 }

 private int evaluate() {
	 int Score =0;
 
	 Score = Score+evalFunc(0,0,0,1,0,2); //row1
 
	 Score = Score+evalFunc(1,0,1,1,1,2); //row2
 
	 Score = Score+evalFunc(2,0,2,1,2,2); //row3
 
	 Score = Score+evalFunc(0,0,1,0,2,0); //col1
 
	 Score = Score+evalFunc(0,1,1,1,1,2); //col2
 
	 Score = Score+evalFunc(0,2,1,2,2,2); //col3
 
	 Score = Score+evalFunc(0,0,1,1,2,2); //diag1
 
	 Score = Score+evalFunc(0,2,1,1,2,0); //diag2
 
 
	 return Score;
 }

 private int evalFunc(int row1, int col1, int row2, int col2, int row3, int col3) {
	 int Score = 0;
 
	 if(s[row1][col1]=="O"){
		 Score =1;
	 }
	 else if(s[row1][col1]=="X"){
		 Score =-1;
	 }//row1
 
	 if(s[row2][col2]=="O"){
		 if(Score==1){
			 Score =10;
		 }
		 else if(Score==-1){
			 return 0;
		 }else {Score=1;
		 }
 
	 }
	 else if(s[row2][col2]=="X"){
 
		 	if(Score == -1){
		 		Score =-10;
		 	}
 
		 	else if(Score ==1){
		 		return 0;
		 	}
	 }
	 else Score =1;//row 2
 
	 if(s[row3][col3]=="O"){
 
		 	if(Score>0){
		 		Score=Score*10;
		 	}
		 	else if(Score <0){
		 		return 0;
		 	}
		 	else {
		 		Score =1;
		 	}
	 }
 
	 else if(s[row3][col3]=="X"){
 
		 	if(Score < 0){
		 		Score =Score*10;
		 	}
		 	else if(Score >1){
		 		return 0;
		 	}
		 	else {
		 		Score =1;
		 	}
	 }
 
 
	 return Score;
 }

 private List<int[]> generateMoves() {
	 List<int[]> nextMoves = new ArrayList<int[]>();
	 if(eval_A() || eval_B()){
		 return nextMoves;
	 }
 
 
 
	 for(int row=0;row<3;row++){
		 for(int col=0;col<3;col++){
			 if(s[row][col]==" "){
				 nextMoves.add(new int[] {row,col}); 
			 }
		 }
	 }
 
	 return nextMoves;
 }
 
 boolean eval_A(){
 
	 if(s[0][0]==s[1][0]){
		 if(s[1][0]==s[2][0]){
			 if(s[1][0]=="X"){
 
				 return true;
			 }
		 }
	 }
	 
	 if(s[0][0]==s[0][1]){
		 if(s[0][0]==s[0][2]){
			 if(s[0][0]=="X"){
				 return true; 
			 }
		 }
	 }


	 if(s[1][0]==s[1][1]){
		 if(s[1][0]==s[1][2]){
			 if(s[1][0]=="X"){
 
				 return true; 
			 }
		 }
	 }
	 
	 if(s[2][0]==s[2][1]){
		 if(s[2][0]==s[2][2]){
			 if(s[2][0]=="X"){
 
				 return true;
			 }
		 }
	 }
	 
	 if(s[0][1]==s[1][1]){
		 if(s[1][1]==s[2][1]){
			 if(s[0][1]=="X"){
 
				 return true;
			 }
		 }
	 }
	 
	 if(s[0][2]==s[1][2]){
		 if(s[1][2]==s[2][2]){
			 if(s[0][2]=="X"){
 
				 return true; 
			 }
		 }
	 }
 
	 	if(s[0][0]==s[1][1]){
	 		if(s[1][1]==s[2][2]){
	 			if(s[1][1]=="X"){
 
	 				return true; 
	 			}
	 		}
	 	}
	 	
	 	if(s[0][2]==s[1][1]){
	 		if(s[1][1]==s[2][0]){
	 			if(s[1][1]=="X"){

	 				return true;
	 			}
	 		}
	 	}
	 	
	 	if(s[0][0]==s[1][0]){
	 		if(s[1][0]==s[2][0]){
	 			if(s[1][0]=="X"){
 
	 				return true;
	 			}
	 		}
	 	}
	 	
	 	return false;
 }

 boolean eval_B(){
 
	 if(s[0][0]==s[0][1]){
		 if(s[0][0]==s[0][2]){
			 if(s[0][2]=="O"){
				 return true;
			 }
		 }
	 }
 
	 if(s[1][0]==s[1][1]){
		 if(s[1][0]==s[1][2]){
			 if(s[1][0]=="O"){
				 return true;
			 }
		 }
	 }
	 
	 if(s[2][0]==s[2][1]){
		 if(s[2][0]==s[2][2]){
			 if(s[2][0]=="O"){
 
				 return true;
			 }
		 }
	 }
	 
	 if(s[0][1]==s[1][1]){
		 if(s[1][1]==s[2][1]){
			 if(s[0][1]=="O"){
				 return true;
			 }
		 }
	 }
	 
	 if(s[0][2]==s[1][2]){
		 if(s[1][2]==s[2][2]){
			 if(s[0][2]=="O"){
				 return true;
 
			 }
		 }
	 }
	 
	 if(s[0][0]==s[1][1]){
		 if(s[1][1]==s[2][2]){
			 if(s[1][1]=="O"){
 
				 return true;
			 }
 
		 }
	 }
	 
	 if(s[0][2]==s[1][1]){
		 if(s[1][1]==s[2][0]){
			 if(s[0][2]=="O"){
 
				 return true;
 
			 }
		 }
	 }
	 
	 if(s[0][0]==s[1][0]){
		 if(s[1][0]==s[2][0]){
			 if(s[1][0]=="X"){
 
				 return true;
			 }
		 }
	 }
	 
 return false;
 }
}

