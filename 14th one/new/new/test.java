import java.util.ArrayList;

public class test{
    public static void main(String[] args) 
    { 
  
        String[] set = { "a", "b", "c" }; 
  
        int index = set.length - 1; 
        ArrayList<ArrayList<String> > result = getSubset(set, index); 
        System.out.println(result); 
    } 
  
    static ArrayList<ArrayList<String> > getSubset(String[] set, int index) 
    { 
        ArrayList<ArrayList<String> > allSubsets; 
        if (index < 0) { 
            allSubsets = new ArrayList<ArrayList<String> >(); 
            allSubsets.add(new ArrayList<String>()); 
        } 
  
        else { 
            allSubsets = getSubset(set, index - 1); 
            String item = set[index]; 
            ArrayList<ArrayList<String> > moreSubsets  
                = new ArrayList<ArrayList<String> >(); 
  
            for (ArrayList<String> subset : allSubsets) { 
                ArrayList<String> newSubset = new ArrayList<String>(); 
                newSubset.addAll(subset); 
                newSubset.add(item); 
                moreSubsets.add(newSubset); 
            } 
            allSubsets.addAll(moreSubsets); 
        } 
        return allSubsets; 
    } 
}