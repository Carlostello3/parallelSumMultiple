
public class SumThread extends Thread implements Runnable{

	private int sum;
	private int [] arrNumber;
	
	public SumThread(int [] arraySum) {
		
		this.arrNumber = arraySum;
		
		
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
	
	
}
