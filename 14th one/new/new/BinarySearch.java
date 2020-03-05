import java.util.Arrays;


public class BinarySearch{
    public static int FindIndex(int[] arr, int x){
        int length=arr.length;
        if(arr==null){
            return null;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int result1= binarySearch(arr,0,i,x);
                int result2=binarySearch(arr,i+1,length-1,x);
                if(result1>result2){
                    return result1;
                }else if(result1<result2){
                    return result2;
                }else{
                    return -1;
                }
            }
        }
    }
    public static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
    public static void main(String[] args){
        int [] arr={3, 17, 28, 935, 1011, -10, 0};
        int result=FindIndex(arr,1011);
        System.out.println(result);
    }
}