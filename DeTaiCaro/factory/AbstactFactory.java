package factory;

import control.Controler;
import control.IControlGame;
import view.IGUICaro;
import view.ScreenDisplay;
import model.CheckWinStrategy;
import model.FindAPointStrategy;
import model.FindAPointWithHuman;
import model.Human_Computer;
import model.Human_Human;
import model.IModel;
import model.Leve_Player;
import model.Model;
import model.APlayerType;


public abstract class AbstactFactory {
	private int size=0;
	public AbstactFactory(int size){
		this.size=size;
	}
	//quyet dinh ai danh truoc va danh voi ai
	public APlayerType createPlayerType(String playerType){
		if(playerType.equalsIgnoreCase(Leve_Player.HUMAN_COMPUTER.name()))
			return new Human_Computer();
		else if(playerType.equalsIgnoreCase(Leve_Player.HUMAN_HUMAN.name()))
			return new Human_Human();
		else 
			return null;
	};
	public FindAPointStrategy createFindAPointPlayerTwo(String leve){
		return new FindAPointWithHuman();
	}
	
	//chon leve 
	public abstract FindAPointStrategy createFindAPointPlayerOne(String leve);
	//chon luat choi
	public abstract CheckWinStrategy createCheckWin();
	public IModel createModel(){
		return new Model(size);
	}
	public IGUICaro createView(){
		return new ScreenDisplay(size,"Game Caro");
	}
	public IControlGame createControler(){
		return new Controler(this,size);
	}

}
