package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ShowMessage{
	public ShowMessage(String s,ImageIcon icon){
		JOptionPane optionPanel = new JOptionPane();
		optionPanel.showMessageDialog(null,"<html> <span style='font-size:13.0pt;color:blue'>" +s+"</html>","Winer-^-^-" ,0, icon);
	}
//	public static void main(String[] args) {
//		new Erro_Result("hien thong bao");
//	}

}
