package project1;

import java.util.Scanner;

//class for VIP player i.e player with highest points
public class VIP extends Player{
	private String VIPname;
	
	public VIP(){
		VIPname = "(VIP)";
	} 
	
	public VIP(String name, int score, String VIPname) {
		super(name, score);
		this.VIPname = VIPname;
	}

	public String getVIPname() {
		return VIPname;
	}

	public void setVIPname(String VIPname) {
		this.VIPname = VIPname;
	}
	
}