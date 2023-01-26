import java.util.*;

public class job implements Comparable<job> {


public int state;
public double randomTimer;
public double timeOfNextMove;
public String name;

public void setState(int state) {
this.state = state;
}//setState

public void setName(String name) {

this.name = name;
	
}
	

	
public int getState () {
	return state;
}


public void setRandomTimer (double randomTimer) {
	this.randomTimer = randomTimer;
	
}

public double getRandomTimer () {
	
	return randomTimer;
	
}


public void setTimeOfNextMove(double timeOfNextMove) {
	
	this.timeOfNextMove = timeOfNextMove;
	
}

public double getTimeOfNextMove() {
	
	return timeOfNextMove;
	
}


public void advanceState() {
	
	if (state<5)
		state = state + 1;
	else
		state = 1;
	
}//advanceState - sends job to next state. If at 5, reset to 1.


@Override
    public int compareTo(job x)
    {
       if (this.timeOfNextMove < x.timeOfNextMove)
		   return -1;
	   if (this.timeOfNextMove > x.timeOfNextMove)
		   return 1;
	   else return 0;
	   
	   
	   
    }


public job () {
	
	setState(1);
	setRandomTimer(0);
	
}// empty constructor



}//class