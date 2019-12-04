//Java program to print a fraction 
// in Egyptian Form using Greedy 
// Algorithm 
import java.util.Scanner;

class EgyptianFraction{ 

	static void printEgyptian(int nr, int dr) { 
		// If either numerator or 
		// denominator is 0 
		if (dr == 0 || nr == 0) { 
			return; 
		} 

		// If numerator divides denominator, 
		// then simple division makes 
		// the fraction in 1/n form 
		if (nr % dr == 0) { 
			System.out.print(nr / dr); 
			return; 
		} 
		if (dr % nr == 0) { 
			System.out.print(dr / nr); 
			return; 
		} 

		// If denominator divides numerator, 
		// then the given number is not fraction 


		// If numerator is more than denominator 
		if (nr > dr) { 
			System.out.print(nr / dr + ","); 
			printEgyptian(nr % dr, dr); 
			return; 
		} 

		// We reach here dr > nr and dr%nr 
		// is non-zero. Find ceiling of 
		// dr/nr and print it as first 
		// fraction 
		int n = dr / nr + 1; 
		System.out.print( n + ","); 

		// Recur for remaining part 
		printEgyptian(nr * n - dr, dr * n); 
	} 

// Driver Code 
	public static void main(String[] args) { 
        Scanner NR = new Scanner(System.in);
      	int nr, dr;
      	nr = NR.nextInt();
      	dr = NR.nextInt();
		//int nr = 5, dr = 4; 
		printEgyptian(nr, dr); 
		NR.close(); 
	} 
}
