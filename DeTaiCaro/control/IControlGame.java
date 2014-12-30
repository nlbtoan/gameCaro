package control;

import view.IGUICaro;
import model.FindAPointStrategy;
import model.IModel;
import model.APlayerType;
import model.Point;


public interface IControlGame {
	public void newGame();
	//choi voi may hay voi nguoi
	public void setPlayerType(String playerType);
	public void setPlayerType(APlayerType playerType);
	public void setModel(IModel model);
	public void setView(IGUICaro gui);
	public void setLeve(String leve);
	public void setCheckWin(String rule);
	void setFindAPointPlayerOne(FindAPointStrategy findAPoint);
	public void setFindAPointTwo(FindAPointStrategy findAPoint);
	
}
