package utilities;

public class Vector2i {
	
	private int x;
	private int y;
	
	public Vector2i(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public boolean isEqual(Vector2i vec){
		if ((this.x == vec.getX()) && (this.y == vec.getY())){
			return true;
		}
		return false;
	}
}
