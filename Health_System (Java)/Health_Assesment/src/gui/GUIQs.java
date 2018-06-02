package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Graph.Graph;
import Graph.Vertex;
/**
 * The GUI class will initiate the Graphical User Interface to start the system
 * @author Hlungwani T 215021437
 * Graphical User Interface 
 */
@SuppressWarnings("serial")
public class GUIQs extends JFrame{
	
	//Creation of variables to be used in the GUI and in the functions
	private JMenu fileMenu;
	private JMenuBar menubar;
	private JMenuItem newAction, exitAction;
	private JButton btnSubmit, btnExit;;
	private JTextArea txtInformation;
	private int answer;
	private ArrayList<String> answerList;
	private Graph myGraph;
	private Vertex[] numVertices;
	
 	/**
	 * Constructor for the GUI class questions
	 * @param title is the title of the GUI
	 */
	public GUIQs(String title){
		
		//Creation of the frame
		setTitle(title);
		setSize(530, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		//Setup the GUI
		menubar = new JMenuBar();
		setJMenuBar(menubar);

		fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		newAction = new JMenuItem("New Assesment");
		exitAction = new JMenuItem("Exit");

		fileMenu.add(newAction);
		fileMenu.add(exitAction);

		txtInformation = new JTextArea(19, 45);
		txtInformation.setEditable(false);
		add(txtInformation);

		//set buttons and add them to frame
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setEnabled(false);
		btnSubmit.setVisible(true);
		add(btnSubmit);
		
		btnExit = new JButton("EXIT");
		btnExit.setEnabled(false);
		add(btnExit);


		txtInformation.setVisible(true);
		txtInformation.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		//Setting the GUI to be displayed
		setVisible(true);
		
		//Creation of graph instance
		myGraph = new Graph();
		
		//Create vertex instance of size 8
		numVertices = new Vertex[8];
		
		//Initialize 8 vertices and set names
		numVertices[0] = new Vertex("Do you Smoke?");
		numVertices[1] = new Vertex("Do you drink alcohol?");
		numVertices[2] = new Vertex("Do you protect your self sexually?");
		numVertices[3] = new Vertex("Do you exercise?");
		numVertices[4] = new Vertex("Do you have a stable partner?");
		numVertices[5] = new Vertex("Do you have a job?");
		numVertices[6] = new Vertex("Do you regularly eat fruits and veges?");
		numVertices[7] = new Vertex("Do you drink 10 glasses of water per day?");

		//Instantiate an array of answers
		answerList = new ArrayList<String>();

		//New assessment
		newAction.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				answerList.clear();    //clear everything from the list first
				
				//Setting the text and visibility of the button
				txtInformation.setBackground(Color.MAGENTA);
				txtInformation.setText("");
				btnExit.setEnabled(false);
				btnSubmit.setEnabled(true);
				
				//Alert the user
				txtInformation.append("Please answer the following questions by choosing either yes or no..\n\n");		
				
				//Add all the vertices to the graph and...
				for(int x = 0; x < numVertices.length; x++){
					myGraph.addVertex(numVertices[x], true);
					
					//...display them to the frame
					txtInformation.append(numVertices[x].getvName());
					
					//User's option of their answer
					answer = JOptionPane.showConfirmDialog(null, "Please choose your answer..");
					
					//Store user's answers into an array
					//Yes option
					if(answer == 0){   
						answerList.add(x, "YES");
					}
					
					//No option
					else if(answer == 1){    
						answerList.add(x, "NO");
					}
					//Cancel option
					else{
						answerList.add(x, "CANCEL");
					}
					
					//Alert of vertex added to the graph
					System.out.println("Vertex on index "+ x + " :" + numVertices[x].getvName() + " Added to graph");
					
					//Alert of answer provided by user
					System.out.println("Your answer = " + answerList.get(x) + "\n\n");
				
					//now add space between these questions(i.e. vertices)
					txtInformation.append("\n\n");
				}
				
				//Add all edges to the graph with the connection 
				//and length between the vertices
				myGraph.addEdge(numVertices[0], numVertices[1], 2);
				myGraph.addEdge(numVertices[1], numVertices[2], 2);
				myGraph.addEdge(numVertices[0], numVertices[2], 4);
				myGraph.addEdge(numVertices[2], numVertices[4], 2);
				myGraph.addEdge(numVertices[4], numVertices[5], 6);
				myGraph.addEdge(numVertices[0], numVertices[3], 3);
				myGraph.addEdge(numVertices[3], numVertices[6], 2);
				myGraph.addEdge(numVertices[3], numVertices[7], 2);
				myGraph.addEdge(numVertices[1], numVertices[7], 8);
				myGraph.addEdge(numVertices[6], numVertices[7], 3);
				
				//Show series of answers provided by user
				System.out.print("Answers given are : " + answerList + "\n\n");
	
				//Notice of how graph is structured
				System.out.print("Graph structure, Edge = ({vertex 1, vetrex 2}, length)\n\n");
				
				//Show the Edges within the graph
				System.out.print("Graph has the following edges : " + myGraph.getEdges());
				
				//Disable before feedback is provided
				newAction.setEnabled(false);
			}
			
		});
		
		
		//Submit button and its listener
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Activate exit button
				btnSubmit.setEnabled(false);
				
				//reset the text area and set new color for answers
				txtInformation.setText("");
				txtInformation.setBackground(Color.CYAN);
				txtInformation.append("Based on your answers,,here is your feedback...\n\n");
				
				System.out.println("\n\nBased on your answers,,here is your feedback...\n\n");
				/*for(int x = 0; x < numVertices.length; x++){
					
					//check if array of answers is not empty
					if(!answerList.isEmpty()){
						
						//Then display the answers
						//txtInformation.append(answers(answerList.get(x), myGraph));
						
						//jump a line
						//txtInformation.append("\n\n");
					}
				}*/
				
				//invoke the utility method to populate the text area with feedback
				countAnswers(answerList);
				
				//allow user to exit application
				btnExit.setEnabled(true);
				//allow user to start over 
				newAction.setEnabled(true); 
			}
		});
					
		//Exit button and its listener
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//alert user of system closing
				JOptionPane.showMessageDialog(null, "Thanks for using our Health Assesment System");
				System.exit(0);
			}
		});
		
		//Exit action and its listener
		exitAction.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//The system closes successfully without errors
				System.exit(0);
			}
		});
	}
	
	/**
	 * Utility/helper method for advising the user based on their answers
	 * This method will check if graph contains two connected vertices and check
	 * the answer provided by the user then give advice based on that
	 * @param choice is the choice of the user
	 * @param g is the graph to be used to get the edges
	 * @return answer is the answer to be returned
	 */
	public String answers(String choice, Graph g){
		
		//If the user choice is YES (VALUE = 0) and graph contains vertices then advice
		if(g.containsVertex(numVertices[0]) && g.containsVertex(numVertices[1]) && choice == "YES"){
			return "Consider quiting smoke and alcohol";
		}
	
		if(g.containsVertex(numVertices[0]) && g.containsVertex(numVertices[2]) && choice == "YES"){
			return "You should quit alcohol and start condomising";
		}
			
		// 
		if(g.containsVertex(numVertices[0])  && g.containsVertex(numVertices[3]) && choice == "YES"){
			return "You should quit smoke and start exercising";
		}
		
		//
		if(g.containsVertex(numVertices[1])  && g.containsVertex(numVertices[2])&& choice == "YES"){
			return "You should quit alcohol and condomise";
		}
		
		//
		if(g.containsVertex(numVertices[1])  && g.containsVertex(numVertices[7]) && choice == "YES"){
			return "You should consider quit alcohol and start exercising";
		}		
		
		//
		if(g.containsVertex(numVertices[2])  && g.containsVertex(numVertices[4]) && choice == "YES"){
			return "Consider having one partner and condomise";
		}	
		
		//
		if(g.containsVertex(numVertices[3] )  && g.containsVertex(numVertices[6]) && choice == "YES"){
			return "Consider exercising and eat some fruits and veges";
		}
		
		//
		if(g.containsVertex(numVertices[3])  && g.containsVertex(numVertices[7]) && choice == "YES"){
			return "Consider exercising and drinking enough water";
		}
		
		//
		if(g.containsVertex(numVertices[4])  && g.containsVertex(numVertices[5]) && choice == "YES"){
			return "Consider having one partner and find a job";
		}
		
		//
		if(g.containsVertex(numVertices[6])  && g.containsVertex(numVertices[7]) && choice == "YES"){
			return "Consider drinking enough water and eat some fruits and veges";
		}
		
		
		//If the user choice is NO (VALUE = 1)
		else if(choice == "NO"){
			return "Your health is not that bad";
		}
		
		//Cancelled answer or something else!!
		else{
			return "You might not have answered this question!!";
		}	
	}
	
	/**
	 * Utility method
	 * This method checks and compares how many answers are provided as YES, NO and CANCEL
	 * then give feedback depending on this
	 * @param answers is the list of answers to be compared
	 */
	public void countAnswers(ArrayList<String> answers){
		HashSet<String> answer = new HashSet<String>(answers);
		
		//For each string in the list
		for(String sT : answer){
			
			//How many times does it occur
			int occurs = Collections.frequency(answers, sT);
			
			//Which string
			boolean yes = sT.equals("YES");  
			boolean no = sT.equals("NO");
			boolean cancel = sT.equals("CANCEL");
			
			//YES occurrence
			if((yes && occurs >= 5)){
				txtInformation.append("This is a good sign that you are healthy\n"
						+ "Many aspects in your life are good\n"
						+ "We reckon you are healthy\n"
						+ "Keep it up!!!!!!!!!('-')\n\n");
				
				System.out.println("This is a good sign that you are healthy\n"
						+ "Many aspects in your life are good\n"
						+ "We reckon you are healthy\n"
						+ "Keep it up!!!!!!!!!('-')\n\n");
			}
			//NO occurrence
			else if(no && occurs >= 4){
				txtInformation.append("This is a critical warning!!!!!!\n"
						+ "You need to mind your lifestyle to maintain\nyour good health & well-being\n"
						+ "We suggest you start focussing on your daily\nbasis bassed on our questions\n"
						+ "You really need to work on your health!!!!('~')\n\n");
				
				System.out.println("This is a critical warning!!!!!!\n"
						+ "You need to mind your lifestyle to maintain\nyour good healt & well-being\n"
						+ "We suggest you start focussing on your daily\nbasis bassed on our questions\n"
						+ "You really need to work on your health!!!!('~')\n\n");
			}
			//CANCEL occurrence
			else if(cancel && occurs > 5){
				txtInformation.append("Many questions were not answered\n"
						+ "Please try again and answer as much questions as you can(*?*)\n\n");
				
				System.out.println("Many questions were not answered\n"
						+ "Please try again and answer as much questions as you can(*?*)\n\n");
			}	
			//Anything apart from the above
			else{
				txtInformation.append("This is not that bad because your health level is at the middle\n"
						+ "Meaning you are 50% healthy and 50% unhealthy\n"
						+ "We would advice you to reduce some of the \nthings you do that put you on this danger zone\n\n");
				
				System.out.println("This is not that bad because your health level is at the middle\n"
						+ "Meaning you are 50% healthy and 50% unhealthy\n"
						+ "We would advice you to reduce some of the \nthings you do that put you on this danger zone\n\n");
			}
		}
	}
}