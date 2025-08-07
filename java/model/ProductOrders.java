package model;

import java.io.Serializable;

public class ProductOrders implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int aChoy;
	private int carrot;
	private int chineseCelery;
	private int daikonRadish;
	private int onion;
	private int spoonCabbage;
	private int sugarSnapPea;
	private int waterSpinach;
	private int welshOnion;
	
	public ProductOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductOrders(String name, int aChoy, int carrot, int chineseCelery, int daikonRadish, int onion,
						int spoonCabbage, int sugarSnapPea, int waterSpinach, int welshOnion) {
		super();
		this.name = name;
		this.aChoy = aChoy;
		this.carrot = carrot;
		this.chineseCelery = chineseCelery;
		this.daikonRadish = daikonRadish;
		this.onion = onion;
		this.spoonCabbage = spoonCabbage;
		this.sugarSnapPea = sugarSnapPea;
		this.waterSpinach = waterSpinach;
		this.welshOnion = welshOnion;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getaChoy() {
		return aChoy;
	}

	public void setaChoy(int aChoy) {
		this.aChoy = aChoy;
	}

	public int getCarrot() {
		return carrot;
	}

	public void setCarrot(int carrot) {
		this.carrot = carrot;
	}

	public int getChineseCelery() {
		return chineseCelery;
	}

	public void setChineseCelery(int chineseCelery) {
		this.chineseCelery = chineseCelery;
	}

	public int getDaikonRadish() {
		return daikonRadish;
	}

	public void setDaikonRadish(int daikonRadish) {
		this.daikonRadish = daikonRadish;
	}

	public int getOnion() {
		return onion;
	}

	public void setOnion(int onion) {
		this.onion = onion;
	}

	public int getSpoonCabbage() {
		return spoonCabbage;
	}

	public void setSpoonCabbage(int spoonCabbage) {
		this.spoonCabbage = spoonCabbage;
	}

	public int getSugarSnapPea() {
		return sugarSnapPea;
	}

	public void setSugarSnapPea(int sugarSnapPea) {
		this.sugarSnapPea = sugarSnapPea;
	}

	public int getWaterSpinach() {
		return waterSpinach;
	}

	public void setWaterSpinach(int waterSpinach) {
		this.waterSpinach = waterSpinach;
	}

	public int getWelshOnion() {
		return welshOnion;
	}

	public void setWelshOnion(int welshOnion) {
		this.welshOnion = welshOnion;
	}
}
