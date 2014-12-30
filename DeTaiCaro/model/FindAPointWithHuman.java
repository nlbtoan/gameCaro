package model;

public class FindAPointWithHuman implements FindAPointStrategy{

	@Override
	public Point findAPointToPlay(ChessBoard chessBoard, int type, Point point) {
		return point;
	}

}
