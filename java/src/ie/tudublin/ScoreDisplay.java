package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> notes = new ArrayList<Note>();
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
		printNotes();
	}


	void loadScore()
    {
        for(int i=0; i<score.length(); i++)  // iterate over every character in string
        {
			if(!(i==score.length()-1))
			{
				// if character after current character is 2 create note object wuth 2 as duration
				if(score.charAt(i+1) =='2')
				{
					Note n = new Note(score.charAt(i),2); // make a note object
					notes.add(n);   // add new note to the array list
				}
				// if character is 2 do nothing
				else if(score.charAt(i) =='2')
				{
					continue;
				}
				// if character after current character is not 2 and current is not 2 create note object wuth 1 as duration
				else
				{
					Note n = new Note(score.charAt(i),1); // make a note object
					notes.add(n);   // add new note to the array list
				}
			}
        }
    }



	// print all notes
	void printNotes()
	{
		// iterate over stars
		for(Note n: notes)
		{
			println(n); // will access the toString method in the Note class
		}

		for(int i=0; i<notes.size(); i++)  // iterate over every character in string
        {
			Note n = notes.get(i);
			print(n.getNote() + "\t" + n.getDuration() + "\t");
			if(n.getDuration()==1)
			{
				print("Quaver");
			}
			else
			{
				print("Crotchet");
			}
			println("");
        }


	}


	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
