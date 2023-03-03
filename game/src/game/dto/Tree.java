package game.dto;

public class Tree {

	private double treeHeight = 5.0; // 길이
	private double growthrate = 1.0; // 성장 비율
	
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

   
}