package corejava;

import java.util.ArrayList;
import java.util.Arrays;

/*//find Unique numbers from array
public class printUniqueNumber {
    public static void main(String[] args) {
        int a[]= {4, 5, 5, 5, 4, 6, 6, 9, 4};
        //output : 4-3, 5-3, 6-2, 9-1
        int n=a.length;
        Arrays.sort(a);
        for (int i=0; i<n-1; i++){
            if (a[i]!=a[i+1]){
                System.out.println(a[i] + " ");
            }
        }
        System.out.println(a[n-1]);
    }
}*/
public class printUniqueNumber {
public static void main(String[]args) {
    int a[] = {4, 5, 5, 5, 4, 6, 6, 9, 4};
    //Print unique numbers and the count
    ArrayList<Integer> ab = new ArrayList<Integer>();
    for (int i = 0; i < a.length; i++) {
        int k = 0; //counter k initialization
        if (!ab.contains(a[i])) { //Added negation - if ab array does not have value of a at index i, then only it adds
            ab.add(a[i]);
            k++;
        }

        for (int j = 0; j == i + 1; j++) {

            if (a[i] == a[j]) {
                k++;
            }
        }
        System.out.println(a[i] + " - ");
        System.out.println(k);
    }
    }
}
