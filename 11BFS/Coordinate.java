import java.util.*;

public class Coordinate(){
    
    Coordinate prev = null;

    int x = 0;
    int y = 0;

    public Coordinate(){
	setX(0);
	setY(0);
    }

    public Coordinate(int _x, int _y){
	setX(_x);
	setY(_y);
    }

    public void setX(int _x){
	x = _x;
    }

    public void setY(int _y){
	y = _y;
    }

    public void setPrev(Coordinate p){
	prev = p;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y
    }

    public Coordinate getPrev(){
	return prev;
    }

    public static toString(){
	return "(" + getX() + ", " + getY() + ")";
    }

}