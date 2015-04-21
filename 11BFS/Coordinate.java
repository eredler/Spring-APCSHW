import java.util.*;
import java.io.*;

public class Coordinate {
    
    Coordinate prev = null;

    private int steps = 0;

    private int x = 0;
    private int y = 0;

    public Coordinate(){
	setX(0);
	setY(0);
    }

    public Coordinate(int _x, int _y){
	setX(_x);
	setY(_y);
    }

    public Coordinate(int _x, int _y, int s){
	setX(_x);
	setY(_y);
	setSteps(s);
    }

    public void setX(int _x){
	x = _x;
    }

    public void setY(int _y){
	y = _y;
    }

    public void setSteps(int s){
	steps = s;
    }

    public void setPrev(Coordinate p){
	prev = p;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int getSteps(){
	return steps;
    }

    public Coordinate getPrev(){
	return prev;
    }

    public String toString(){
	return "(" + getX() + ", " + getY() + ")";
    }

}
