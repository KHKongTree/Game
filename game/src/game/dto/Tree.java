package game.dto;

public class Tree {

	private String treeName; // 이름
	private double treeHeight; // 길이
	private double growthrate; // 성장 비율
   
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

   
}
