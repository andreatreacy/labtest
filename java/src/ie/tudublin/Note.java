package ie.tudublin;

import processing.core.PApplet;

public class Note {
    private char note;
    private int duration;

    // default constructor
    public Note()
    {
        
    }

    // default constructor
    public Note(char note, int duration)        
    {
        this.note = note;
        this.duration = duration;
    }

    

    public char getNote() {
        return note;
    }



    public void setNote(char note) {
        this.note = note;
    }



    public int getDuration() {
        return duration;
    }



    public void setDuration(int duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + "]";
    }

    
}