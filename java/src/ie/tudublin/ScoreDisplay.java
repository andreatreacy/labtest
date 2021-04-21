/*Labtest
Author: Andrea Treacy
Date: 21/04/2020
Compiler: Visual Studio Code*/ 

package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd"; 
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> notes = new ArrayList<Note>();

	Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;
	
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
		//Trying to add music
		minim = new Minim(this);
		/*NOT WORKING
        ap = minim.loadFile("data/Fáinne Geal an Lae on tin whistle.mp3", width);
        ab = ap.mix;*/
	
	}


	// create Note objects from the String and add them to the array list
	void loadScore()
    {
        for(int i=0; i<score.length(); i++)  // iterate over every character in string
        {
			// make sure the i+1 does not cause an array out of bounds error
			if(!(i==score.length()-1))
			{
				// if character after current character is 2 create note object with 2 as duration
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
				// if character after current character is not 2 and current is not 2 create note object with 1 as duration
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
		for(int i=0; i<notes.size(); i++)  // iterate over every character in string
        {
			Note n = notes.get(i);
			print(n.getNote() + "\t" + n.getDuration() + "\t");
			// print type of note
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
		stroke(0);
        float border = width * 0.1f;    // border 10%
		float bottomLine = (height / 2) + 50;	// 500 / 2 + 50 = 300
		float topLine = (height / 2) - 50;	// 500 / 2 - 50 = 200

		// draw 5 lines
		for(int i=0; i<=5; i++)
		{
			float x = map(i, 0, 5, topLine, bottomLine);
			line(border, x, width-border, x);
		}

		drawNotes();
	}

	void drawNotes()
	{
		float border = width * 0.1f;    // border 10%
		float bottomLine = (height / 2) + 50;	// 500 / 2 + 50 = 300
		float topLine = (height / 2) - 50;	// 500 / 2 - 50 = 200
		stroke(0);
		
		for(int i=0; i<notes.size(); i++)
		{
			fill(0);
			Note n = notes.get(i);
			char c = n.getNote(); // c holds the character
 			int num = c - '0'; // num holds the number
			float w = 20;

			// 0 to 8 is D to d
			float y = map(num, 0, 8, topLine, bottomLine);

			// make notes turn red when mouse is over it
			if(mouseX < border + (i * w) && mouseY < y && mouseY > y-20)
			{
				fill(255,0,0);	//red
			}

			ellipse(border + (i * w), y, w, w);	//draw circle
			line(border + (i * w)+5, y-40, border + (i * w)+5, y-5);	// draw line from circle

			// make a tick for the quavers
			if(n.getDuration()==2)
			{
				line(border + (i * w)+5, y-40, border + (i * w)+20, y-30);
			}

			// add text above each note
			text(n.getNote(), border + (i * w),height/4);
		}
	}
}
