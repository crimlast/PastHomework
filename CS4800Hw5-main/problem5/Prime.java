package problem5;

public class Prime {
	
	public boolean isPrime(int i){
		if (i <= 1) {
			return false;
		}
		
		int k = 2;
		while(k != i) {
			if (i%k == 0) {
				return false;
			}
			k = k+1;
		}
		
		return true;
	}

	
}
