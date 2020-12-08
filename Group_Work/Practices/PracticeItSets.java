import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PracticeItSets {


    // countUnique
    /**
     * Outputs how many unique integers are in the list
     * @param list list of integers
     * @return number of unique integer values in the list
     */
    public int countUnique(List<Integer> list) {   
        Set<Integer> set = new HashSet<Integer>(list);
        return set.size();
    }
    /* mapMystery1
    {two=deux, five=cinq, one=un, three=trois, four=quatre} returns {cinq=five, deux=two, four=quatre, one=un, three=trois}
    {skate=board, drive=car, program=computer, play=computer} returns {board=skate, car=drive, computer=play}
    {siskel=ebert, girl=boy, heads=tails, ready=begin, first=last, begin=end} returns {begin=end, boy=girl, ebert=siskel, first=last, heads=tails}
    {cotton=shirt, tree=violin, seed=tree, light=tree, rain=cotton} returns {cotton=rain, light=tree, seed=tree, tree=violin}

    /* mapMystery3
        mystery(map1, map2) returns {bar=earth, baz=wind, foo=air, mumble=fire}
        mystery(map3, map4) returns {five=quatro, one=dos, three=tres}
        mystery(map5, map6) returns {b=years, c=seven, e=ago, g=seven} 
    */



    // maxLength 
    /**
     * Takes a Set of strings as a parameter and that returns the length of the longest string in the set; 
     * return 0 when the set is empty
     * 
     * @param set the set of strings
     * @return the length of the longest string
     */
    public int maxLength(Set<String> set) {
        int result = 0;
        for(String s : set) {
            result = (result > s.length()) ? result : s.length();
        }
        return result;
    }
}
