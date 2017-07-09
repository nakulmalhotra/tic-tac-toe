import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacToe extends JFrame implements ActionListener
{
	int player1=0,player2=0,draw=0;
	int counter=0;
	JButton btn[];
	JPanel pln,pln1;
	Icon ic,ic1;
	Container con;
	JLabel lbwp1,lbwp2,lbd;
	boolean b=false;
	
	TicTacToe()
	{
		setTitle("Tic-Tac-Toe");
		setSize(1370,732);
		btn=new JButton[9];
		lbwp1=new JLabel();
		lbwp2=new JLabel();
		lbd=new JLabel();
		lbwp1.setText("Player1 -    0     ");
		lbwp2.setText("Player2 -    0     ");
		lbd.setText("Draws -    0     ");
		ic=new ImageIcon("Player1.png");
		ic1=new ImageIcon("Player2.png");
		pln=new JPanel();
		pln1=new JPanel();
		lbwp1.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		lbwp2.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		lbd.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		pln1.add(lbwp1);
		pln1.add(lbwp2);
		pln1.add(lbd);
		pln1.setLayout(new GridLayout(3,4));
		con=getContentPane();
		pln.setBackground(Color.blue);
		pln.setLayout(new GridLayout(3,3,5,5));
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton();
			btn[i].addActionListener(this);
			pln.add(btn[i]);
		}
		con.add(pln);
		con.add(pln1,"West");
		show();  // setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public Insets getInsets()								//Margins 
	  {
	       return new Insets(80,150,60,150);
	  }
	public void actionPerformed(ActionEvent e)
		{	
					    
			if(((JButton)e.getSource()).getLabel()=="")
			{	counter++;
				
				if(b==true)
				{
					((JButton)e.getSource()).setIcon(ic1);
					((JButton)e.getSource()).setLabel("#");
					
						b=false;
				}
				
				else
				{
					((JButton)e.getSource()).setIcon(ic);
					((JButton)e.getSource()).setLabel("0");
						b=true;
				}
				
				if(check())
				{
					if(b==true)
					{
						JOptionPane.showMessageDialog(this,"Player 1 wins");
						player1++;
						counter=0;
							for(int i=0;i<btn.length;i++)
								{
									btn[i].setLabel("");
									btn[i].setIcon(null);
									
								}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Player 2 wins");
						player2++;
						counter=0;
							for(int i=0;i<btn.length;i++)
								{
									btn[i].setLabel("");
									btn[i].setIcon(null);
									
								}
					}
					
					
				}
				

			}
			
				if(counter == 9 && !check())                 //Awesome step
					{
						draw++;
						JOptionPane.showMessageDialog(this,"Match Drawn");
						for(int i=0;i<btn.length;i++)
								{
									btn[i].setLabel("");
									btn[i].setIcon(null);
									
								}
								counter=0;
					}
					
					lbwp1.setText("Player 1 -    "+(new Integer(player1)).toString()+"     ");
					lbwp2.setText("Player 2 -    "+(new Integer(player2)).toString()+"     ");
					lbd.setText("Draws -    "+(new Integer(draw)).toString()+"     ");
		 }
		 
		 boolean checkBlank(int a, int b, int c)
		   {
		        if(btn[a].getLabel().length()==0 && btn[b].getLabel().length()==0 && btn[c].getLabel().length()==0 ) 
				return true;
				else
				return false;
			}
		 boolean checkEqual(int a, int b, int c)
		   {
		        if(btn[a].getLabel()==btn[b].getLabel() && btn[b].getLabel() == btn[c].getLabel() ) 
				return true;
				else
				return false;
			}
			
		 boolean check()
		 {
		      boolean status=false;
				if(!checkBlank(0,1,2) && checkEqual(0,1,2))
				{	
					status= true;
				}
				
				else if(!checkBlank(3,4,5) && checkEqual(3,4,5))
				{	
					status= true;
				}
				
				else if(!checkBlank(6,7,8) && checkEqual(6,7,8))
				{	
					status= true;
				}
				
				else if(!checkBlank(0,3,6) && checkEqual(0,3,6))
				{	
					status= true;
				}
				
				else if(!checkBlank(1,4,7) && checkEqual(1,4,7))
				{	
					status= true;
				}
				
				else if(!checkBlank(2,5,8) && checkEqual(2,5,8))
				{	
					status= true;
				}
				
				else if(!checkBlank(0,4,8) && checkEqual(0,4,8))
				{	
					status= true;
				}
				
				else if(!checkBlank(2,4,6) && checkEqual(2,4,6))
				{	
					status= true;
				}
				return status;
			}			
	public static void main(String args[])
	{
		TicTacToe ob=new TicTacToe();
		
	}
	
}