import java.util.Arrays;
import java.util.Random;

public class Tsum{

	public static void main(String[] args) {
		
		
		
		int arrSize = 200000000;
		int [] arrNumber = new int [arrSize];
		int min = 1, max = 10;
		
		Random random = new Random();
		
		
		int counter = 0;
		long startTime = System.nanoTime();
		
		
		while (counter < arrSize) {
			int randomNum = random.nextInt((max - min) + 1) + min;
			arrNumber[counter] = randomNum;
			counter++;
		}
		
		System.out.println("Multiple threads: (Array size of: " + arrSize + ")");
		int startRange = 0;
		int endRange = 20000000;
		int currentSum = 0;
		
		for (int i = 0; i < arrSize; i+=20000000) {
			
			int [] tempArray = Arrays.copyOfRange(arrNumber, startRange,endRange);
			
			
			SumThread t1 = new SumThread(tempArray);
			t1.start();
			currentSum += t1.getSum();
			
			startRange += 20000000 + 1;
			endRange += 20000000;
		}
		
		
		
		System.out.println(currentSum);
		

		
		
		long endTime = System.nanoTime();
		System.out.println("Total time: " + (endTime - startTime) + " milliseconds.");

	}

}
