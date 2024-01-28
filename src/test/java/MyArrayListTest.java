//import array.list.MyArrayList;
import array.list.MyArrayList;
import exeptions.NotExistedIdException;
import exeptions.NotExistedValueException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {

    @Test
    public void AddWithoutResize() {
        Integer[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(10, arr.getArrayLength());
    }


    @Test
    public void AddWithResize() {
        Integer[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        MyArrayList<Integer> arr = new MyArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(11);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(16, arr.getArrayLength());
    }


    @Test
    public void addId0() {
        String[] expectedArr = {"0", "1", "2", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(0,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
    }


    @Test
    public void addIdLast() {
        String[] expectedArr = {"1", "2", "3", "4", "0"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(4,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
    }


    @Test
    public void addIdInMiddle() {
        String[] expectedArr = {"1", "2", "0", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(2,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
    }


    @Test(expected = NotExistedIdException.class)
    public void addNegativeId() {
        MyArrayList<String> arr = new MyArrayList<>();

        arr.add(-1, "22");
    }


    @Test(expected = NotExistedIdException.class)
    public void addOutBoundId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.add(4, "22");
    }


    @Test
    public void getId0() {

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(0);

        assertEquals("1", actualValue);
    }


    @Test
    public void getIdLast() {
        String[] expectedArr = {"1", "2", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(3);

        assertEquals("4", actualValue);
    }


    @Test
    public void getIdInMiddle() {
        String[] expectedArr = {"1", "2", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(2);

        assertEquals("3", actualValue);
    }


    @Test(expected = NotExistedIdException.class)
    public void getNegativeId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.get(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void getOutBoundId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.get(2);
    }


    @Test
    public void replaceId0() {
        String[] expectedArr = {"0", "2", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.replace(0,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getArraySize());
    }


    @Test
    public void replaceIdLast() {
        String[] expectedArr = {"1", "2", "3", "0"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.replace(3,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getArraySize());
    }


    @Test
    public void replaceIdInMiddle() {
        String[] expectedArr = {"1", "2", "0", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.replace(2,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getArraySize());
    }


    @Test(expected = NotExistedIdException.class)
    public void replaceNegativeId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.replace(-1, "22");
    }


    @Test(expected = NotExistedIdException.class)
    public void replaceOutBoundId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.replace(2, "22");
    }


    @Test
    public void removeId0() {
        String[] expectedArr = {"2", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(0);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getArraySize());
    }


    @Test
    public void removeIdLast() {
        String[] expectedArr = {"1", "2", "3"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(3);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getArraySize());
    }

    @Test
    public void removeIdInMiddle() {
        String[] expectedArr = {"1", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(1);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getArraySize());
    }


    @Test
    public void removeObject() {
        String[] expectedArr = {"1", "3", "4"};

        MyArrayList<String> arr = new MyArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove("2");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getArraySize());
    }


    @Test(expected = NotExistedIdException.class)
    public void removeNegativeId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.remove(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void removeOutBoundId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.remove(2);
    }


    @Test(expected = NotExistedValueException.class)
    public void removeNotExistedObject() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.remove("3");
    }


}