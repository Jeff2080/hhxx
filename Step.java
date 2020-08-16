package ttt;

/**
 * @author Jeff
 * @date 2020-08-14
 * @description the Step class will store the every step details for TicTacToa game
 */

public class Step {
	private int row=0;
	private int column=0;
	private String player="";
	
	public Step() {}
	
	public Step(int r,int c, String p) {
		this.row=r;
		this.column=c;
		this.player=p;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	public String getCompetiter() {
		return "A".equalsIgnoreCase(this.player)?"B":"A";
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb = sb.append(this.row).append(this.column).append(this.player);
		return sb.toString();
	}

}
