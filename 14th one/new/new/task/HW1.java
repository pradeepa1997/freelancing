import java.util.ArrayList; 

public class HW1{
    public static Object[][] GeneratePowerSet(Object[] arr){

		int index=arr.length - 1;
		if(arr==null){
			System.out.println("Error");
			return null;
		}   
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return null;
			}
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]==null){
					return null;
				}
				if(arr[i]==arr[j]){
					return null;
				}
			}
		}
		ArrayList<ArrayList<Object> > result = getSubset(arr, index);
		int length=result.size(); 
		Object resultarr[][]=new Object[length][];
	
		for(int i=0;i<length;i++){
	
			Object[] temp=result.get(i).toArray();
			// System.out.println(temp+"x");
			resultarr[i]=temp;
	
		}
		return resultarr;
		
	}
	static ArrayList<ArrayList<Object> > getSubset(Object[] set, int index){ 
		
		ArrayList<ArrayList<Object> > allSubsets; 
		if (index < 0){ 
			allSubsets = new ArrayList<ArrayList<Object> >(); 
			allSubsets.add(new ArrayList<Object>()); 
		} 
	
		else{ 
			allSubsets = getSubset(set, index - 1); 
			Object item = set[index]; 
			ArrayList<ArrayList<Object> > moreSubsets  
				= new ArrayList<ArrayList<Object> >(); 
	
			for (ArrayList<Object> subset : allSubsets) { 
				ArrayList<Object> newSubset = new ArrayList<Object>(); 
				newSubset.addAll(subset); 
				newSubset.add(item); 
				moreSubsets.add(newSubset); 
			} 
			allSubsets.addAll(moreSubsets); 
		} 
		return allSubsets; 
    } 
    public static int FindIndex(int[] arr, int x){
        int length=arr.length;
        
		if(length==0){
			return -1;
		}
		// special case for length 2 array
		if(length==2){
			if(arr[0]==x){
				return 0;
			}else if(arr[1]==x){
				return 1;
			}else{
				return -1;
			}
		}
		return binarySearch(arr,0,length-1,x);
	}
	public static int binarySearch(int[] arr,int start,int end,int x){
		if(start>end){
			return -1;
		}
		int mid=start+((end-start)/2);
		if(arr[start]<x){
			if(x<arr[mid]){
					return binarySearch(arr, start,mid-1, x);
			}else if(x>arr[mid]){
				if(arr[mid]<arr[start]){
					return binarySearch(arr,start, mid-1, x);
				}else{
					return binarySearch(arr, mid+1, end, x);
				}
				
			}else{
				return mid;
			}
		}else if(arr[start]>x){
			if(x>arr[mid]){
				return binarySearch(arr,mid+1,end,x);
			}else if(x<arr[mid]){
				if(arr[mid]>arr[start]){
					return binarySearch(arr, mid+1,end,x);
				}else{
					return binarySearch(arr, start,mid-1,x);
				}
				
			}else{
				return mid;
			}
		}else{
			return start;
		}
	}
    
}