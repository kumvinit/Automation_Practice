package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Country-Polulation
public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        //Insertion, if key doesn't exist then  it updates the value
        map.put("India", 32);
        map.put("China", 23);
        map.put("US", 120);

        //Search
        System.out.println(map.containsKey("India")); //output - either TRUE or FALSE
        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia")); //if key doesn't exist, it prints NULL

/*        int arr[]={12, 15, 18};
        for (int val : arr){
            System.out.println(val + " ");
        }
        System.out.println( );*/

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        Set<String> keys= map.keySet();
        for (String key: keys){
            System.out.println(key+ " "+ map.get(key));
        }
    }
}
