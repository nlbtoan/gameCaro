package control;

import factory.AdapterFactory;
import factory.AbstactFactory;
import model.ChessBoard;
import model.FindAPointStrategy;
import model.IModel;
import model.Leve_Player;
import model.APlayerType;
import model.Point;

import view.IGUICaro;

public class Controler implements IControlGame{
	private int size=0;
	private AbstactFactory factory;
	private IModel model;
	private IGUICaro view;
	public Controler(AbstactFactory factory,int size){
		this.size=size;
		this.factory=factory;
		view = factory.createView();
		view.setControl(this);
		model = factory.createModel();
		model.setCheckWin(this.factory.createCheckWin());
		model.setGUI(view);
		model.setFindAPoint_PlayerOne(this.factory.createFindAPointPlayerOne(Leve_Player.EASY.name()));
		model.setFindAPoint_PlayerTwo(this.factory.createFindAPointPlayerTwo("EASY"));
		view.setModel(model);
		
	}

	@Override
	public void newGame() {
		model.clearBoard();
		view.clearChessBoard();
		
	}


	@Override
	public void setLeve(String leve) {
		this.model.setFindAPoint_PlayerOne(factory.createFindAPointPlayerOne(leve));
		this.model.setFindAPoint_PlayerTwo(factory.createFindAPointPlayerTwo("EASY"));
		
	}

	@Override
	public void setModel(IModel model) {
		this.model = model;
		
	}

	@Override
	public void setPlayerType(String playerType) {
		if(playerType.equalsIgnoreCase(Leve_Player.COMPUTER_HUMAN.name())){
			model.checkInBoard(new Point(model.sizeBoard()/2,model.sizeBoard()/2), ChessBoard.COMPUTER);
			model.setPlayerType(factory.createPlayerType(Leve_Player.HUMAN_COMPUTER.name()));
			
		}
		else
			model.setPlayerType(factory.createPlayerType(playerType));
	}

	@Override
	public void setView(IGUICaro gui) {
		this.view = gui;
		this.view.setModel(model);
		
	}

	@Override
	public void setCheckWin(String rule) {
		this.factory = AdapterFactory.createproduct(size, rule);
		model.setCheckWin(factory.createCheckWin());
		model.setFindAPoint_PlayerOne(factory.createFindAPointPlayerOne(Leve_Player.EASY.name()));
		
	}

	@Override
	public void setFindAPointPlayerOne(FindAPointStrategy findAPoint) {
		this.model.setFindAPoint_PlayerOne(findAPoint);
	}

	@Override
	public void setFindAPointTwo(FindAPointStrategy findAPoint) {
		this.model.setFindAPoint_PlayerTwo(findAPoint);
	}

	@Override
	public void setPlayerType(APlayerType playerType) {
		model.setPlayerType(playerType);
	}

	
	
}
