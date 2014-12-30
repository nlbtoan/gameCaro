package model;


public interface FindAPointStrategy {
	public Point findAPointToPlay(ChessBoard chessBoard, int type,Point point);
}
