package model;

import view.IGUICaro;

public interface IModel {
	public void setCheckWin(CheckWinStrategy checkWin);
	public void setFindAPoint_PlayerOne(FindAPointStrategy findAPoint);
	public void setFindAPoint_PlayerTwo(FindAPointStrategy findAPoint);
	//danh co vao ban co
	public void checkInBoard(Point point,int type);
	public boolean isWin(int type,Point point);
	public boolean isFullChessBoard();
	public int sizeBoard();
	public void clearBoard();
	public void play(Point point);
	public ChessBoard getChessBoard();
	public void showMessage(String message);
	public void setGUI(IGUICaro view);
	public void setPlayerType(APlayerType playerType);
	

}
