import java.util.ArrayList;

public class ST_P7_ArrayList_Ashley_Mead {

    public static int range(ArrayList<Integer> list) {
        if(list.size() == 0 || list == null) {
            return 0;
        }
        
        int max = list.get(0);
        int min = list.get(0);
        
        for(int num : list) {
            if(num > max) {
                max = num;
            }
            else if(num < min) {
                min = num;
            }
        }

        return max - min + 1;
    }

    public static void removeShorterStrings(ArrayList<String> list) {
    
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).length() <= list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            
        }
    }

    public static void switchPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String second = list.get(i+1);
            list.add(i, second);
            list.remove(i + 2);
        }
    }

    public static void markLength4(ArrayList<String> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }                                                                                                                                         
        }
    }

}