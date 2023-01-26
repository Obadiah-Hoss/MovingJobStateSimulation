import java.lang.Math;   
import java.util.Arrays;

public class jobSimulation {




public static void printStatus(double t, job j1, job j2, job j3, job j4, job j5) {

job printSortedJobs[] = new job[5];
printSortedJobs[0]=j1;
printSortedJobs[1]=j2;
printSortedJobs[2]=j3;
printSortedJobs[3]=j4;
printSortedJobs[4]=j5;
Arrays.sort(printSortedJobs);
	
System.out.println();
System.out.println("timer = " + t);
System.out.println("job " +printSortedJobs[0].name + " state: " + printSortedJobs[0].getState() +" and moves at timer = " + printSortedJobs[0].getTimeOfNextMove());
System.out.println("job " +printSortedJobs[1].name + " state: " + printSortedJobs[1].getState() +" and moves at timer = " + printSortedJobs[1].getTimeOfNextMove());
System.out.println("job " +printSortedJobs[2].name + " state: " + printSortedJobs[2].getState() +" and moves at timer = " + printSortedJobs[2].getTimeOfNextMove());
System.out.println("job " +printSortedJobs[3].name + " state: " + printSortedJobs[3].getState() +" and moves at timer = " + printSortedJobs[3].getTimeOfNextMove());
System.out.println("job " +printSortedJobs[4].name + " state: " + printSortedJobs[4].getState() +" and moves at timer = " + printSortedJobs[4].getTimeOfNextMove());
}//printStatus





public static void main (String args[]) {

double timer=0;
double currentCheckpoint = 500;
job jobArray[] = new job[5];
int counter = 0;


//variables needed for a properly working timer and RNG system


job one = new job();
job two = new job();
job three = new job();
job four = new job();
job five = new job();
	
one.setName("one");
two.setName("two");
three.setName("three");
four.setName("four");
five.setName("five");
	
jobArray[0] = one;
jobArray[1] = two;
jobArray[2] = three;
jobArray[3] = four;
jobArray[4] = five;


one.setRandomTimer(Math.random() * 100);
two.setRandomTimer(Math.random() * 100);
three.setRandomTimer(Math.random() * 100);
four.setRandomTimer(Math.random() * 100);
five.setRandomTimer(Math.random() * 100);

one.setTimeOfNextMove(one.getRandomTimer());
two.setTimeOfNextMove(two.getRandomTimer());
three.setTimeOfNextMove(three.getRandomTimer());
four.setTimeOfNextMove(four.getRandomTimer());
five.setTimeOfNextMove(five.getRandomTimer());



System.out.println();
System.out.println("Start of program, here is the state of all jobs:");
System.out.println("Note: program will output first 15 clock changes then will output every 500 time units");
printStatus(timer, one, two, three, four, five);






//first 15 clock changes
for (int i=0; i<15; i++) {
		
Arrays.sort(jobArray);
timer = jobArray[0].getTimeOfNextMove();
jobArray[0].advanceState();

//this needs to be implemented in case two jobs will advance at the same time
for (int j=1; j<5; j++) {
	
	if (jobArray[j].getTimeOfNextMove() == jobArray[0].getTimeOfNextMove()) {
		jobArray[j].advanceState();
		jobArray[j].setRandomTimer(Math.random() * 100);
		jobArray[j].setTimeOfNextMove(jobArray[j].getRandomTimer() + timer);
	}

}//for


jobArray[0].setRandomTimer(Math.random() * 100);
jobArray[0].setTimeOfNextMove(jobArray[0].getRandomTimer() + timer);
printStatus(timer, one, two, three, four, five);
	
}//for









while (currentCheckpoint<10500){
	
Arrays.sort(jobArray);
timer = jobArray[0].getTimeOfNextMove();
jobArray[0].advanceState();

//this needs to be implemented in case two jobs will advance at the same time
for (int j=1; j<5; j++) {
	
	if (jobArray[j].getTimeOfNextMove() == jobArray[0].getTimeOfNextMove()) {
		jobArray[j].advanceState();
		jobArray[j].setRandomTimer(Math.random() * 100);
		jobArray[j].setTimeOfNextMove(jobArray[j].getRandomTimer() + timer);
	}

}//for




jobArray[0].setRandomTimer(Math.random() * 100);
jobArray[0].setTimeOfNextMove(jobArray[0].getRandomTimer() + timer);


if (timer>=currentCheckpoint) {
	printStatus(timer, one, two, three, four, five);
	currentCheckpoint = currentCheckpoint + 500;
	
}//if
	
}//while



}//main

}//class