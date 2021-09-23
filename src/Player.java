package project1;

import java.util.Scanner;


public class Player implements Comparable{
    public String name;
    public int score = 0;
    
    public Player(){} 
    
    public Player(String name, int score) {
		this.name = name;
		this.score = score;

	}
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    //sorts players obj array based on scores and then alphabetically
    @Override
    public int compareTo(Object arg0) {
        Player p = (Player)arg0;
        return p.getScore() - this.getScore();
    }
    
    @Override
	public String toString() {
		return name + "\n" + score +"\n";
	}


}



