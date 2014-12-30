package model;

import view.IGUICaro;

public class Model implements IModel{
	private CheckWinStrategy checkWin;
	private ChessBoard chessBoard;
	private APlayerType playerType;
	private IGUICaro view;
	public Model(int size){
		chessBoard = ChessBoard.createChessBoar(size);
		playerType = new Human_Computer();
	}
	@Override
	public void checkInBoard(Point point, int type) {
		chessBoard.checkInBoard(point, type);
		view.viewChoisePlay(point, type);
	}

	
	@Override
	public boolean isFullChessBoard() {
		return chessBoard.isFull();
	}

	@Override
	public boolean isWin(int type,Point point) {
		if(isFullChessBoard()) view.showMessage("Chung ta hoa nha");
		return checkWin.isWin(chessBoard, type,point);
	}

	@Override
	public void setCheckWin(CheckWinStrategy checkWin) {
		this.checkWin = checkWin;
	}

	
	@Override
	public int sizeBoard() {
		return chessBoard.getSize();
	}


	@Override
	public void clearBoard() {
		chessBoard.clearBoard();
		
	}
	@Override
	public void play(Point point) {
		this.playerType.excePlay(this, point);
		
	}
	@Override
	public ChessBoard getChessBoard() {
		return this.chessBoard;
	}
	@Override
	public void showMessage(String message) {
		view.showMessage(message);
		
	}
	@Override
	public void setFindAPoint_PlayerOne(FindAPointStrategy findAPoint) {
		playerType.setFindAPointToPlay_PlayerOne(findAPoint);
	}
	@Override
	public void setFindAPoint_PlayerTwo(FindAPointStrategy findAPoint) {
		playerType.setFindAPointToPlay_PlayerTwo(findAPoint);
	}
	@Override
	public void setGUI(IGUICaro view) {
		this.view = view;
	}
	@Override
	public void setPlayerType(APlayerType playerType) {
		this.playerType = playerType;
		
	}

}
