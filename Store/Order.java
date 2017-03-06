package Store;

import java.util.Scanner;

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
			System.out.println("Please confirm:"); // buttons YES and NO for confirm - if yes - continue with the method
			Scanner sc = new Scanner(System.in);
			String temp = sc.nextLine();
			if(temp.equalsIgnoreCase("no")){
				System.out.println("Sorry that we can't produce your order");
				return;
			}
		}
		this.price = ((this.longSideTreatment*this.longSide+this.shortSideTreatment*this.shortSide)*this.getTreatmentPrice()/100)
				+(this.longSide*this.shortSide*1.1*this.mat.getPrice()/10000);
		
	}
	
	
	private int getTreatmentPrice(){
		int temp=0;
		int thick = this.mat.getThickness().getValue();
		double typeOfMaterial=0;
		switch (this.mat.getType()) {
		case Granite:
			typeOfMaterial=2;
			break;
		case Marble:
			typeOfMaterial=1.5;
			break;
		default:
			typeOfMaterial=1;
			break;
		}
		switch (this.type) {
		case Chamfer:
			temp = (int) (2*typeOfMaterial*thick);
			break;
		case Rounded:
			temp = (int) (4*typeOfMaterial*thick);
			break;
		default:
			break;
		}
		return temp;
	}


}
