package snake;

public class Punto {
	//*************attributi*******************************************
	private int x;
	private int y;
	public static int xmin = 0;
	public static int xMax = 100;
	public static int ymin = 0;
	public static int yMax = 100;
	
	
	//*************metodi get e set************************************
	/**
	 * 
	 * @return Ritorna il valore dell'ascissa
	 */
	public int getX() {
		return x;
	}
	/**
	 * inizializza x con un valore passato a parametro, se il valore passato esce dal range, verrà settato a -1
	 * @param x : valore che si tenta di inserire come ascissa (x)
	 */
	public void setX(int x) {
		if(x >= xmin && x <= xMax-Body.uni)
			this.x = x;
		else
			this.x = -1;
		
		/*
		if(x < xmin)
			this.x = xMax-Body.uni;
		else if (x >= xMax-Body.uni)
			this.x = 0;
		else
			this.x = x;
		 */
	}
	/**
	 * 
	 * @return Ritorna il valore dell'ordinata
	 */
	public int getY() {
		return y;
	}
	/**
	 * inizializza y con un valore passato a parametro, se il valore passato esce dal range, verrà settato a -1
	 * @param y : valore che si tenta di inserire come ordinata (y)
	 */
	public void setY(int y) {
		if(y >= ymin && y <= yMax-Body.uni)
			this.y = y;
		else{
			this.y = -1;
		}
	}
	
	public int getX(int unita){
		return (int) (unita*(xMax+x));
	}
	public int getY(int unita){
		return (int) (unita*(yMax-y));
	}
	public int getX(int unita, int maxPixel){
		return (int) ((unita*x)+(maxPixel/2));
	}
	public int getY(int unita, int maxPixel){
		return (int) ((maxPixel/2)-(unita*y));
	}

	//*************metodi costruttori**********************************
	
	/**
	 * Costruttore di default che assegna il punto (0, 0)
	 */
 	public Punto(){
		this.x = 0;
		this.y = 0;
	}
	public Punto(Punto p){
		x = p.x;
		y = p.y;
	}
	public Punto (int x, int y){
		setX(x);
		setY(y);
	}
	
	
	//*************metodi**********************************************
	/**
	 * stampa a finestra le coordinate del punto nell'annotazione: P(X, Y=)
	 */
	public void visualizza(){
		System.out.println("P(" + this.x + ", " + this.y + ")");
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	/**
	 * calcola le nuove coordinate del punto dopo averlo spostato
	 * @param deltaX
	 * @param deltaY
	 */
	public void trasla(int deltaX, int deltaY){
		this.x += deltaX;
		this.y += deltaY;
	}
	
	public double distanza(Punto p2){
		double d;
		double deltaX, deltaY;
		deltaX = x - p2.getX();
		deltaY = y - p2.getY();
		
		d = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
		
		return d;
	}
	public double distanza(double x, double y){
		return Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));
	}
	
	public Punto puntoMedio(Punto p){
		return new Punto((x+p.x)/2, (y+p.y)/2);
	}
	
	public Punto somma(Punto p){
		return new Punto(x+p.x, y+p.y);
	}
	
	public boolean equals(Punto p){
		return x == p.x && y == p.y;
	}

	
		
}
