package edu.centrale.monopoly;

public abstract class Case {
    
    private int id;

    public Case(int id) {
        this.id = id;
    }
    
    public Case(){
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
