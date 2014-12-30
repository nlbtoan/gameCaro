package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FindAPointWithHeuristicCaroRuleNormal implements FindAPointStrategy{
	float[][] array;
	int[][] cell;
	@Override
	public Point findAPointToPlay(ChessBoard chessBoard, int type,Point point) {
		cell=chessBoard.getArrCell();
		array = new float[chessBoard.getSize()][chessBoard.getSize()];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j]=cell[i][j];
			}
		}
		
		
		scoreBoard(array, chessBoard.COMPUTER, chessBoard.HUMAN);
		//tim vi tri ma co diem lon nhat de danh vao
		List<Point> listMax = new ArrayList<Point>();
		float max=0,score=0;
		for(int i=0;i<chessBoard.getSize();i++)
			for(int j=0;j<chessBoard.getSize();j++){
				score=array[i][j];
				if(score>max)
					max=score;
			}
		//chon mot diem ngau nhien de danh neu co nhieu diem cung so diem
		for(int i=0;i<chessBoard.getSize();i++)
			for(int j=0;j<chessBoard.getSize();j++){
				score=array[i][j];
				if(score==max)
					listMax.add(new Point(i,j));
			}
		Random random = new Random();
		return listMax.get(random.nextInt(listMax.size()));
	}

	//tinh diem ung voi tung diem co the danh vao
	private void scoreBoard(float[][] board,int type,int type2){
		int valueType1=0;
		int valueType2=0;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j]==0){
					valueType1 = scoreAtPoint(board, type, new Point(i,j));
					valueType2 = scoreAtPoint(board, type2, new Point(i,j));
					if(valueType1>valueType2) board[i][j]=valueType1+0.5f;
					else if(valueType1<valueType2) board[i][j]=valueType2;
					else if(valueType1==valueType2) board[i][j]=valueType2+1;
					if(valueType1>=15&&valueType2>=15) board[i][j]=board[i][j]+0.1f;
				}
			}
		}
	}
	//xoa heuristic
//	private void clearScore(float[][] board){
//		for(int i=0;i<board.length;i++){
//			for(int j=0;j<board.length;j++){
////				System.out.print(board[i][j]+"\t");
//				if(board[i][j]>0)
//					board[i][j]=0;
//			}
////			System.out.println();
////			System.out.println();
//		}
//	}
//	tinh diem tai point ma type khi danh tai vi tri point nay
	private int scoreAtPoint(float[][] chessBoard, int type, Point point){
		int breadthMark = breadthMark(chessBoard, type, point);
		int vertical = vertical(chessBoard, type, point);
		int diagonaMain = diagonalMain(chessBoard, type, point);
		int diagonaAuxi = diagonalAuxiliary(chessBoard, type, point);
		int maxScore = Math.max(Math.max(breadthMark,vertical),Math.max(diagonaMain,diagonaAuxi));
		int count15=0;
		if(breadthMark>=11) count15++;
		if(vertical>=11) count15++;
		if(diagonaMain>=11) count15++;
		if(diagonaAuxi>=11) count15++;
		if(count15>=2) maxScore+=count15;
		return maxScore;
	}
	//======================================================================
//	tim theo chieu ngang ----
	private int breadthMark(float[][] chessBoard, int type, Point point){
		int countLeft=0,countRight=0;
		int row = point.getX();
		int column = point.getY();
		boolean flag=false,empty=false;
		int count=0,countChess=0;
		int biChan=0;
		//tinh diem ve ben trai 4 o
		for(int i=column-1;i>-1&&count!=5;i--,count++){
			//co ngan xet xem quan thu 5 co phai la dich hay khong
			if(count==5){
				if(chessBoard[row][i]<0 && chessBoard[row][i]!=ChessBoard.EMPTY&& chessBoard[row][i]!=type){
					biChan++;
				}
				break;
			}
			if(chessBoard[row][i]==type){
				countLeft+=5;
				if(!flag) countChess++;
				else empty=true;
			}else if (chessBoard[row][i]>=ChessBoard.EMPTY){
				if(!flag) flag=true;
				else break;
			}else if(chessBoard[row][i]<0){
				if(flag) countLeft-=5;
				else {
					countLeft-=5;
					biChan++;
				}
				break;
			}
		}
		if(empty) countLeft-=1;
		
		
		count=0;
		flag=false;
		empty=false;
		//tinh diem ve ben phai 4 o
		for(int i=column+1;i<chessBoard.length&&count!=5;i++,count++){
			if(count==5){
				if(chessBoard[row][i]<0 && chessBoard[row][i]!=ChessBoard.EMPTY&& chessBoard[row][i]!=type){
					biChan++;
				}
				break;
			}
			if(chessBoard[row][i]==type){
				countRight+=5;
				if(!flag) countChess++;
				else empty=true;
			}else if (chessBoard[row][i]>=ChessBoard.EMPTY){
				if(!flag) flag=true;
				else break;
			}else if(chessBoard[row][i]<0){
				if(flag) countRight-=5;
				else {
					countRight-=5;
					biChan++;
				}
				break;
			}
		}
		if(empty) countRight-=1;
		return checkScore(countLeft, countRight,countChess,biChan);
		
	}
//======================================================================
//	tim theo chieu doc |
	private int vertical(float[][] chessBoard, int type, Point point){
		int countUp=0,countDown=0;
		int row = point.getX();
		int column = point.getY();
		boolean flag=false,empty=false;
		int count=0,countChess=0,biChan=0;
		//tinh theo huong len up
		for(int i=row-1;i>-1&&count!=5;i--,count++){
			//co ngan xet xem quan thu 5 co phai la dich hay khong
			if(count==5){
				if(chessBoard[i][column]<0 && chessBoard[i][column]!=ChessBoard.EMPTY&& chessBoard[i][column]!=type){
					biChan++;
				}
				break;
			}
			if(chessBoard[i][column]==type){
				countUp+=5;
				if(!flag) countChess++;
				else empty=true;
			}else if (chessBoard[i][column]>=ChessBoard.EMPTY){
				if(!flag) flag=true;
				else break;
			}else if(chessBoard[i][column]<0){
				if(flag) countUp-=5;
				else {
					countUp-=5;
					biChan++;
				}
				break;
			}
		}
		if(empty) countUp-=1;
		
		count=0;
		flag=false;
		empty=false;
		//tinh theo huong xuong down
		for(int i=row+1;i<chessBoard.length&&count!=5;i++,count++){
			if(count==5){
				if(chessBoard[i][column]<0 && chessBoard[i][column]!=ChessBoard.EMPTY&& chessBoard[i][column]!=type){
					biChan++;
				}
				break;
			}
			if(chessBoard[i][column]==type){
				countDown+=5;
				if(!flag) countChess++;
				else empty=true;
			}else if (chessBoard[i][column]>=ChessBoard.EMPTY){
				if(!flag) flag=true;
				else break;
			}else if(chessBoard[i][column]<0){
				if(flag) countDown-=5;
				else {
					biChan++;
					countDown-=5;
				}
				break;
			}
		}
		if(empty) countDown-=1;
		
		return checkScore(countUp, countDown,countChess,biChan);
	}
//======================================================================
//	tinh theo duong cheo chinh "\"
	private int diagonalMain(float[][] chessBoard, int type, Point point){
		int countLeftUp=0,countRightDown=0;
		int row = point.getX();
		int column = point.getY();
		int j=column;
		boolean flag=false,empty=false;
		int count=0,countChess=0,biChan=0;
		//tinh theo duong cheo huong len tren
		for(int i=row-1;i>-1&&count!=5;i--,count++){
			j--;
			if(j>-1){
				//co ngan xet xem quan thu 5 co phai la dich hay khong
				if(count==5){
					if(chessBoard[i][j]<0 && chessBoard[i][j]!=ChessBoard.EMPTY&& chessBoard[i][j]!=type){
						biChan++;
					}
					break;
				}
				if(chessBoard[i][j]==type){
					countLeftUp+=5;
					if(!flag) countChess++;
					else empty=true;
				}else if (chessBoard[i][j]>=ChessBoard.EMPTY){
					if(!flag) flag=true;
					else break;
				}else if(chessBoard[i][j]<0){
					if(flag) countLeftUp-=5;
					else {
						biChan++;
						countLeftUp-=5;
					}
					break;
				}
			}else
				break;
		}
		if(empty) countLeftUp-=1;
		
		j=column;
		count=0;
		flag=false;
		empty=false;
		//tinh theo duong cheo huong xuong duoi
		for(int i=row+1;i<chessBoard.length&&count!=5;i++,count++){
			j++;
			if(j<chessBoard.length){
				if(count==5){
					if(chessBoard[i][j]<0 && chessBoard[i][j]!=ChessBoard.EMPTY&& chessBoard[i][j]!=type){
						biChan++;
					}
					break;
				}
				if(chessBoard[i][j]==type){
					countRightDown+=5;
					if(!flag) countChess++;
					else empty=true;
				}else if (chessBoard[i][j]>=ChessBoard.EMPTY){
					if(!flag) flag=true;
					else break;
				}else if(chessBoard[i][j]<0){
					if(flag) countRightDown-=5;
					else {
						biChan++;
						countRightDown-=5;
					}
					break;
				}
			}else
				break;
		}
		if(empty) countRightDown-=1;
		return checkScore(countLeftUp, countRightDown,countChess,biChan);
	}
	
	//======================================================================
//	tinh theo duong cheo phu "/"
	private int diagonalAuxiliary(float[][] chessBoard, int type, Point point){
		int countRightUp=0,countLeftDown=0;
		int row = point.getX();
		int column = point.getY();
		int j=column;
		boolean flag=false,empty=false;
		int count=0,countChess=0,biChan=0;
		//tinh theo duong cheo huong len tren
		for(int i=row-1;i>-1&&count!=5;i--,count++){
			j++;
			if(j<chessBoard.length){
				//co ngan xet xem quan thu 5 co phai la dich hay khong
				if(count==5){
					if(chessBoard[i][j]<0 && chessBoard[i][j]!=ChessBoard.EMPTY&& chessBoard[i][j]!=type){
						biChan++;
					}
					break;
				}
				if(chessBoard[i][j]==type){
					countRightUp+=5;
					if(!flag) countChess++;
					else empty=true;
				}else if (chessBoard[i][j]>=ChessBoard.EMPTY){
					if(!flag) flag=true;
					else break;
				}else if(chessBoard[i][j]<0){
					if(flag) countRightUp-=5;
					else {
						biChan++;
						countRightUp-=5;
					}
					break;
				}
			}else
				break;
		}
		if(empty) countRightUp-=1;
		
		j=column;
		count=0;
		flag=false;
		empty=false;
		//tinh theo duong cheo huong xuong duoi
		for(int i=row+1;i<chessBoard.length&&count!=5;i++,count++){
			j--;
			if(j>-1){
				//co ngan xet xem quan thu 5 co phai la dich hay khong
				if(count==5){
					if(chessBoard[i][j]<0 && chessBoard[i][j]!=ChessBoard.EMPTY&& chessBoard[i][j]!=type){
						biChan++;
					}
					break;
				}
				if(chessBoard[i][j]==type){
					countLeftDown+=5;
					if(!flag) countChess++;
					else empty=true;
				}else if (chessBoard[i][j]>=ChessBoard.EMPTY){
					if(!flag) flag=true;
					else break;
				}else if(chessBoard[i][j]<0){
					if(flag) countLeftDown-=5;
					else {
						biChan++;
						countLeftDown-=5;
					}
					break;
				}
			}else
				break;
		}
		if(empty) countLeftDown-=1;
		return checkScore(countRightUp, countLeftDown,countChess,biChan);
	}
	
	private int checkScore(int count1,int count2,int countChess,int biChan){
		if(countChess>=5) return 1;
		else if(countChess==4&&biChan>1) return 1;
		else if(countChess==4) return 40;
		else return count1+count2+5;
	}
	public static void main(String[] args) {
		//			  0  1  2  3  4  5  6  7  8  9	
		float[][] m ={{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{ 0, 0, 0, 0,-1,-2, 0, 0, 0, 0, 0},//0
					{ 0, 0, 0, 0,-1,-2, 0, 0, 0, 0, 0},//1
					{ 0,-2,-1,-1,-1,-1,-2, 0, 0, 0, 0},//2
					{ 0, 0,-1,-1,-2,-2,-1,-2, 0, 0, 0},//3
					{ 0, 0,-1,-2,-1,-2,-1,-2,-2,-2, 0},//4
					{ 0, 0,-2, 0, 0,-2,-1, 0,-2,-1, 0},//5
					{ 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0},//6
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//7
					{ 0, 0, 0, 0, 0,-1, 0, 0, 0, 0, 0},//8
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};//9
			
		FindAPointWithHeuristicCaroRuleNormal f = new FindAPointWithHeuristicCaroRuleNormal();
//		for(int i=0;i<m.length;i++){
//			for(int j=0;j<m.length;j++){
//				if(m[i][j]==0)
////					System.out.print(f.diagonalMain(m, -1, new Points(i,j))+"\t");
////					System.out.print(f.breadthMark(m, -1, new Points(i,j))+"\t");
////					System.out.print(f.diagonalAuxiliary(m, -1, new Points(i,j))+"\t");
////					System.out.print(f.vertical(m, -1, new Points(i,j))+"\t");
//					System.out.print(f.scoreAtPoint(m, -1, new Points(i,j))+"\t");
//				else
//					System.out.print(m[i][j]+"\t");
//			}
//			System.out.println();
//			System.out.println();
//			System.out.println();
//		}
		f.scoreBoard(m, -1, -2);
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++)
				System.out.print(m[i][j]+"\t");
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
	}
}
