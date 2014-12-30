package model;

public class ChessBoard {
	private int[][] arrCell;
	public static int EMPTY = 0;
	public static int COMPUTER = -1;
	public static int HUMAN = -2;
	public static int OTHERHUMAN = -3;
	private static ChessBoard aChessBoard=null;
	private ChessBoard(int size){
		arrCell = new int[size][size];
	}
	public static synchronized ChessBoard createChessBoar(int size){
		if(aChessBoard==null)
			aChessBoard = new ChessBoard(size);
		return aChessBoard;
	}
	//kiem tra da danh het o trong ban co chu
	public boolean isFull(){
		for(int i=0;i<arrCell.length;i++)
			for(int j=0;j<arrCell.length;j++)
				if(arrCell[i][j]==0)
					return false;
		return true;
	}
	//xoa tat cac cac quan co, tao ban co moi
	public void clearBoard(){
		for(int i=0;i<arrCell.length;i++)
			for(int j=0;j<arrCell.length;j++)
				arrCell[i][j]=0;
	}
	public int[][] getArrCell() {
		return arrCell;
	}
	//de danh mot quan co vao ban co
	public void checkInBoard(Point point,int type){
		arrCell[point.getX()][point.getY()] = type;
	}
	public ChessBoard getChessBoard(){
		return aChessBoard;
	}
	//dem so quan co da duoc danh
	//de xac dinh xem toi luot ai danh
//	public int countCellChecked(){
//		int count=0;
//		for(int i=0;i<arrCell.length;i++)
//			for(int j=0;j<arrCell.length;j++)
//				if(arrCell[i][j]<0)
//					count++;
//		return count;
//	}
	public int getSize(){
		return arrCell.length;
	}
	public void setArrCell(int[][] arrCell) {
		this.arrCell = arrCell;
	}
	

}
