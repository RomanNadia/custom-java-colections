import array.list.MyArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();

        arrayList.add("Luna");
        arrayList.add("Alfira");

        arrayList.printAll();

        MyArrayList<Integer> lengths = arrayList.map(name -> name.length());

        lengths.printAll();


        System.out.println("filter");

        MyArrayList<Integer> arrayListFilt = new MyArrayList<>();

        arrayListFilt.add(10);
        arrayListFilt.add(19);

        arrayListFilt.printAll();

        MyArrayList<Integer> arrayListAfterFilt = arrayListFilt.filter(age -> age >= 18);

        arrayListAfterFilt.printAll();


        System.out.println("flatMap");

        MyArrayList<MyArrayList<String>> letters = new MyArrayList<>();

        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("a");
        list1.add("b");
        MyArrayList<String> list2 = new MyArrayList<>();
        list2.add("c");
        list2.add("d");

        letters.add(list1);
        letters.add(list2);

        MyArrayList<String> flattenedList = letters.flatMap(list -> list.getArraylist());
        flattenedList.printAll();

    }
}
