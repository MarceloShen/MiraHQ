import java.util.*;

public class ST_P7_ArrayList_Eashver_Elango {
    public static int range(ArrayList<Integer> list){
        // Check for nulls
        if (list == null || list.size() == 0) {
            return 0;
        }
        // Set initial values for checking max and min
        int max = list.get(0);
        int min = list.get(0);
        for(int i : list){
            //Check which is max
            max = Math.max(max, i);
            //Check which is min
            min = Math.min(min, i);
        }
        // return the range
        return max-min+1;
    }
    public static void removeShorterStrings(ArrayList<String> list){
        // For each pair of values
        for(int i=0;i<list.size()-1;i++){
            //Get the values of the pairs
            String first = list.get(i);
            String second = list.get(i+1);
            //Either remove the second value
            if(first.length() > second.length()){
                list.remove(second);
            } else { // or the first value
                list.remove(first);
            }
        }

        //no return because list is a value not reference
    }
    public static void switchPairs(ArrayList<String> list){
        // for each pair
        for(int i=0;i<list.size()-1;i+=2){
            // create temp variable
            String temp = list.get(i);
            // Do first swap
            list.set(i, list.get(i+1));
            // Complete the swap with temp
            list.set(i+1, temp);
        }

        //no return because list is a value not reference
    }
    public static void markLength4(ArrayList<String> list){
        // For each value
        for(int i=0;i<list.size();i++){
            // get the string 
            String value = list.get(i);
            // if it's of length 4
            if(value.length() == 4){
                // add the asterisks
                list.add(i, "****");
                // according move the for loop pointer forward due to index addition
                i += 1;
            }
        }

        //no return because list is a value not reference
    }
}