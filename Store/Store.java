package Store;

import java.util.ArrayList;
import java.util.HashMap;

import Store.Materials.Color;
import Store.Materials.Thickness;
import Store.Materials.Type;

public class Store {
	
	
	private static HashMap<Type,HashMap<Thickness,HashMap<Color,ArrayList<Materials>>>> catalouge;
	private double money;
	
	public Store() {
		this.money=0;
		this.catalouge = new HashMap();
	}
	
	public boolean addMaterial(Materials mat){
		if(mat==null){
			return false;
		}
		if(!this.catalouge.containsKey(mat.getType())){
			this.catalouge.put(mat.getType(), new HashMap<>());
		}
		if(!this.catalouge.get(mat.getType()).containsKey(mat.getThickness())){
			this.catalouge.get(mat.getType()).put(mat.getThickness(), new HashMap<>());
		}
		if(!this.catalouge.get(mat.getType()).get(mat.getThickness()).containsKey(mat.getColor())){
			this.catalouge.get(mat.getType()).get(mat.getThickness()).put(mat.getColor(), new ArrayList<>());
		}
		this.catalouge.get(mat.getType()).get(mat.getThickness()).get(mat.getColor()).add(mat);
		return true;
	}
	
	public boolean removeMaterial(Materials mat){
		if(mat==null){
			return false;
		}
		this.catalouge.get(mat.getType()).get(mat.getThickness()).get(mat.getColor()).remove(mat);
		return true;
	}	
	
	public static double getQuantity(Materials mat){
		double sum=0;
		for (Materials m : catalouge.get(mat.getType()).get(mat.getThickness()).get(mat.getColor())) {
			if(m.getName().equals(mat.getName())){
				sum+=m.getLongSide()*m.getShortSide()/10000;
			}
		}
		return sum;
	}
	

}
