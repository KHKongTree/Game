package game.service;

import game.dto.Item;
import game.dto.UserState;
import game.image.GameUI;
import game.view.action.TreeCare;

public class Service {

	public UserState meAndTree = new UserState();
	public Item item = new Item();
	public TreeCare care = new TreeCare();
	public GameUI ui = new GameUI();
	
	public GameUI getUi() {
		return ui;
	}
	public void setUi(GameUI ui) {
		this.ui = ui;
	}
	public UserState getMeAndTree() {
		return meAndTree;
	}
	public void setMeAndTree(UserState meAndTree) {
		this.meAndTree = meAndTree;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public TreeCare getCare() {
		return care;
	}
	public void setCare(TreeCare care) {
		this.care = care;
	}

	
}
