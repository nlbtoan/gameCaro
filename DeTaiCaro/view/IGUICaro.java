package view;

import control.IControlGame;
import model.IModel;
import model.Point;

public interface IGUICaro {
	public void exitGame();
	public void setLevel(String level);
	//choi voi may hay choi voi nguoi
	public void setPlayerType(String playerType);
	//set luat choi
	public void setCheckWin(String rule);
	//de hien thi quan co len giao dien
	public void viewChoisePlay(Point point,int type);
	public void newGame();
	//hien thi thong bao
	public void showMessage(String message);
	public void setControl(IControlGame control);
	//xoa cac quan co tren giao dien
	public void clearChessBoard();
	public void setModel(IModel model);
	
}
