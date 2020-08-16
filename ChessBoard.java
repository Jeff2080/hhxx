package ttt;

/**
 * @author Jeff
 * @date 2020-08-14
 * @description the chess board class for TicTacToa game
 */

public class ChessBoard {
	public int size = 3;
	public Step[][] matrix = new Step[size][size];
	public int stepCnt = 0;
	public Step curStep = new Step();
	public ChessBoard() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				matrix[i][j] = new Step();//initialize the chess board
			}
		}
	}
	/*
	 * create the step and store on the chess board
	 */
	public Step stepCreate(String s) {
		String[] param = s.split(",");
		int row = Integer.parseInt(param[0]);
		int colomn = Integer.parseInt(param[1]);
		this.curStep = new Step(row,colomn,param[2]);
		this.matrix[row][colomn] = this.curStep;
		stepCnt++;
		System.out.println("step count = " + stepCnt);
		return this.curStep;
	}
	
	/*
	 * check result after the step 5
	 */
	public int resCheck() {
		//1 indicate that player A win
		//2 indicate that player B win
		//3 indicate that this round is draw
		int resVal = 0;
		StringBuffer rowSB = null;
		StringBuffer columnSB = null;
		//row and column checking
		for(int i=0; i<size; i++) {
			rowSB = new StringBuffer();
			columnSB = new StringBuffer();
			for(int j=0; j<size; j++) {
				rowSB = rowSB.append(matrix[i][j].getPlayer());
				columnSB = columnSB.append(matrix[j][i].getPlayer());
			}
			//System.out.println("rowSB.toString() = " + rowSB.toString());
			//System.out.println("columnSB.toString() = " + columnSB.toString());
			if("AAA".equals(rowSB.toString()) || "AAA".equals(columnSB.toString())) {
				resVal = 1;
			}else if("BBB".equals(rowSB.toString()) || "BBB".equals(columnSB.toString())) {
				resVal = 2;
			}else if(stepCnt == 9){
				resVal = 3;//draw match
			}
		}
		//hypotenuse checking
		if("A".equals(matrix[0][0].getPlayer()) && matrix[0][0].getPlayer().equals(matrix[1][1].getPlayer()) && matrix[1][1].getPlayer().equals(matrix[2][2].getPlayer())) {
			resVal = 1;
		}else if("B".equals(matrix[0][0].getPlayer()) && matrix[0][0].getPlayer().equals(matrix[1][1].getPlayer()) && matrix[1][1].getPlayer().equals(matrix[2][2].getPlayer())) {
			resVal = 2;
		}
		else if("A".equals(matrix[0][2].getPlayer()) && matrix[0][2].getPlayer().equals(matrix[1][1].getPlayer()) && matrix[1][1].getPlayer().equals(matrix[2][0].getPlayer())) {
			resVal = 1;
		}
		else if("B".equals(matrix[0][2].getPlayer()) && matrix[0][2].getPlayer().equals(matrix[1][1].getPlayer()) && matrix[1][1].getPlayer().equals(matrix[2][0].getPlayer())) {
			resVal = 2;
		}else if(stepCnt == 9){
			resVal = 3;//draw match
		}
		System.out.println("resVal = " + resVal);
		return resVal;
	}
	

}
