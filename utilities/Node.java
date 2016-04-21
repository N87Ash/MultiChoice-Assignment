package utilities;

public class Node {

	private Vector2i tile;
	private Node parent;
	private double fCost, gCost, hCost;
	
	public Node(Vector2i tile, Node parent, double gCost, double hCost){
		this.setTile(tile);
		this.setParent(parent);
		this.setgCost(gCost); //cost thus far
		this.sethCost(hCost); //distance to end
		this.fCost = this.gCost + this.hCost;
	}

	public Vector2i getTile() {
		return tile;
	}

	public void setTile(Vector2i tile) {
		this.tile = tile;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public double gethCost() {
		return hCost;
	}

	public void sethCost(double hCost) {
		this.hCost = hCost;
	}

	public double getfCost() {
		return fCost;
	}

	public void setfCost(double fCost) {
		this.fCost = fCost;
	}

	public double getgCost() {
		return gCost;
	}

	public void setgCost(double gCost) {
		this.gCost = gCost;
	}
}
