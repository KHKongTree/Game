package game.dto;

public class Tree {

	private String treeName; // 이름
	private double treeHeight = 0.0; // 길이
	private double growthrate; // 성장 비율
	private double water; //물주기
	
   public Tree() {
   }
   
   
	
	
	public Tree(String treeName, double treeHeight, double growthrate, double water) {
	super();
	this.treeName = treeName;
	this.treeHeight = treeHeight;
	this.growthrate = growthrate;
	this.water = water;
}




	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
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