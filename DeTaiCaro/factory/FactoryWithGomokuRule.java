package factory;

import javax.swing.ImageIcon;

import view.ShowMessage;
import model.CheckWinGomokuRule;
import model.CheckWinStrategy;
import model.FindAPointStrategy;
import model.FindAPointWithHeuristicGomokuEasy;
import model.Leve_Player;

public class FactoryWithGomokuRule extends AbstactFactory{
	public FactoryWithGomokuRule(int size){
		super(size);
	}

	@Override
	public CheckWinStrategy createCheckWin() {
		return new CheckWinGomokuRule();
	}

	@Override
	public FindAPointStrategy createFindAPointPlayerOne(String leve) {
		if(leve.equalsIgnoreCase(Leve_Player.EASY.name()))
			return new FindAPointWithHeuristicGomokuEasy();
			
		else if(leve.equalsIgnoreCase(Leve_Player.NORMAL.name())){
			new ShowMessage("You select level normal, but I don't implement it!",new ImageIcon("imageCaro/khi1.gif"));
			return null;
		}
		else if(leve.equalsIgnoreCase(Leve_Player.HARD.name())){
			new ShowMessage("You select level hard, but I don't implement it!",new ImageIcon("imageCaro/khi1.gif"));
			return null;
		}
		else return null;
	}

}
