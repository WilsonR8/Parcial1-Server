package model;

public class Color {

	private int r;
	private int g;
	private int b;
	private String type = "Color";
	
	  public Color( int r, int g,int b) {
		  	super();
	        this.r=r;
	        this.g=g;
	        this.b=b;
	    }

	  public Color() {}
	  
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	  
	  
	
	
}
