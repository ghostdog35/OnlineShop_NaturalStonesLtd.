package Store;

public class Order {
	
	enum Treatment{
		Chamfer, Rounded,
	}
	
	private int longSide;
	private int shortSide;
	private int quantity; // number of identical pieces - can be 1 or more 
	private Materials mat;
	private int longSideTreatment;  // possible values 0,1 or 2 - tells on which side will there be a treatment
	private int shortSideTreatment; // possible values 0,1 or 2 - tells on which side will there be a treatment
	Treatment type;
	private double price;
	public Order(int longSide, int shortSide, int quantity, Materials mat, int longSideTreatment,
			int shortSideTreatment, Treatment type) {
		this.longSide = longSide;
		this.shortSide = shortSide;
		this.quantity = quantity;
		this.mat = mat;
		this.longSideTreatment = longSideTreatment;
		this.shortSideTreatment = shortSideTreatment;
		this.type = type;
	}
	
	public void calcPrice(){
		double sqMeters= this.longSide*this.shortSide*this.quantity/10000;
		if(this.longSide<this.shortSide){
			int temp = this.longSide;
			this.longSide=this.shortSide;
			this.shortSide=temp;
		}
		
		if(sqMeters>Store.getQuantity(this.mat)){
			System.out.println("Not enough materials to produce your order. Please contact our salesmans on the folowing numbers...for further information");
			return;
		}
		if(this.longSide>mat.getLongSide()){
			System.out.println("Your piece is bigger than our slabs - so it will be produced from more than one piece");
			System.out.println("Please confirm:"); // button yes or no for confirm - if yes - continue with the method
		}
		
		
		
		
	}
	
	
	


}
