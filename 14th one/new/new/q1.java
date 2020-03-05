import java.util.List;

class q1{
    public static Object[][] GeneratePowerSet(Object[] arr){
        int length=arr.length;
        int index=-1;
        Object curr=null;
        powerSet(str, index, curr);
    
        
    }
     
    static void powerSet(Object[] str, int index,Object curr)  
    { 
        int n = str.length; 
  
        // base case  
        if (index == n) 
        { 
            return; 
        } 
  
        // First print current subset  
        List<Object> temp_list = new ArrayList<>();
        temp_list.add(curr);
  
        // Try appending remaining characters  
        // to current subset  
        for (int i = index + 1; i < n; i++)  
        { 
            // curr += str.charAt(i); 
            
            powerSet(str, i, curr); 
  
            // Once all subsets beginning with  
            // initial "curr" are printed, remove  
            // last character to consider a different  
            // prefix of subsets.  
            curr = curr.substring(0, curr.length() - 1); 
        } 
    } 
  
    // Driver code  
    public static void main(String[] args)  
    { 
        String str = "abc"; 
        int index = -1; 
        String curr = ""; 
        powerSet(str, index, curr); 
    } 
}