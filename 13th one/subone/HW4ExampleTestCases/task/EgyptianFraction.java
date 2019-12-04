//Java program to print a fraction 
// in Egyptian Form using Greedy 
// Algorithm
 
import java.io.*; 
import java.lang.*; 
import java.util.*; 


class EgyptianFraction{ 

	public  int[] egyptianFraction(int nr, int dr) { 
		// If either numerator or 
		// denominator is 0 
		if (dr == 0 || nr == 0) {
			int a[]={}; 
			return a; 
		} 

	
		if (dr % nr == 0) { 

			int answer=dr/nr;
			int[] a={answer}; 
			return a;
		} 
		if (nr > dr) { 
         
			List<Integer> temp_list = new ArrayList<>();

			int answer=nr/dr;
			
			while(answer>0){
				
				temp_list.add(1);
				answer--;
			}
			int[] a = temp_list.stream().mapToInt(i -> i).toArray();
			int [] b=egyptianFraction(nr%dr,dr);
			int output[]=new int[a.length+b.length];
			for(int i=0;i<a.length;i++){
				output[i]=a[i];

			}
			for(int i=0;i<b.length;i++){
				output[i+a.length]=b[i];
				
				
			}
			
			return output; 
        } 
		
		
 

		// We reach here dr > nr and dr%nr 
		// is non-zero. Find ceiling of 
		// dr/nr and print it as first 
		// fraction 
		int n = dr/nr + 1; 
		

		// Recur for remaining part 
		int a[]=egyptianFraction(nr * n - dr, dr * n);
		int output[]=new int[a.length+1];
		for(int i=0;i<a.length;i++){
			output[i]=a[i];
		}
		output[a.length]=n;
		Arrays.sort(output);
		return output;


	} 


}
