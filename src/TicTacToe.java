import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JButton buttons[] = new JButton[9];
	JPanel button_pannel = new JPanel();
	JLabel textfield = new JLabel();
	Random random = new Random();
	JButton newGame = new JButton();
	boolean player1_turn;
	TicTacToe(){
		frame.setSize(500, 500);
		frame.getContentPane().setBackground(Color.white);
		frame.setTitle("TIC-TAC-TOE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.GREEN);
		textfield.setText("Tic-Tac-Toe");
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setVerticalAlignment(JLabel.NORTH);
		textfield.setOpaque(true);
		textfield.setFont(new Font("MV Boli", Font.ROMAN_BASELINE,80));
		
		
		newGame.setText("New Game");
		newGame.setFocusable(false);
		newGame.setBounds(0, 0, 50, 50);
	
		
		title_panel.setBackground(Color.black);
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 100, 100);
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		
		button_pannel.setLayout(new GridLayout(3,3));
		button_pannel.setBackground(Color.GRAY);
		for(int i = 0 ; i < 9 ; i++){
			buttons[i] = new JButton();
			button_pannel.add(buttons[i]);
			buttons[i].setFocusable(false);
			buttons[i].setFont(new Font("MV Boli" ,Font.BOLD ,120));
			buttons[i].addActionListener(this);
			
		}
		
		newGame.addActionListener(this);
		frame.add(button_pannel);
		firstTurn();
		
	} 
	
public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
		if(e.getSource() == newGame) {
			 TicTacToe newGame = new TicTacToe();
		}
	}
	
	public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	void xWins(int a , int b , int c) {
	     buttons[a].setBackground(Color.green);
	     buttons[b].setBackground(Color.green);
	     buttons[c].setBackground(Color.green);
	     for(int i = 0 ; i < 9 ; i++) {
	    	 buttons[i].setEnabled(false);
	     }
	     textfield.setText("X WIns");
	    
	     title_panel.add(newGame);
	    // TicTacToe newGame = new TicTacToe();
	}
	void oWins(int a , int b , int c) {
	     buttons[a].setBackground(Color.green);
	     buttons[b].setBackground(Color.green);
	     buttons[c].setBackground(Color.green);
	     for(int i = 0 ; i < 9 ; i++) {
	    	 buttons[i].setEnabled(false);
	     }
	     textfield.setText("O WIns");
	     title_panel.add(newGame);
	    // TicTacToe newGame = new TicTacToe();
	}

}
