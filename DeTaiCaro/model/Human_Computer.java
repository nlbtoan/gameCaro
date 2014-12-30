package model;

import model.ChessBoard;
import model.Point;

public class Human_Computer extends APlayerType {
	
	private boolean win = false;

	@Override
	public void excePlay(IModel model, Point point) {
		if(win) return;
		// nguoi danh
		Point p = findAPointPlayerTwo.findAPointToPlay(model.getChessBoard(), ChessBoard.COMPUTER,point);
		model.checkInBoard(p, ChessBoard.HUMAN);
		// kiem tra thang thua
		if (model.isWin(ChessBoard.HUMAN,point)) {
			win=true;
			model.showMessage("You are win.");
		} else {
			p = findAPointPlayerOne.findAPointToPlay(model.getChessBoard(), ChessBoard.COMPUTER,point);
			model.checkInBoard(p, ChessBoard.COMPUTER);
			if (model.isWin(ChessBoard.COMPUTER,p)) {
				win=true;
				model.showMessage("You are lose.");
			}

		}
	}

	

}
