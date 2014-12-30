package model;

import model.Point;

public abstract class APlayerType {
	protected FindAPointStrategy findAPointPlayerOne;
	protected FindAPointStrategy findAPointPlayerTwo;
	public abstract void excePlay(IModel model,Point point);

	public void setFindAPointToPlay_PlayerOne(FindAPointStrategy findAPoint) {
		this.findAPointPlayerOne = findAPoint;
	}

	public void setFindAPointToPlay_PlayerTwo(FindAPointStrategy findAPoint) {
		this.findAPointPlayerTwo = findAPoint;
	}
}
