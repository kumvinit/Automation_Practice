package corejava;

import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<String>();
        //List accepts duplicate values : ArrayList, Vector, LinkedList
        //Array has fixed size where List can grow/reduce dynamically
        a.add("Rahul");
        a.add("Java");
        a.add(0, "Student"); //inserting value at a particular index
        System.out.println(a);
    }
}
