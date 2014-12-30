package factory;

import model.Leve_Player;


public class AdapterFactory {
	public static AbstactFactory createproduct(int size,String rule){
		if(rule.equalsIgnoreCase(Leve_Player.CARORULE.name())){
			return new FactoryWithCaroRule(size);
		}else if(rule.equalsIgnoreCase(Leve_Player.GOMOKURULE.name())){
			return new FactoryWithGomokuRule(size);
		}else return null;
	}

}
