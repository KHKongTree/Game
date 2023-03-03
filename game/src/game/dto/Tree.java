package game.dto;


public class Tree {
	
	private double treeHeight = 5.0; // 길이
	private double growthrate = 1.0; // 성장 비율
	private double water; //물주기
	

   public Tree() {
   }
   
	public Tree(double treeHeight, double growthrate, double water) {
	super();

	this.treeHeight = treeHeight;
	this.growthrate = growthrate;
	this.water = water;
}

	

	public double getTreeHeight() {
		return treeHeight;
	}
	public void setTreeHeight(double treeHeight) {
		this.treeHeight = treeHeight;
	}
	public double getGrowthrate() {
		return growthrate;
	}
	public void setGrowthrate(double growthrate) {
		this.growthrate = growthrate;
	}
	public double getWater() {
		return water;
	}
	public void setWater(double water) {
		this.water = water;
	}


}