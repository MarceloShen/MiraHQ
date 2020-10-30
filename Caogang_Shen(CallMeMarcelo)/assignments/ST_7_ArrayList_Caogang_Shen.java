import java.util.ArrayList;

public class ST_7_ArrayList_Caogang_Shen {
    public int range(ArrayList<Integer> ints) {
        if (ints == null || ints.size() == 0) {
            return 0;
        }
        int min = ints.get(0);
        int max = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i) > max) {
                max = ints.get(i);
            } else if (ints.get(i) < min) {
                min = ints.get(i);
            }
        }
        return max - min + 1;
    }
    
    public void removeShorterStrings(ArrayList<String> strings) {
        for (int i = 0; i < strings.size() - 1; i++) {
            String first = strings.get(i);
            String second = strings.get(i + 1);
            if (first.length() > second.length()) {
                strings.remove(second); 
            } else {
                strings.remove(first);
            }
        }
    }

    public void switchPairs(ArrayList<String> strings) {
        for (int i = 0; i < strings.size() - 1; i += 2) {
            String temp = strings.get(i);
            strings.set(i, strings.get(i + 1));
            strings.set(i + 1, temp);
        }
    }
    
    public void markLength4(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == 4) {
                strings.add(i, "****");
                i++;
            }
        }
    }
}
