package corejava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hm=new HashMap<Integer, String>();
        /*HashMap is similar to HashTable with 2 differences - Has
        1. Multiple threads can operate simultaneously and hence hashmap’s object is not thread-safe.
        2. Threads are not required to wait and hence relatively performance is high.
        3. Null is allowed for both key and value.
        4. For iterating HashTable we have to use enumerator and not iterator
         */
        hm.put(0, "Hello");
        hm.put(1, "GoodBye");
        hm.put(2, "Good morning");
        hm.put(3, "Good night");
        System.out.println(hm.get(2));

        Set sn=hm.entrySet();
        Iterator<Map.Entry<Integer, String>> it= sn.iterator();

        while (it.hasNext()){

            Map.Entry<Integer, String> mp=(Map.Entry) it.next();
            System.out.println(mp.getKey());
            System.out.println(mp.getValue());

        }
    }
}
