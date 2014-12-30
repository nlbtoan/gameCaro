package model;


public class CheckWinGomokuRule implements CheckWinStrategy{
	//chan hai dau van thang
	@Override
	public boolean isWin(ChessBoard chessBoard, int type,Point point) {
		return checkWin(chessBoard, type, point.getX(), point.getY());
	}
	
	
	private boolean checkWin(ChessBoard chessBoard, int type,int x,int y) {
		return breadthMark(chessBoard.getArrCell(), type, x,y)
			|| vertical(chessBoard.getArrCell(), type, x,y)
			|| diagonalMain(chessBoard.getArrCell(), type, x,y)
			|| diagonalAuxiliary(chessBoard.getArrCell(), type,x,y);
	}
//======================================================================
//	tim theo chieu ngang ----
	private boolean breadthMark(int[][] chessBoard, int type, int x,int y){
		int countLeft=0,countRight=0;
		int row = x;
		int column = y;
		//tinh ben trai diem point
		for(int i=column-1;i>-1;i--){
			if(chessBoard[row][i]==type){
				countLeft++;
			}else
				break;
		}
		//tinh ben phai diem point
		for(int i=column+1;i<chessBoard.length;i++){
			if(chessBoard[row][i]==type){
				countRight++;
			}else
				break;
		}
		return checkScore(countLeft, countRight);
		
	}
//======================================================================
//	tim theo chieu doc
	private boolean vertical(int[][] chessBoard, int type,int x,int y){
		int countUp=0,countDown=0;
		int row = x;
		int column = y;
		//tinh theo huong len up
		for(int i=row-1;i>-1;i--){
			if(chessBoard[i][column]==type)
				countUp++;
			else
				break;
		}
		//tinh theo huong xuong down
		for(int i=row+1;i<chessBoard.length;i++){
			if(chessBoard[i][column]==type)
				countDown++;
			else 
				break;
		}
		return checkScore(countUp, countDown);
	}
//======================================================================
//	tinh theo duong cheo chinh "\"
	private boolean diagonalMain(int[][] chessBoard, int type, int x,int y){
		int countLeftUp=0,countRightDown=0;
		int row = x;
		int column = y;
		int j=column;
		//tinh theo duong cheo huong len tren
		for(int i=row-1;i>-1;i--){
			j--;
			if(j>-1){
				if(chessBoard[i][j]==type)
					countLeftUp++;
				else
					break;
			}else
				break;
		}
		j=column;
		//tinh theo duong cheo huong xuong duoi
		for(int i=row+1;i<chessBoard.length;i++){
			j++;
			if(j<chessBoard.length){
				if(chessBoard[i][j]==type)
					countRightDown++;
				else
					break;
			}else
				break;
		}
		return checkScore(countLeftUp, countRightDown);
	}
	
	//======================================================================
//	tinh theo duong cheo phu "/"
	private boolean diagonalAuxiliary(int[][] chessBoard, int type,int x,int y){
		int countRightUp=0,countLeftDown=0;
		int row = x;
		int column = y;
		int j=column;
		//tinh theo duong cheo huong len tren
		for(int i=row-1;i>-1;i--){
			j++;
			if(j<chessBoard.length){
				if(chessBoard[i][j]==type)
					countRightUp++;
				else 
					break;
			}else
				break;
		}
		j=column;
		//tinh theo duong cheo huong xuong duoi
		for(int i=row+1;i<chessBoard.length;i++){
			j--;
			if(j>-1){
				if(chessBoard[i][j]==type)
					countLeftDown++;
				else
					break;
			}else
				break;
		}
		return checkScore(countRightUp, countLeftDown);
	}
	
	private boolean checkScore(int count1,int count2){
		if((count1==4&&count2==0)||(count1==0&&count2==4))
			return true;
		else if((count1+count2)==4)
			return true;
		else return false;
	}
//	public static void main(String[] args) {
//		//			  0  1  2  3  4  5  6  7  8  9	
//		int[][] m ={{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//0
//					{ 0, 0,-1, 0, 0, 0, 0, 0, 0, 0, 0},//1
//					{ 0, 0, 0,-1, 0, 0, 0, 0, 0, 0, 0},//2
//					{ 0, 0, 0, 0,-1, 0, 0, 0, 0, 0, 0},//3
//					{ 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0},//4
//					{ 0, 0, 0, 0, 0, 0,-1, 0, 0, 0, 0},//5
//					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//6
//					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//7
//					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//8
//					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};//9
//					
//		
//		CheckWinGomokuRule c = new CheckWinGomokuRule();
//	}
	

	

}
