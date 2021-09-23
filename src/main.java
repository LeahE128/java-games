package project1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class main {
	public static void main(String[] args) {
		//get user input
		//Initialize the Scanner and print a welcome message
				Scanner in = new Scanner(System.in);		
				System.out.println("Welcome");
				//create arrayList of player objects called playerObjs
				ArrayList<Player> playerObjs = new ArrayList<Player>();
				//Use a while(true) loop and only break the loop if the user wants to quit
				while(true) {
				
					//Get the user's move through user input
					System.out.println("Please choose option:");
					System.out.println("1: New Player");
					System.out.println("2: Quit");
					int choice = in.nextInt();
					
					//Check if the user wants to quit the game
					if (choice == 2) {
						break;
					}
					
					if (choice == 1) {
				        System.out.println("Enter your name : ");
				        String newname = in.next();
				        int score = 0;
				        //add new players as they input names
				        playerObjs.add(new Player(newname, score));
 
				        while(true) {
				        System.out.println("Hello" + " " + newname + " " + "please choose a game or -1 to quit:");			    
						System.out.println("1: Rock Paper Scissors");
						System.out.println("2: Coin Toss");
						int gameChoice = in.nextInt();
							if (gameChoice == -1) {
								break;
							}
							if (gameChoice == 1) {
								System.out.println("Hello" + " " + newname + " " + "Welcome to Rock, Paper, Scissors!");
								rockPaperScissors(playerObjs,newname, score);								
					}
							if (gameChoice == 2) {
								System.out.println("Hello" + " " + newname + " " + "Welcome to Coin Toss!");
								coinToss(playerObjs,newname);
					}
				}		       
			}
					else {
						
						System.out.println("Please enter a valid input!");
					}	
				}
				displayVIP(playerObjs);
				Collections.sort(playerObjs);
				displayMax(playerObjs);	
		}
				

//method for displaying max people without leader i.e VIP player
private static void displayMax(ArrayList<Player> playerObjs) {
	Collections.sort(playerObjs);
	//if no more than 1 player is in players object array, they are inadvertently the VIP player
	//if there is more than 1 player in the array, all non VIP players will be displayed
	if (playerObjs.size() > 0) {
	for (int i = 1; i < playerObjs.size(); i++)		
		System.out.println("Player: " + playerObjs.get(i).getName() + "      " + "Points: " + playerObjs.get(i).getScore());
	
}
}

//method for displaying leader in leaderboard i.e the VIP player
private static void displayVIP(ArrayList<Player> playerObjs) {
	//sort array and get first player in array which will be one with highest points
	Collections.sort(playerObjs);
	System.out.println("Leaderboard:");		
	String VIP_name = playerObjs.get(0).getName();
	int VIPscore = playerObjs.get(0).getScore();
	VIP VIPplayer = new VIP(VIP_name, VIPscore, "(VIP)");
	System.out.println("Player: " + VIPplayer.name + " " + VIPplayer.getVIPname() + " " + "Points: " + VIPplayer.score);		
	
}

//method for rock paper scissors game
public static void rockPaperScissors(ArrayList<Player> playerObjs, String name, int score) {
	//Initialize the Scanner and print a welcome message
	
			Scanner input = new Scanner(System.in);

			//Use a while(true) loop and only break the loop if the user wants to quit
			while(true) {
			
				//Get the user's move through user input
				System.out.print("What is your move? Enter string rock, paper, or scissors to make your choice. To quit the game, enter quit: ");
				String playerMove = input.nextLine();
				
				//Check if the user wants to quit the game
				if(playerMove.equals("quit")) {
					break;
				}

				//Check if the user's move is valid (rock, paper, or scissors)
				if(!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {

					System.out.println("please enter a valid input!");
				
				} else {

					//Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2
					int rand = (int)(Math.random()*3);
					
					//Convert the random number to a string using conditionals and print the opponent's move
					String computerMove = "";
					if(rand == 0) {
						computerMove = "rock";
					} else if(rand == 1) {
						computerMove = "paper";
					} else {
						computerMove = "scissors";
					}
					System.out.println("Computer move: " + computerMove);
						
					//Print the results of the game: tie, lose, win
					if(playerMove.equals(computerMove)) {
						System.out.println("It's a tie!");
						String objName = null;
						//add 5 points to player score for a draw
						score += 5;
						Player obj = null;
						for (int i = 0; i < playerObjs.size(); i++)
							obj = playerObjs.get(i);
							if (obj.getName() == name) {
								obj.setScore(score);								
						}
						
						
					} else if((playerMove.equals("rock") && playerMove.equals("scissors")) || (playerMove.equals("scissors") && playerMove.equals("paper")) || (playerMove.equals("paper") && playerMove.equals("rock"))) {
						System.out.println("You won!");
						String objName = null;
						//add 10 points to player score for a win
						score += 10;
						Player obj = null;
						for (int i = 0; i < playerObjs.size(); i++)
							obj = playerObjs.get(i);
							if (obj.getName() == name) {
								obj.setScore(score);
								
						}
				

					} else {
						System.out.println("You lost!");
					}

				}

			}

			System.out.println("Thanks for playing the game Rock, Paper, Scissors!");
	  }

public static void coinToss(ArrayList<Player> playerObjs, String name) {
		//get user input
		//Initialize the Scanner and print a welcome message
		
				Scanner input = new Scanner(System.in);

				//Use a while(true) loop and only break the loop if the user wants to quit
				while(true) {
				
					//Get the user's move through user input
					System.out.print("What is your coin flip choice? Enter string heads or tails. To quit the game, enter quit: ");
					String playerChoice = input.nextLine();
					
					//Check if the user wants to quit the game
					if(playerChoice.equals("quit")) {
						break;
					}

					//Check if the user's move is valid (rock, paper, or scissors)
					if(!playerChoice.equals("heads") && !playerChoice.equals("tails")) {

						System.out.println("please enter a valid input!");
					
					} else {

						//Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2
						int rand = (int)(Math.random()*2);
						
						//Convert the random number to a string using conditionals and print the opponent's move
						String computerFlip = "";
						if(rand == 0) {
							computerFlip = "heads";
						} else if(rand == 1) {
							computerFlip = "tails";
						} 
						System.out.println("Opponent move: " + computerFlip);
							
						//Print the results of the game: tie, lose, win
						if(playerChoice.equals(computerFlip)) {
							System.out.println("You won");
							String objName = null;
							int score = 0;
							//add 10 points to player score for a win
							score += 10;
							Player obj = null;
							for (int i = 0; i < playerObjs.size(); i++)
								obj = playerObjs.get(i);
								if (obj.getName() == name) {
									int newScore = obj.getScore();
									int totalScore = score + newScore;
									obj.setScore(totalScore);
									
							}
						} else {
							System.out.println("You lost!");
						}

					}

				}

				//Print a final message for the user
				System.out.println("Thanks for playing Coin Toss");		
}
	
}

	
	


	
