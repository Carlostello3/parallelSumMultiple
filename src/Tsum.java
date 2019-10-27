/**
 * @author carlostello
 */
import java.util.Arrays;
import java.util.Random;

public class Tsum{

	public static void main(String[] args) {
		
		
		//Variables
		int arrSize = 200000000, sum = 0;
		int [] arrNumber = new int [arrSize];
		int min = 1, max = 10;
		
		Random random = new Random();
		
		
		
		
		
		//Array population
		for (int i = 0; i < arrSize; i++) {
			arrNumber[i] = random.nextInt((max - min) + 1) + min;
		}
		
		
		//Single Thread
		long startTime1 = System.nanoTime();
		for (int i = 0; i < arrNumber.length; i++) {
			sum += arrNumber[i];
		}
		long endTime1 = System.nanoTime();
		
		
		
		
		
		
		long startTime2 = System.nanoTime();
		int startRange = 0;
		int endRange = 19999999;
		int currentSum = 0;
		
		//Multi thread
		for (int i = 0; i < arrSize; i+=20000000) {
			
			if (endRange < 200000000) {
				
				int [] tempArray = Arrays.copyOfRange(arrNumber, startRange,endRange);
				
				
				for(int x = 0; x < 9; x++) {
					SumThread t1 = new SumThread(tempArray);
					t1.start();
					currentSum += t1.getSum();
				
				
				startRange += 20000000;
				endRange += 20000000;
				}
			}
			
		}
		
		
		
		long endTime2 = System.nanoTime();
		long totalTime1 = endTime1 - startTime1;
		long totalTime2 = endTime2 - startTime2;
		
		//Print out results
		System.out.println("Single thread: (Array size of: " + arrSize + ") - Total Sum: " + sum + " - Total Time: " + totalTime1 + " milliseconds. \n");
		System.out.println("Multiple threads: (Array size of: " + arrSize + ") - Total Sum: " + currentSum + " - Total Time: " + totalTime2 + " milliseconds. \n");
		

		if (totalTime1 < totalTime2) {
			System.out.println("Single Thread is faster");
		} else {
			System.out.println("Multi-thread is faster");
		}
		
		
		

	}

}
