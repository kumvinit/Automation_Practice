package corejava;

import java.util.HashSet;
import java.util.Iterator;

public class hashSet {
    public static void main(String[] args) {
        //Set don't accpet duplicate values : HashSet, LinkedHashSet, TreeSet
        //Not guaranteed to store elements in sequential manner
        HashSet<String> hs= new HashSet<String>();
        hs.add("United Kingdom");
        hs.add("UK");
        hs.add("India");
        hs.add("London");
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());
        hs.add("UK"); //It rejects the duplicate value without any error
        System.out.println(hs);

        HashSet hs_cloned = (HashSet)hs.clone();
        System.out.println("The new cloned hashSet is " +hs_cloned);

        Iterator<String> i=hs.iterator(); //Iterator
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }
}
