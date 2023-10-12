package hashmap;

import java.util.HashSet;
import java.util.Set;

//Find whether an array is subset of another array
public class arrSubset {
    public static void main(String[] args) {
        //Input: arr1[] = {11, 1, 13, 21, 3, 7},
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        Set<Integer> s=new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            s.add(arr1[i]);
        }
        int p=s.size();
        for (int i=0; i<arr2.length; i++){
            s.add(arr2[i]);
        }

        if(p== s.size()){
            System.out.println("It's a subset");
        }
        else {
            System.out.println("Not a subset");
        }
    }
}
