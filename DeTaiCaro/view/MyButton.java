package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Point;

public class MyButton extends JButton{
	private Point point;
	static final ImageIcon image = new ImageIcon();
	public MyButton(Point point){
		super();
		this.point = point;
		setBackground(Color.WHITE);
		setIcon(image);
	}
	public Point getPoint(){
		return point;
	}

}
