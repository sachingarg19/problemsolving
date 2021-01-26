package com.jpmc;

public  class Rectangle{
    
    int x;
    int y;
    int width;
    int height;
    boolean a;
    
    
   public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle(){
        
    }
    
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    } 
}