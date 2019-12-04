import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
// Math.pow(2,3);

class StringMatch{
    
    public static int[] CheckStringMatch(char[] text_arr,char[] fragment_arr){
        int fragment_arr_size=fragment_arr.length;
        final int prime_number=7;
        int text_arr_size=text_arr.length;
        int fragment_hash=0,temp_hash=0;
        List<Integer> output_list = new ArrayList<>();
        
        
        // finding hash value of fragement array

        for (int i=0;i<fragment_arr_size;i++){
            
            fragment_hash+=((int)fragment_arr[i])*Math.pow(prime_number,i);
        }

        // finding hash value of first number of fragment array size charactors in text array as temp_hash

        for (int i=0;i<fragment_arr_size;i++){

            temp_hash+=((int)text_arr[i])*Math.pow(prime_number,i);

        }

        // check this two hash are equals if it's equal then add to output array index 0  

        if(temp_hash==fragment_hash){
            int i=0;
            // if hash values are eqaul then compare each charactors in text array and fragment array 
            for(i=0;i<fragment_arr_size;i++){
                if(fragment_arr[i]!=text_arr[i]){
                    break;
                }
            }
            if(i==fragment_arr_size){
                System.out.println(0);
                output_list.add(0);
            }
        }
        // then check every possibilities
        for (int i=1;i<text_arr_size-fragment_arr_size+1;i++){
            
            temp_hash-=((int)text_arr[i-1]);
            temp_hash=temp_hash/prime_number;
            temp_hash+=((int)text_arr[i+fragment_arr_size-1])*Math.pow(prime_number,fragment_arr_size-1);
            if(temp_hash==fragment_hash){
                int j;
            // if hash values are eqaul then compare each charactors in text array and fragment array 
                for(j=0;j<fragment_arr_size;j++){
                    if(fragment_arr[j]!=text_arr[j+i]){
                        break;
                }
            }
            if(j==fragment_arr_size){
                output_list.add(i);
            }
                
            }


        }
        
        
        // int[] arr = new Integer[output_list.size()]; 
        int[] arr = output_list.stream().mapToInt(i -> i).toArray();

        return arr;
    }
    public static void main(String[] args){
        // System.out.println("Hello world");
        // char[] a={'i','t','k'};
        // System.out.println((int)a[0]);
        char[] text_arr = {'A','A','B','A','A','C','A','A','D','A','A','B','A','A','B','A'}; 
        char[] fragment_arr = {'A','A','B','A'};
        int  a[]=CheckStringMatch(text_arr,fragment_arr);
        System.out.print("{");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.println("}");
        
    } 
}