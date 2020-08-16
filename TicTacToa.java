package ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jeff
 * @date 2020-08-14
 * @description main class of TicTacToa game
 */

public class TicTacToa {

	public static void main(String[] args) {
		//create a new match
		ChessBoard cb = new ChessBoard();
		BufferedReader br=null;
		try {
			//Scanner sc = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			String input="";
			int count = 0;
			while(!("exit".equalsIgnoreCase(input))) {
				input = br.readLine();
				System.out.println("input = " + input);
				if(!"".equalsIgnoreCase(input)&&!"stop".equalsIgnoreCase(input))cb.stepCreate(input);
				int result = 0;
				if(cb.stepCnt >= 5 && !"".equalsIgnoreCase(input)) result = cb.resCheck();
				switch(result){
					case 1:
						System.out.println("=====Player A win");
						input = "exit";
					    break;
					case 2:
						System.out.println("=====Player B win");
						input = "exit";
					    break;
					case 3:
						System.out.println("=====Draw match!");	
						input = "exit";
					    break;    
					default:
					    System.out.println("=====Continue! It is turn player " + cb.curStep.getCompetiter());
					    break;
				}
				count++;
			}
		} catch (IOException e) {
			System.out.println("IOException happen");
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
}
