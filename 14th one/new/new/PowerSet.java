import java.util.ArrayList; 
  
public class PowerSet{ 
  
    public static void main(String[] args) 
    { 
  
        Object[] my_arr = {-2,7,10,23,19};
        Object[][] pSet = GeneratePowerSet(my_arr);
        for(int i=0; i<pSet.length; i++) {
            System.out.print("{");
            for(int j=0; j<pSet[i].length; j++) {
            System.out.print(pSet[i][j]);
            if(j+1 < pSet[i].length)
            System.out.print(", ");
            }
            System.out.println("}");
            }
         
    } 
    public static Object[][] GeneratePowerSet(Object[] arr){

        int index=arr.length - 1;
        if(arr==null){
            System.out.println("Error");
            return null;
        }
        // removing duplicates

        ArrayList<Object> numbersList = new ArrayList<>(Arrays.asList(arr));
         
        // System.out.println(numbersList);
 
        LinkedHashSet<Object> hashSet = new LinkedHashSet<>(numbersList);
         
        ArrayList<Object> listWithoutDuplicates = new ArrayList<>(hashSet);
         
        // System.out.println(listWithoutDuplicates);
        Object [] input=listWithoutDuplicates.toArray();

        
        ArrayList<ArrayList<Object> > result = getSubset(input,index);
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
} 