package model;

import model.ChessBoard;
import model.Point;

public class Human_Human extends APlayerType{
	private boolean nextHuman=true;
	private boolean win=false;
	@Override
	public void excePlay(IModel model, Point point) {
		if(win) return;
		if(nextHuman){
			Point p = findAPointPlayerOne.findAPointToPlay(model.getChessBoard(), ChessBoard.HUMAN,point);
			model.checkInBoard(p, ChessBoard.HUMAN);
			nextHuman=false;
			// kiem tra thang thua
			if (model.isWin(ChessBoard.HUMAN,point)) {
				win = true;
				model.showMessage("Ban danh quan do thang");
			}
		}else{
			Point p = findAPointPlayerOne.findAPointToPlay(model.getChessBoard(), ChessBoard.OTHERHUMAN,point);
			model.checkInBoard(p, ChessBoard.OTHERHUMAN);
			nextHuman=true;
			// kiem tra thang thua
			if (model.isWin(ChessBoard.OTHERHUMAN,point)) {
				win = true;
				model.showMessage("Ban danh quan xanh thang");
			}
		}
		
	}
	

}
