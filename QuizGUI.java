package labprok;

/*Tofik Mahdi 
 * 
 * this program is a 10 question quiz based on some facts about the state of maryland.
 * there are 3 choices for each answer 
 * 
 * there are 2 buttons on the bottom, one for submiting answers and another for reseting all buttons and the score
 * when the user chooses all his/her answers and clicks submit,it will print the score
 * 
 * i used a JPanel "board" in order to print each question and each answer in its own line
 * 
 * 
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;

//import last_weeks.ScrollBarExample.MyAdjustmentListener;

// constructor     
public class QuizGUI extends JFrame implements ActionListener{

	private JLabel [] question;
	
	private JButton[] b;// buttons for answers
	private JPanel [] board;
	private JButton reset;
	private JButton submit;
	
	private static JPanel panel;
	

	
	private JLabel Score;
	private int score=0;// number correct
	
	
	private double percentage;//percent correct
	
	
	
		
	
	 
	public static final  int WIDTH = 500;// preferred size to display questions
	public static final int HEIGHT = 500;

	
	
	public QuizGUI(){
		super("Quiz on State of MD");// title of window
		setLayout(new FlowLayout());// sets the layout of the window
		
		
	
		
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b= new JButton[30];// 30 buttons, 10 questions with 3 buttons for each 
		question = new JLabel[11];
		board = new JPanel[32];
		Score = new JLabel();
		reset = new JButton("reset");
		
		
		submit= new JButton("submit");
		
		
		panel = new JPanel(new GridLayout(30,1));
		
		
		
		
		
		
		board [0]= new JPanel(new GridLayout(1, 10,10,10));// queston 1
		question[0] = new JLabel("1. What is the capital of MD?");// prints first question
		
		
		
		
		board [1]= new JPanel(new GridLayout(1, 10,10,10));// 3 buttons for question 1
		
		board [2]= new JPanel(new GridLayout(1, 10,10,10));// question 2
		
		board [3]= new JPanel(new GridLayout(1, 10,10,10)); // answers for question 2
	
		
		
		
		board [4]= new JPanel(new GridLayout(1, 10,10,10));// question 3
		board [5]= new JPanel(new GridLayout(1, 10,10,10)); // answers 
		
		
		
		board [6]= new JPanel(new GridLayout(1, 10,10,10));// question 4
		board [7]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [8]= new JPanel(new GridLayout(1, 10,10,10));// question5
		board [9]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [10]= new JPanel(new GridLayout(1, 10,10,10));// question 6
		board [11]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [12]= new JPanel(new GridLayout(1, 10,10,10));// question 7
		board [13]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [14]= new JPanel(new GridLayout(1, 10,10,10));// question 8
		board [15]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [16]= new JPanel(new GridLayout(1, 10,10,10));// question 9
		board [17]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [18]= new JPanel(new GridLayout(1, 10,10,10));// question 10
		board [19]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [20]= new JPanel(new GridLayout(1, 10,10,10));
		board [21]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [22]= new JPanel(new GridLayout(1, 10,10,10));

		board [23]= new JPanel(new GridLayout(1, 10,10,10));
		board [24]= new JPanel(new GridLayout(1, 10,10,10));
		
		board [25]= new JPanel(new GridLayout(1, 10,10,10));

	   
		
		
		
		setLocationRelativeTo(null);// displays window to center of screen
		  
		
		
		question[1] = new JLabel("2. Who is the Governor?");
		question[2] = new JLabel("3. What County is UMD in? ");
		question[3] = new JLabel("4. What is the largest city? ");
		question[4] = new JLabel("5. When did MD join the U.S? ");
		question[5] = new JLabel("6. What Region is MD located in? ");
		question[6] = new JLabel("7. What's the offical state sport of MD? ");
		question[7] = new JLabel("8. Which of these is a nickname for the state? ");
		question[8] = new JLabel("9. Which of these famous people are from MD ");
		question[9] = new JLabel("10. Who is the highest ranking government official to come from MD  ");
		question[10] = new JLabel("");// adds some space between question 10 answers and bottom buttons
		// 1x 10
		
		 b[0] = new JButton("Annapolis");// a button containing this text will show
		 b[1] = new JButton("Rockville");  // question 1
		b[2]= new JButton("Silver Spring");
		 // correct index: 0,4,8,9,14,17,20,22,25,28

		 b[3] = new JButton("Martin O'Malley");// a button containing this text will show
		 b[4] = new JButton("Larry Hogan"); // question 2
		b[5]= new JButton("Chris Christie");
		
		b[6] = new JButton("Montgomery");// a button containing this text will show
		 b[7] = new JButton("Anne Arundel");// question 3
		b[8]= new JButton("Prince Georges");
		
		
		b[9] = new JButton("Baltimore");// a button containing this text will show
		 b[10] = new JButton("Philadelphia");// q4
		b[11]= new JButton("Bethesda");
		
		b[12] = new JButton("1776");// a button containing this text will show
		 b[13] = new JButton("1785");//q5
		b[14]= new JButton("1788");
		
		b[15] = new JButton("MidWest");// a button containing this text will show
		 b[16] = new JButton("West Coast");//q6
		b[17]= new JButton("Mid Atlantic");
		
		b[18] = new JButton("Archery");// a button containing this text will show
		 b[19] = new JButton("Sailing");//q7
		b[20]= new JButton("Jousting");
		
		b[21] = new JButton("Old Dominion");// a button containing this text will show
		 b[22] = new JButton("Old Line State");//q8
		b[23]= new JButton("Golden State");
		
		b[24] = new JButton("Seth MacFarlane");// a button containing this text will show
		 b[25] = new JButton("Kevin Durant");//q9
		b[26]= new JButton("George Washington");
		
		b[27] = new JButton("Thurgood Marshall");// a button containing this text will show
		 b[28] = new JButton("Spiro Agnew");//q10
		b[29]= new JButton("Frederick Douglass");
		

		
		// adding jpanel"board" Manually
		
		panel.
		add(board[0], BorderLayout.CENTER); //adds first question
		board[0].add(question[0]);
		
		panel.
		add(board[1], BorderLayout.EAST);//adds first question answers
		board[1].add(b[0]);
		board[1].add(b[1]);
		board[1].add(b[2]);
		
		b[0].addActionListener(this);// buttons will listen to mouse
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		
		
		
		panel.
		add(board[2], BorderLayout.CENTER); // adds question 2
		board[2].add(question[1]);
		
		
		panel.
		add(board[3], BorderLayout.EAST); // adds question 2 ansers
		board[3].add(b[3]);
		board[3].add(b[4]);
		board[3].add(b[5]);
		
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		
		panel.
		add(board[4], BorderLayout.CENTER); // adds question 3
		board[4].add(question[2]);
		
		
		panel.
		add(board[5], BorderLayout.EAST);// adds answers
		board[5].add(b[6]);
		board[5].add(b[7]);
		board[5].add(b[8]);
		
		
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		
	
		
		
		panel.
		add(board[8], BorderLayout.CENTER); // adds question 4
		board[8].add(question[3]);
				
		panel.
		add(board[9], BorderLayout.EAST);// adds answers
		board[9].add(b[9]);
		board[9].add(b[10]);
		board[9].add(b[11]);
		
		
		b[9].addActionListener(this);
		b[10].addActionListener(this);
		b[11].addActionListener(this);
		
		
	panel.
		add(board[10], BorderLayout.CENTER); // adds question 5
		board[10].add(question[4]);
		
		
		panel.
		add(board[11], BorderLayout.EAST);// adds answers
		board[11].add(b[12]);
		board[11].add(b[13]);
		board[11].add(b[14]);
		
		b[12].addActionListener(this);
		b[13].addActionListener(this);
		b[14].addActionListener(this);
		
		
		panel.
		add(board[12], BorderLayout.CENTER); // adds question 6
		board[12].add(question[5]);
		
		
		panel.
		add(board[13], BorderLayout.EAST);// adds answers
		board[13].add(b[15]);
		board[13].add(b[16]);
		board[13].add(b[17]);
		
		b[15].addActionListener(this);
		b[16].addActionListener(this);
		b[17].addActionListener(this);
		
		
		
		panel.
		add(board[14], BorderLayout.CENTER); // adds question 7
		board[14].add(question[6]);
		
		
		panel.
		add(board[15], BorderLayout.EAST);// adds answers
		board[15].add(b[18]);
		board[15].add(b[19]);
		board[15].add(b[20]);
		
		b[18].addActionListener(this);
		b[19].addActionListener(this);
		b[20].addActionListener(this);
		
		
		panel.
		add(board[16], BorderLayout.CENTER); // adds question 8
		board[16].add(question[7]);
		
		
		panel.
		add(board[17], BorderLayout.EAST);// adds answers
		board[17].add(b[21]);
		board[17].add(b[22]);
		board[17].add(b[23]);
		
		b[21].addActionListener(this);
		b[22].addActionListener(this);
		b[23].addActionListener(this);
		
		
		panel.
		add(board[18], BorderLayout.CENTER); // adds question 9
		board[18].add(question[8]);
		
	
		panel.
		add(board[19], BorderLayout.EAST);// adds answers
		board[19].add(b[24]);
		board[19].add(b[25]);
		board[19].add(b[26]);
		
		b[24].addActionListener(this);
		b[25].addActionListener(this);
		b[26].addActionListener(this);
		
		
		panel.
		add(board[20], BorderLayout.CENTER); // adds question 10
		board[20].add(question[9]);
		
		
		
		panel.
		add(board[21], BorderLayout.EAST);// adds answers
		board[21].add(b[27]);
		board[21].add(b[28]);
		board[21].add(b[29]);
		
		b[27].addActionListener(this);
		b[28].addActionListener(this);
		b[29].addActionListener(this);
		
		//adds space between last questions and submit and reset buttons
		panel.
		add(board[22], BorderLayout.CENTER); // adds question 10
		board[22].add(question[10]);
		
		
		
		panel.
		add(board[23],BorderLayout.CENTER);
		
		
		
 		
		Score.setText("score: "+percentage+"%");;
		board[23].add(Score);
		board[23].add(submit);
		board[23].add(reset);
		
		
		submit.addActionListener(this);
		reset.addActionListener(this); 
        
	        
	        
	        add(panel,BorderLayout.CENTER);// adds entire panel to center
		 
		 
		 
		 
	}// end window
	
	
	


 						 
 
	
	public static void main(String[] args) {

		 
		
		QuizGUI w = new QuizGUI();

		 

w.setVisible(true);// shows window


/****** SCrollbar   **********************/


JScrollPane scrollPane = new JScrollPane(panel);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


scrollPane.setBounds(10,10,500, 500);


JPanel contentPane = new JPanel(null);
contentPane.setPreferredSize(new Dimension(510, 500));
contentPane.add(scrollPane);
w.setContentPane(contentPane);
w.pack();


/*****************************/


	}// end amain
		
		


	public void actionPerformed(ActionEvent e){
		System.out.println(e);
		String actionCommand = e.getActionCommand();
		
	
		
		System.out.println("this is the item : " + actionCommand);
		
		
		
		if ( actionCommand.equals("reset")){
			reset(); // calls function reset board
		
		}
		else
		if ( actionCommand.equals("submit")){
			 // correct index: 0,4,8,9,14,17,20,22,25,28
		
			
			/* if all these buttons are disabled, it will calculatre the score,
			only these buttons shown here will add points to score*/
			 
			if(b[0].isEnabled()==false)
				calcuScore();
			if(b[4].isEnabled()==false)
				calcuScore();

			if(b[8].isEnabled()==false)
				calcuScore();

			if(b[9].isEnabled()==false)
				calcuScore();

			if(b[14].isEnabled()==false)
				calcuScore();

			if(b[17].isEnabled()==false)
				calcuScore();

			if(b[20].isEnabled()==false)
				calcuScore();

			if(b[22].isEnabled()==false)
				calcuScore();

			if(b[25].isEnabled()==false)
				calcuScore();

			if(b[28].isEnabled()==false)
				calcuScore();

		

				
				
				submit();
		}// end ifsubmit
		
		
		
	/*Disablesbuttons*/	 // it also re enables buttons if another is selected on same line
		if ("Annapolis".equals(e.getActionCommand())) {
		        b[0].setEnabled(false);
		        b[1].setEnabled(true);
		        b[2].setEnabled(true);
		         
		} else if("Rockville".equals(e.getActionCommand())){
		    	 b[1].setEnabled(false);
		    	
		    	 b[0].setEnabled(true);
			        b[2].setEnabled(true);
		    	 
		    }else if("Silver Spring".equals(e.getActionCommand())){
		    	 b[2].setEnabled(false);
		    	 
		    	 b[0].setEnabled(true);
		    	 b[1].setEnabled(true);
		    }else if("Martin O'Malley".equals(e.getActionCommand())){
		    	 b[3].setEnabled(false);
		    	 
		    	 b[4].setEnabled(true);
		    	 b[5].setEnabled(true);
		    	 
		    }else if("Larry Hogan".equals(e.getActionCommand())){
		    	 b[4].setEnabled(false);
		    	 b[3].setEnabled(true);
		    	
		    	 b[5].setEnabled(true);
		    	 
		    }else if("Chris Christie".equals(e.getActionCommand())){
		    	 b[5].setEnabled(false);
		    	 b[3].setEnabled(true);
		    	  
		    	 b[4].setEnabled(true);
		    }else if("Montgomery".equals(e.getActionCommand())){
		    	 b[6].setEnabled(false);
		    	 b[7].setEnabled(true);
		    	   b[8].setEnabled(true);
		    }else if("Anne Arundel".equals(e.getActionCommand())){
		    	 b[7].setEnabled(false);
		    	 
		    	 b[6].setEnabled(true);
		    	 b[8].setEnabled(true);
		    }else if("Prince Georges".equals(e.getActionCommand())){
		    	 b[8].setEnabled(false);
		    	 b[6].setEnabled(true);
		    	 b[7].setEnabled(true);
		    	  
		    }else if("Baltimore".equals(e.getActionCommand())){
		    	 b[9].setEnabled(false);
		    	 b[10].setEnabled(true);
		    	 b[11].setEnabled(true);
		    	  
		    }else if("Philadelphia".equals(e.getActionCommand())){
		    	 b[10].setEnabled(false);
		    	 b[11].setEnabled(true);
		    	  
		    	 b[9].setEnabled(true);
		    }else if("Bethesda".equals(e.getActionCommand())){
		    	 b[11].setEnabled(false);
		    	 b[10].setEnabled(true);
		    	 
		    	 b[9].setEnabled(true);
		    }else if("1776".equals(e.getActionCommand())){
		    	 b[12].setEnabled(false);
		    	 
		    	 b[13].setEnabled(true);
		    	 b[14].setEnabled(true);
		    }else if("1785".equals(e.getActionCommand())){
		    	 b[13].setEnabled(false);
		    	 b[14].setEnabled(true);
		    	  
		    	 b[12].setEnabled(true);
		    }else if("1788".equals(e.getActionCommand())){
		    	 b[14].setEnabled(false);
		    	 b[12].setEnabled(true);
		    	 b[13].setEnabled(true);
		    	 
		    }else if("MidWest".equals(e.getActionCommand())){
		    	 b[15].setEnabled(false);
		    	 b[16].setEnabled(true);
		    	 
		    	 b[17].setEnabled(true);
		    }else if("West Coast".equals(e.getActionCommand())){
		    	 b[16].setEnabled(false);
		    	 b[15].setEnabled(true);
		    	  
		    	 b[17].setEnabled(true);
		    }else if("Mid Atlantic".equals(e.getActionCommand())){
		    	 b[17].setEnabled(false);
		    	 b[16].setEnabled(true);
		    	 b[15].setEnabled(true);
		    	 
		    }else if("Archery".equals(e.getActionCommand())){
		    	 b[18].setEnabled(false);
		    	 b[19].setEnabled(true);
		    	  
		    	 b[20].setEnabled(true);
		    }else if("Sailing".equals(e.getActionCommand())){
		    	 b[19].setEnabled(false);
		    	 b[18].setEnabled(true);
		    	 
		    	 b[20].setEnabled(true);
		    }else if("Jousting".equals(e.getActionCommand())){
		    	 b[20].setEnabled(false);
		    	 b[18].setEnabled(true);
		    	 b[19].setEnabled(true);
		    	  
		    }else if("Old Dominion".equals(e.getActionCommand())){
		    	 b[21].setEnabled(false);
		    	 
		    	 b[22].setEnabled(true);
		    	 b[23].setEnabled(true);
		    }else if("Old Line State".equals(e.getActionCommand())){
		    	 b[22].setEnabled(false);
		    	 b[23].setEnabled(true);
		    	 b[21].setEnabled(true);
		    	 
		    }else if("Golden State".equals(e.getActionCommand())){
		    	 b[23].setEnabled(false);
		    	 b[22].setEnabled(true);
		    	 
		    	 b[21].setEnabled(true);
		    }else if("Seth MacFarlane".equals(e.getActionCommand())){
		    	 
		    	b[24].setEnabled(false);
		    	 b[25].setEnabled(true);
		    	 b[26].setEnabled(true);
		    }else if("Kevin Durant".equals(e.getActionCommand())){
		    	 b[25].setEnabled(false);
		    	 b[26].setEnabled(true);
		    	 b[24].setEnabled(true);
		    	  
		    }else if("George Washington".equals(e.getActionCommand())){
		    	  
		    	b[26].setEnabled(false);
		    	 b[24].setEnabled(true);
		    	 b[25].setEnabled(true);
		    }else if("Thurgood Marshall".equals(e.getActionCommand())){
		    	 b[27].setEnabled(false);
		    	 
		    	 b[28].setEnabled(true);
		    	 b[29].setEnabled(true);
		    }else if("Spiro Agnew".equals(e.getActionCommand())){
		    	 b[28].setEnabled(false);
		    	 b[29].setEnabled(true);
		    	 b[27].setEnabled(true);
		    	  
		    }else if("Frederick Douglass".equals(e.getActionCommand())){
		    	 b[29].setEnabled(false);
		    	 b[28].setEnabled(true);
		    	  
		    	 b[27].setEnabled(true);
		    } 
		    

		
		
		
		
		
		
	}// end action performed






public void calcuScore(){
	
	score++;// affects the score
	System.out.println(score);
	


}// calcluates correct





public void submit(){
	
	if(score<0){
		score++;
	}
	
	
	 percentage= (double) (score/10.0) *100.0; // sets score

System.out.println(percentage+"%");// prints score to console
Score.setText("score: "+percentage+"%");// shows the score on the window, in the jLabel "Score"
}

public void reset(){
	
	 
	for (int i = 0; i < b.length; i++){
	 
	
		b[i].setEnabled(true);// reinables all butons
		Score.setText("score: "+"0.0"+"%");// resets the score on the window
	
	
	}// end loop

score=0;// resets score
}// end reset

}// end class

