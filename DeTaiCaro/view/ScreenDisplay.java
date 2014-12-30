package view;




import control.IControlGame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import factory.AbstactFactory;
import factory.FactoryWithCaroRule;

import model.ChessBoard;
import model.FindAPointWithHuman;
import model.IModel;
import model.Leve_Player;
import model.Point;
public class ScreenDisplay extends JFrame implements IGUICaro{
	private JPanel panelContain;
	private JPanel panelResult;
	private JPanel panelWayToPlay;
	private JTextField textLevel;
	public TextArea textAreaType;
	private JPanel panelType;
	private JLabel labelResult;
	private JTextField textResutl;
	private JPanel jPanel1;
	private JTextField textUsage;
	private JLabel labelUsage;
	private JLabel labelLevel;
	private String textAreaTypes="";
	private MyButton[][] arrMybutton;
	private Point point;
	private IControlGame control;
	private int size=0;
	private JLabel[] chiSoDong,chiSoCot;
	private MenuBar menuBar;
	private String playerType=Leve_Player.HUMAN_COMPUTER.name();
	private String rule=Leve_Player.CARORULE.name();
	private PlayAudio playAudio = new PlayAudio();
	private IModel model;
	private String leve=Leve_Player.EASY.name();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ScreenDisplay inst = new ScreenDisplay(25,"Game Caro");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ScreenDisplay(int size,String tile) {
		super(tile);
		menuBar =new MenuBar();
		setJMenuBar(menuBar);
		initGUI();
		createView(size);
		URL url = this.getClass().getResource("imageCaro/playingcard.png");
		Image image = new ImageIcon(url).getImage();
//		Image im = this.getToolkit().getImage("imageCaro/playingcard.png");
		this.setIconImage(image);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				panelContain = new JPanel();
				getContentPane().add(panelContain, BorderLayout.CENTER);
				BorderLayout panelContainLayout = new BorderLayout();
				panelContain.setLayout(panelContainLayout);
				panelContain.setBackground(Color.BLUE);
				panelContain.setPreferredSize(new java.awt.Dimension(852, 600));
				{
					panelResult = new JPanel();
					panelContain.add(panelResult, BorderLayout.EAST);
					BorderLayout panelInformationLayout = new BorderLayout();
					panelResult.setLayout(panelInformationLayout);
					panelResult.setPreferredSize(new java.awt.Dimension(226, 734));
					panelResult.setBackground(new java.awt.Color(255,168,168));
					{
						panelWayToPlay = new JPanel();
						TitledBorder titleWayToPlay = new TitledBorder("Way To Play:");
						titleWayToPlay.setTitleColor(Color.DARK_GRAY);
						panelWayToPlay.setBorder(titleWayToPlay);
						panelResult.add(panelWayToPlay, BorderLayout.NORTH);
						panelWayToPlay.setLayout(null);
						panelWayToPlay.setPreferredSize(new java.awt.Dimension(226, 148));
						panelWayToPlay.setBackground(new java.awt.Color(255,168,168));
						{
							labelLevel = new JLabel();
							labelLevel.setForeground(Color.blue);
							panelWayToPlay.add(labelLevel);
							labelLevel.setText("Level:");
							labelLevel.setBounds(20, 35, 48, 24);
						}
						{
							labelUsage = new JLabel();
							labelUsage.setForeground(Color.blue);
							panelWayToPlay.add(labelUsage);
							labelUsage.setText("Usage:");
							labelUsage.setBounds(20, 71, 47, 24);
						}
						{
							textLevel = new JTextField("Easy");
							panelWayToPlay.add(textLevel);
							textLevel.setEditable(false);
							textLevel.setBounds(86, 36, 112, 23);
							textLevel.setFont(new java.awt.Font("Arial",1,12));
						}
						{
							textUsage = new JTextField("Caro");
							textUsage.setEditable(false);
							panelWayToPlay.add(textUsage);
							textUsage.setBounds(86, 72, 112, 23);
							textUsage.setFont(new java.awt.Font("Arial",1,12));
						}
					}
					{
						jPanel1 = new JPanel();
						panelResult.add(jPanel1, BorderLayout.SOUTH);
						jPanel1.setBackground(Color.pink);
						jPanel1.setLayout(null);
						TitledBorder titleResult = new TitledBorder("Result:");
						titleResult.setTitleColor(Color.darkGray);
						jPanel1.setBorder(titleResult);
						jPanel1.setPreferredSize(new java.awt.Dimension(226, 164));
						jPanel1.setBackground(new java.awt.Color(255,168,168));
						{
							textResutl = new JTextField();
							jPanel1.add(textResutl);
							textResutl.setText("NoBody");
							textResutl.setFont(new Font("Arial",Font.BOLD,14));
							textResutl.setHorizontalAlignment(JTextField.CENTER);
							textResutl.setEditable(false);
							textResutl.setBounds(27, 88, 176, 32);
						}
						{
							URL url = this.getClass().getResource("imageCaro/icons.gif");
							Image image = new ImageIcon(url).getImage();
							ImageIcon pic = new ImageIcon(image);
							labelResult = new JLabel(pic);
							BorderLayout labelResultLayout = new BorderLayout();
							labelResult.setLayout(labelResultLayout);
							jPanel1.add(labelResult);
							labelResult.setBounds(33, 31, 164, 32);
						}
					}
					{
						panelType = new JPanel();
						BorderLayout panelTypeLayout = new BorderLayout();
						panelResult.add(panelType, BorderLayout.CENTER);
						TitledBorder titleType = new TitledBorder("Information:");
						titleType.setTitleColor(Color.DARK_GRAY);
						panelType.setBorder(titleType);
						panelType.setLayout(panelTypeLayout);
						panelType.setBackground(new java.awt.Color(255,168,168));
						URL url = this.getClass().getResource("imageCaro/icon.jpg");
						Image image = new ImageIcon(url).getImage();
						ImageIcon pic = new ImageIcon(image);
						JLabel labicon= new JLabel(pic);
						labicon.setHorizontalAlignment(JLabel.CENTER);
						labicon.setPreferredSize(new java.awt.Dimension(161, 70));
						labicon.setBounds(30, 21, 145, 71);
						panelType.add(labicon,BorderLayout.NORTH);
						labicon.setBackground(new java.awt.Color(255,168,168));
						labicon.setOpaque(true);
						{
							textAreaType = new TextArea();
							textAreaType.setEditable(false);
							textAreaType.setBackground(Color.WHITE);
							panelType.add(textAreaType, BorderLayout.CENTER);
							textAreaType.setBounds(12, 104, 184, 154);
							textAreaType.setFont(new Font("Arial",Font.BOLD,12));
						}
					}
				}
			}
			pack();
//			this.setSize(837, 768);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//menubar
	class MenuBar extends JMenuBar{
		JMenuItem exit;
		JMenu edit;
		JMenu setting ;
		JRadioButtonMenuItem perfirst;
		JRadioButtonMenuItem easy ;
		private MenuBar(){
		
		setBackground(Color.pink);
			
		//Thuc don File	
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
			
		JMenuItem news = new JMenuItem("New");
		news.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				perfirst.setSelected(true);
				
				newGame();
				
				
			}
			
		});
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
			final JFrame frameexit = new JFrame("Exit");
			
			
			
			JPanel panelexit = new JPanel();
			URL url = this.getClass().getResource("imageCaro/khi2.gif");
			Image image = new ImageIcon(url).getImage();
			ImageIcon icon = new ImageIcon(image);
			JLabel lab = new JLabel(icon);
			lab.setBounds(34, 53, 49, 44);
			panelexit.add(lab);
			JButton yes = new JButton("Yes");
			yes.setBounds(129, 78, 55, 26);
			yes.setBackground(Color.lightGray);
			yes.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
					
				}
				
			});
			JButton no = new JButton("No");
			no.setBounds(201, 77, 55, 27);
			no.setBackground(Color.lightGray);
			no.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					frameexit.setVisible(false);
					
				}
				
			});
			JLabel label = new JLabel("         Do you want to quit Game?\n");
			label.setBounds(99, 28, 178, 30);
			panelexit.setBackground(Color.PINK);
			panelexit.setLayout(null);
			panelexit.add(label);
			panelexit.add(yes);
			panelexit.add(no);
			frameexit.add(panelexit);
			frameexit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameexit.setVisible(true);
			frameexit.setSize(300,160);
			frameexit.setResizable(false);
			frameexit.setLocation(300,300);
			
				
			}
			
		});
		file.add(news);
		file.add(exit);
		add(file);
		
		//Thuc don Settings
		setting = new JMenu("Setting");
		setting.setMnemonic(KeyEvent.VK_S);
		
		
		JMenu level = new JMenu("Level");
		ButtonGroup grouplevel = new ButtonGroup();
		easy = new JRadioButtonMenuItem("Easy");
		easy.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				textLevel.setText("Easy");
				leve = Leve_Player.EASY.name();
				setLevel(Leve_Player.EASY.name());
			}
			
		});
		JRadioButtonMenuItem normal = new JRadioButtonMenuItem("Normal");
		normal.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				textLevel.setText("Normal");
				leve =Leve_Player.NORMAL.name();
				setLevel(Leve_Player.NORMAL.name());
			}
			
		});
		JRadioButtonMenuItem difficult = new JRadioButtonMenuItem("Difficult");
		difficult.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				textLevel.setText("Difficult");
				leve = Leve_Player.HARD.name();
				setLevel(Leve_Player.HARD.name());
			}
			
		});
		easy.setSelected(true);
		grouplevel.add(easy);
		grouplevel.add(normal);
		grouplevel.add(difficult);
		level.add(easy);
		level.add(normal);
	    level.add(difficult);
		
		JMenu usage = new JMenu("Usage");
		ButtonGroup groupusage = new ButtonGroup();
		JRadioButtonMenuItem gomuku = new JRadioButtonMenuItem("GoMuKu");
		gomuku.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				textUsage.setText("Gomoku");
				rule=Leve_Player.GOMOKURULE.name();
				setCheckWin(Leve_Player.GOMOKURULE.name());
				easy.setSelected(true);
				textLevel.setText("Easy");
			}
			
		});
		JRadioButtonMenuItem caro = new JRadioButtonMenuItem("Caro");
		caro.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				textUsage.setText("Caro");
				rule=Leve_Player.CARORULE.name();
				setCheckWin(Leve_Player.CARORULE.name());
				easy.setSelected(true);
				textLevel.setText("Easy");
			}
			
		});
		caro.setSelected(true);
		groupusage.add(gomuku);
		groupusage.add(caro);
		
		usage.add(gomuku);
		usage.add(caro);
		
		setting.add(level);
		setting.add(usage);
		add(setting);
		
		
		
		
		
		//Thuc don Edit
		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu computer = new JMenu("With Computer");
		ButtonGroup groupPlayFirst = new ButtonGroup();
		JRadioButtonMenuItem comfirst = new JRadioButtonMenuItem("Computer First");
		comfirst.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				playerType=Leve_Player.COMPUTER_HUMAN.name();
				setPlayerType(Leve_Player.COMPUTER_HUMAN.name());
				setLevel(leve);
			}
			
		});
		perfirst = new JRadioButtonMenuItem("Person First");
		perfirst.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				playerType=Leve_Player.HUMAN_COMPUTER.name();
				setPlayerType(Leve_Player.HUMAN_COMPUTER.name());
				setLevel(leve);
			}
			
		});
		perfirst.setSelected(true);
		groupPlayFirst.add(comfirst);
		groupPlayFirst.add(perfirst);
		computer.add(comfirst);
		computer.add(perfirst);
		JRadioButtonMenuItem person = new JRadioButtonMenuItem("With Person");
		person.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				playerType=Leve_Player.HUMAN_HUMAN.name();
				setPlayerType(Leve_Player.HUMAN_HUMAN.name());
				control.setFindAPointPlayerOne(new FindAPointWithHuman());
				control.setFindAPointTwo(new FindAPointWithHuman());
			}
			
		});
		groupPlayFirst.add(person);
		edit.add(computer);
		edit.add(person);
		add(edit);
		
		//Thuc don Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem intro = new JMenuItem("Introduce");
		intro.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				Component source = (Component)e.getSource();
				JOptionPane intro = new JOptionPane();
				intro.setMessage("  1. Nguyen Thi Kim Thoa\n" +
								 "  2. Nguyen Gia Trung\n" +
								 "  3. Truong Ngoc Tan\n"+
								 "  4. Nguyen Le Bao Toan\n");
				TitledBorder title = new TitledBorder("Group develop this Game :");
				title.setTitleColor(Color.red);
				intro.setBorder(title);
				
				JDialog dialog = intro.createDialog(source, "");
				dialog.setVisible(true);
			}			
			}
			
		);
		JMenuItem howtoPlay = new JMenuItem("How To Play");
		howtoPlay.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				Component source = (Component)e.getSource();
				JOptionPane intro = new JOptionPane();
				intro.setMessage("  1. Select New for begin Game:\n" +
								 "  2. Select Level for Game:\n" +
								 "       - Easy\n"+
								 "       - Normal\n"+
								 "       - Difficult\n"+
								 "  3. Select Usage for Game:\n"+
								 "       - Caro:            when you have 5 pawns in a line,\n"+
								 "                                        but your competitor prevent this line,\n"+
								 "                                        you haven't win yet.\n"+
								 "       - Gomoku:     when you have enough 5 pawns in a line,You win\n"+
								 "  4. Select competitor:\n"+
								 "       - Computer\n"+
								 "             + Computer plays first\n"+
								 "             + You play first\n"+
								 "       - Person\n"+
								 "  5. Select Exit for quit Game.\n"
								 );
				TitledBorder title1 = new TitledBorder("How to Play :");
				title1.setTitleColor(Color.red);
				intro.setBorder(title1);
				JDialog dialog = intro.createDialog(source, "");
				dialog.setVisible(true);
			}			
				
				
			
			
		});
		help.add(intro);
		help.add(howtoPlay);
		add(help);
		setBounds(0, 0, 511, 32);
		
		
	}
		public void setEnableMenu(boolean enable){
			edit.setEnabled(enable);
			setting.setEnabled(enable);
		}
	}
	public void createView(int size){
		JPanel panelCell = new JPanel(new GridLayout(size+1,size+1));
		this.size=size;
		panelCell.setBackground(new java.awt.Color(159,221,117));
		panelContain.add(panelCell,BorderLayout.CENTER);
		{
			panelCell.add(new JLabel(" "));
		}
		//		add cac button de danh co vao
		MyButton myButton;
		arrMybutton = new MyButton[size][size];
		ActionListener actionCheckBoard = new ActionCheckBoard();
//		them cac button so
		chiSoDong = new JLabel[size];
		chiSoCot = new JLabel[size];
		for (int i = 0; i < size; i++) {
			chiSoDong[i]=new JLabel(i+"");
			chiSoDong[i].setHorizontalAlignment(JLabel.CENTER);
			panelCell.add(chiSoDong[i]);
		}
		int chu=65;
		for(int i=0;i<size;i++){
			chiSoCot[i]=new JLabel((char)(chu+i)+"");
			chiSoCot[i].setHorizontalAlignment(JLabel.CENTER);
			panelCell.add(chiSoCot[i]);
			for(int j=0;j<size;j++){
				myButton = new MyButton(new Point(i,j));
				arrMybutton[i][j]=myButton;
				panelCell.add(myButton);
				myButton.addActionListener(actionCheckBoard);
			}
			
		}
	}
	class ActionCheckBoard implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MyButton myButton = (MyButton) e.getSource();
			if(myButton.getIcon().equals(MyButton.image)){
				model.play(myButton.getPoint());
			}else{
				playAudio.userWarning();
			}
				
		}
		
	}
	public void setTextAreaType(String text){
		textAreaTypes+=text+"\n";
		textAreaType.setText(textAreaTypes);
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newGame() {
		control.newGame();
		setCheckWin(rule);
		setPlayerType(Leve_Player.HUMAN_COMPUTER.name());
		leve=Leve_Player.EASY.name();
		setLevel(leve);
		textAreaTypes="";
		textAreaType.setText("");
		textLevel.setText("Easy");
		menuBar.easy.setSelected(true);
		setResult("Nobody");
		menuBar.setEnableMenu(true);
		
	}

	@Override
	public void setCheckWin(String rule) {
		control.setCheckWin(rule);
		
	}

	@Override
	public void setLevel(String level) {
		control.setLeve(level);
		
	}

	@Override
	public void setPlayerType(String playerType) {
		control.setPlayerType(playerType);
		
	}

	
	@Override
	public void showMessage(String message) {
		setResult(message);
		URL url = this.getClass().getResource("imageCaro/icoFrame.gif");
		Image image = new ImageIcon(url).getImage();
		new ShowMessage(message,new ImageIcon(image));
	}

	@Override
	public void viewChoisePlay(Point point, int type) {
		menuBar.setEnableMenu(false);
		try {
			arrMybutton[this.point.getX()][this.point.getY()].setBackground(Color.WHITE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(type==ChessBoard.COMPUTER){
			URL url = this.getClass().getResource("imageCaro/xanh.gif");
			Image image = new ImageIcon(url).getImage();
			arrMybutton[point.getX()][point.getY()].setIcon(new ImageIcon(image));
			setTextAreaType("Computer: \t"+chiSoCot[point.getX()].getText()+"-"+chiSoDong[point.getY()].getText());
			playAudio.userX();
		}
		else if(type==ChessBoard.HUMAN){
			URL url = this.getClass().getResource("imageCaro/do.gif");
			Image image = new ImageIcon(url).getImage();
			arrMybutton[point.getX()][point.getY()].setIcon(new ImageIcon(image));
			setTextAreaType("Human: \t \t"+chiSoCot[point.getX()].getText()+"-"+chiSoDong[point.getY()].getText());
			playAudio.userO();
		}
		else {
			URL url = this.getClass().getResource("imageCaro/xanh.gif");
			Image image = new ImageIcon(url).getImage();
			arrMybutton[point.getX()][point.getY()].setIcon(new ImageIcon(image));
			setTextAreaType("Other: \t \t"+chiSoCot[point.getX()].getText()+"-"+chiSoDong[point.getY()].getText());
			playAudio.userX();
			}
		arrMybutton[point.getX()][point.getY()].setBackground(Color.MAGENTA);
		this.point=point;
	}

	@Override
	public void setControl(IControlGame control) {
		this.control=control;
		
	}

	@Override
	public void clearChessBoard() {
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <size; j++) {
				arrMybutton[i][j].setIcon(MyButton.image);
				arrMybutton[i][j].setBackground(Color.WHITE);
			}
			
		}
		
	}

	
	public void setResult(String string) {
		textResutl.setText(string);
		
	}

	@Override
	public void setModel(IModel model) {
		this.model = model;
		
	}
	

}
