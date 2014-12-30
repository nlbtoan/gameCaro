package control;

import factory.AbstactFactory;
import factory.FactoryWithCaroRule;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstactFactory factory = new FactoryWithCaroRule(25);
		IControlGame control = factory.createControler();
		
	}

}
