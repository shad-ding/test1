import java.util.*;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 0;
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println(calculating(i + 1));
		}
		
		in.close();
	}
	
	static int calculating(int n){
		if(n == 1 || n == 2)
			return 1;
		else {
			return calculating(n - 1) + calculating(n - 2);
		}
	}
}
