
public class SumThread extends Thread implements Runnable{

	public SumThread(int [] arraySum) {
		
		arrNumber = arraySum;
		
		
	}
	
	public void run() {
		
		getSum();
	}
	
	
	public int getSum() {
		for (int i = 0; i < arrNumber.length; i++) {
			sum += arrNumber[i];
		}
		return sum;
	}
	
	private int sum;
	private int [] arrNumber;
}
