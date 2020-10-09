package main;


import processing.core.PApplet;

public class Main extends PApplet {

	private TCPSingleton tcp;
	String name;
	int X=250;
	int Y=250;

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		   tcp = TCPSingleton.getInstance();
	        tcp.setObserver(this);
	}



	public void draw() {
		background(0);

		
		if(name == null) {
			//no hacer nada hasta que se escriba el nombre de avatar
		}else {
		ellipse(X,Y, 50, 50);
		fill(255);
		text(name, 50, 50);
		
	}
	}
	
	
	
	public void setName(String msg) {
		name=msg;
	}
		
	public void setCoord(int posx, int posy) {
	X=posx;
	Y=posy;
}
}
