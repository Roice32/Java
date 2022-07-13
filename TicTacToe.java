import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel restart_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton restart = new JButton();
	boolean xTurn;
	
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,600);
		frame.setTitle("X și O");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		textfield.setBackground(Color.DARK_GRAY);
		textfield.setForeground(Color.GREEN);
		textfield.setFont(new Font("Arial", Font.BOLD, 40));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("X și O");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,720,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(new Font("Comic sans", Font.BOLD, 75));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		restart.setFont(new Font("Arial", Font.BOLD, 40));
		restart.setFocusable(false);
		restart.addActionListener(this);
		restart.setText("Restart");
		
		restart_panel.setLayout(new BorderLayout());
		restart_panel.setSize(40,100);
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		restart_panel.add(restart);
		frame.add(restart_panel,BorderLayout.SOUTH);
		
		try { Thread.sleep(1000); }
		catch (InterruptedException e)
			{ e.printStackTrace(); }
		firstTurn();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<9; i++)
			if(e.getSource()==buttons[i])
			{
				if(buttons[i].getText()=="")
				{
					if(xTurn)
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						xTurn=false;
						textfield.setText("Rândul lui O");
						check();
					}
					else
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						xTurn=true;
						textfield.setText("Rândul lui X");
						check();
					}
				}
			}
			else if(e.getSource()==restart)
				restartGame();
	}
	
	public void firstTurn()
	{
		xTurn = true;
		textfield.setText("Rândul lui X");
	}
	
	public void check()
	{
		// Necesită optimizare!
		if((buttons[0].getText()=="X") &&
		   (buttons[1].getText()=="X") &&
		   (buttons[2].getText()=="X"))
			{ xWins(0,1,2); }
		
		if((buttons[3].getText()=="X") &&
		   (buttons[4].getText()=="X") &&
		   (buttons[5].getText()=="X"))
			{ xWins(3,4,5); }
		
		if((buttons[6].getText()=="X") &&
		   (buttons[7].getText()=="X") &&
	       (buttons[8].getText()=="X"))
			{ xWins(6,7,8); }
		
		if((buttons[0].getText()=="X") &&
		   (buttons[3].getText()=="X") &&
		   (buttons[6].getText()=="X"))
			{ xWins(0,3,6); }

		if((buttons[1].getText()=="X") &&
		   (buttons[4].getText()=="X") &&
		   (buttons[7].getText()=="X"))
			{ xWins(1,4,7); }
		
		if((buttons[2].getText()=="X") &&
	   	   (buttons[5].getText()=="X") &&
		   (buttons[8].getText()=="X"))
			{ xWins(2,5,8); }
		
		if((buttons[0].getText()=="X") &&
		   (buttons[4].getText()=="X") &&
		   (buttons[8].getText()=="X"))
			{ xWins(0,4,8); }

		if((buttons[2].getText()=="X") &&
		   (buttons[4].getText()=="X") &&
		   (buttons[6].getText()=="X"))
			{ xWins(2,4,6); }
		
		if((buttons[0].getText()=="O") &&
		   (buttons[1].getText()=="O") &&
		   (buttons[2].getText()=="O"))
			{ oWins(0,1,2); }
				
		if((buttons[3].getText()=="O") &&
		   (buttons[4].getText()=="O") &&
		   (buttons[5].getText()=="O"))
			{ oWins(3,4,5); }
				
		if((buttons[6].getText()=="O") &&
		   (buttons[7].getText()=="O") &&
	       (buttons[8].getText()=="O"))
			{ oWins(6,7,8); }
				
		if((buttons[0].getText()=="O") &&
		   (buttons[3].getText()=="O") &&
		   (buttons[6].getText()=="O"))
			{ oWins(0,3,6); }

		if((buttons[1].getText()=="O") &&
		   (buttons[4].getText()=="O") &&
		   (buttons[7].getText()=="O"))
			{ oWins(1,4,7); }
				
		if((buttons[2].getText()=="O") &&
	   	   (buttons[5].getText()=="O") &&
		   (buttons[8].getText()=="O"))
			{ oWins(2,5,8); }
				
		if((buttons[0].getText()=="O") &&
		   (buttons[4].getText()=="O") &&
		   (buttons[8].getText()=="O"))
			{ oWins(0,4,8); }

		if((buttons[2].getText()=="O") &&
		   (buttons[4].getText()=="O") &&
		   (buttons[6].getText()=="O"))
			{ oWins(2,4,6); }
				
	}
	
	public void xWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++)
			buttons[i].setEnabled(false);
		textfield.setText("X a câștigat!");
	}
	
	public void oWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++)
			buttons[i].setEnabled(false);
		textfield.setText("O a câștigat!");
	}
	
	public void restartGame()
	{
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(true);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setText("");
			firstTurn();
		}
	}
}
