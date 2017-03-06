package Store;

public abstract class Materials {
	
	enum Type {
		Limestone, Travertine, Marble, Granite
	}
	enum Thickness{
		One(1), Two(2), Three(3), Four(4), Six(6), Eight(8), Ten(10);
		private int value;
		Thickness(int val){
			this.value=val;
		}
		public int getValue(){
			return value;
		}
	}
	enum Color{
		White, Beige, Yellow, Grey, DarkGrey, Red, Green, Blue, Brown, Black
	}
	
	private String name;
	private Type type;
	private Color color;
	private Thickness thickness;
	private int longSide; // Measures always in cm.
	private int shortSide; // Measures always in cm.
	private double price;
	
	public Materials(String name, Type type, Color color, Thickness thickness, int longSide, int shortSide, double price) {
		this.name = name;
		this.type = type;
		this.color = color;
		this.thickness = thickness;
		this.longSide = longSide;
		this.shortSide = shortSide;
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}

	public Thickness getThickness() {
		return thickness;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public int getLongSide() {
		return longSide;
	}

	public int getShortSide() {
		return shortSide;
	}
	
	
	
	
	
	

}
