import java.util.*;

public class Coordinate(){
    
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

    public int getX(){
	return x;
    }

    public int getY(){
	return y
    }

    public static toString(){
	return "(" + getX() + ", " + getY() + ")";
    }

}