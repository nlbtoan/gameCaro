package factory;

import javax.swing.ImageIcon;

import view.ShowMessage;
import model.CheckWinCaroRule;
import model.CheckWinStrategy;
import model.FindAPointStrategy;
import model.FindAPointWithHeuristicCaroRuleNormal;
import model.FindAPointWithHeuristicCaroRuleEasy;
import model.Leve_Player;


public class FactoryWithCaroRule extends AbstactFactory{
	
	public FactoryWithCaroRule(int size){
		super(size);
	}

	@Override
	public CheckWinStrategy createCheckWin() {
			return new CheckWinCaroRule();
	}

	

	@Override
	public FindAPointStrategy createFindAPointPlayerOne(String leve) {
		if(leve.equalsIgnoreCase(Leve_Player.EASY.name()))
			return new FindAPointWithHeuristicCaroRuleEasy();
			
		else if(leve.equalsIgnoreCase(Leve_Player.NORMAL.name()))
			return new FindAPointWithHeuristicCaroRuleNormal();
		else if(leve.equalsIgnoreCase(Leve_Player.HARD.name())){
			new ShowMessage("You select level hard, but I don't implement it!",new ImageIcon("imageCaro/khi1.gif"));
			return null;
		}
		else return null;
	}

	

	

}
