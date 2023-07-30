import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

//    private void arrayListTest() {
//        MyArrayList<String> arr = new MyArrayList<>();
//        arr.add("1");
//        arr.add("2");
//        arr.add("3");
//        arr.add("4");
//        arr.add("5");
//        arr.add("6");
//        arr.add("7");
//        arr.add("8");
//        arr.add("9");
//        arr.add("10");
//        arr.add("11");
//        arr.printAll();
//        System.out.println(arr.get(3));
//        //System.out.println(arr.get(11));
//        arr.add(2,"2.5");
//        arr.printAll();
//        arr.replace(2,"Prapa");
//        arr.printAll();
//        arr.remove(2);
//        arr.printAll();
//        arr.remove("2");
//        arr.printAll();
//
//
//        Iterator<String> iterator = arr.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for (String a : arr) {
//            System.out.println(a);
//        }
//
//
//        for (String a : arr) {
//            System.out.println(a);
//        }
//
//
//        arr.remove("2");
//
//        System.out.println("hfhdfh");
//        for (String a : arr) {
//            System.out.println(a);
//        }
//    }
//
//
//    private void linkedListTest() {
//        MyLinkedList<String> arr = new MyLinkedList<>();
//
//        arr.add("1");
//        arr.add("2");
//        arr.add("3");
//        arr.add("4");
//        arr.printAll();
//
//        System.out.println(arr.get(1));
//        System.out.println(arr.get(3));
//
//        arr.add(4,"0");
//        arr.printAll();
//
//
//        arr.set(4,"10");
//        arr.printAll();
//
//        arr.remove(2);
//        arr.printAll();
//
//        arr.remove("5");
//        arr.printAll();
//    }

    public static void main(String[] args) {

        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "22");//
        hashmap.put(null, "20");//
        hashmap.put("7", "1");//
        hashmap.put("8", "3");
        hashmap.put("9", "22");
        hashmap.put("10", "20");//
        hashmap.put("15", "21");
        hashmap.put("1", "20");
        hashmap.put("5", "20");


       // hashmap.remove(null);
        // hashmap.remove("8");


        hashmap.put("1", "100");
//        hashmap.put("5", "20");

//        System.out.println(hashmap.get("15"));
//        System.out.println(hashmap.get("10"));
//        System.out.println(hashmap.get(null));

//        hashmap.remove("15");
//        hashmap.remove("6");
//        hashmap.remove(null);






    }
}
