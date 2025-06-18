package com.skillstorm;

public class Encapsulation {

	public static void main(String[] args) {
		
		
		Animal animal1 = new Animal("Geoffrey","Giraffe",230.5,"Veggitarian");
		
		System.out.println(animal1);
		
		Animal animal2 = new Animal("Billy","Pitbull",24.5,"Dry Dog Food/Table Scraps");
		
		System.out.println(animal2);
		
		Player player1 = new Player("Jeff", "Shortstop", .440, 167);
		System.out.println(player1);
		
		
	}
}

//This is a class declaration. Use the "class" keyword then the name of the class in Pascal case. 

class Animal {
	//this is an instance property declaration.
	// now that we're in a class and not a method, we have to give it an access modifier.
	// We CAN initialize it here. If we don't, it gets the default value which is 0.0 for double.
	// Usually a constructor initializes the values.
	
	public String name;
	public String type;
	public double heightInInches;
	public String diet;
	
	// Java provides a default constructor if you don't make one. 
	
	// a custom constructor
	public Animal(String name, String type, double heightInInches,String diet) {
		//super ();		// this calls the superclass' constructor object. It's implied but useful later.
		this.name = name;
		this.type = type;
		this.heightInInches = heightInInches;
		this.diet = diet;
	}
	// Override the toString() method to provide a meaningful string representation
    @Override
    public String toString() {
        return "Animal [name=" + name + ", type=" + type + ", heightInInches=" + heightInInches + ", diet=" + diet + "]";
    }
}
	class Player {
		public String name;
		public String position;
		public double battingAverage;
		public int gamesPlayed;
		
		
	public Player(String name, String position, double battingAverage, int gamesPlayed) {
		this.name = name;
		this.position = position;
		this.battingAverage = battingAverage;
		this.gamesPlayed = gamesPlayed;
	}
	@Override
    public String toString() {
		String formattedBattingAverage = String.format("%.3f", battingAverage);
		if (formattedBattingAverage.startsWith("0.")) {
            formattedBattingAverage = formattedBattingAverage.substring(1); // Remove the leading '0'
        } else if (formattedBattingAverage.startsWith("-0.")) {
            formattedBattingAverage = "-" + formattedBattingAverage.substring(2); // Keep the '-' and remove '0'
        }


        return "Player [name=" + name + ", Position=" + position + ", Batting Average=" + formattedBattingAverage + ", Games Played=" + gamesPlayed + "]";
    }
}
