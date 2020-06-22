public class Fibonacci {
	public static void main(String[] args) {
		for(int i = 0; i < 200; i++) {
			System.out.println(Fibonacci.of(i + 1));
		}
		
	}
	
	static int of(int n){
		if(n == 1 || n == 2)
			return 1;
		else {
			return of(n - 1) + of(n - 2);
		}
	}
}
