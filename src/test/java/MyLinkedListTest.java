import exeptions.NotExistedIdException;
import exeptions.NotExistedValueException;
import linked.list.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {

    @Test
    public void addFirst() {
        String[] expectedArr = {"1"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(1, arr.getSize());
    }


    @Test
    public void addSecond() {
        String[] expectedArr = {"1", "2"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");

        arr.add("2");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(2, arr.getSize());
    }



    @Test
    public void addId1() {         //start from 1
        String[] expectedArr = {"0", "1", "2", "3", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(1,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(5, arr.getSize());
    }


    @Test
    public void addIdlast() {
        String[] expectedArr = {"1", "2", "3", "4", "0"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(5,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(5, arr.getSize());
    }


    @Test
    public void addIdInMiddle() {
        String[] expectedArr = {"1", "2", "0", "3", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.add(3,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(5, arr.getSize());
    }


    @Test(expected = NotExistedIdException.class)
    public void addNegativId() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add(-1, "22");
    }


    @Test(expected = NotExistedIdException.class)
    public void addOutOfBound() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add(2, "22");
    }


    @Test
    public void getFirst() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(1);

        assertEquals("1", actualValue);
    }


    @Test
    public void getLast() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(4);

        assertEquals("4", actualValue);
    }


    @Test
    public void getMiddle() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        String actualValue = arr.get(2);

        assertEquals("2", actualValue);
    }


    @Test(expected = NotExistedIdException.class)
    public void getNegativId() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.get(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void getOutOfBound() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.get(1);
    }


    @Test
    public void setFirst() {
        String[] expectedArr = {"0", "2", "3", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.set(1,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getSize());
    }


    @Test
    public void setLast() {
        String[] expectedArr = {"1", "2", "3", "0"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.set(4,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getSize());
    }


    @Test
    public void setMiddle() {
        String[] expectedArr = {"1", "2", "0", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.set(3,"0");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(4, arr.getSize());
    }


    @Test(expected = NotExistedIdException.class)
    public void setNegativId() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.set(-1, "0");
    }


    @Test(expected = NotExistedIdException.class)
    public void setOutOfBound() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.set(1, "0");
    }


    @Test
    public void removeByIdFirst() {
        String[] expectedArr = {"2", "3", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(1);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test
    public void removeByIdLast() {
        String[] expectedArr = {"1", "2", "3"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(4);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test
    public void removeByIdMiddle() {
        String[] expectedArr = {"1", "2", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove(3);

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test(expected = NotExistedIdException.class)
    public void removeByIdNegativId() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.remove(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void removeByIdOutOfBound() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.remove(1);
    }


    @Test
    public void removeByValueFirst() {
        String[] expectedArr = {"2", "3", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove("1");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test
    public void removeByValueLast() {
        String[] expectedArr = {"1", "2", "3"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove("4");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test
    public void removeByValueMiddle() {
        String[] expectedArr = {"1", "2", "4"};

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.remove("3");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(3, arr.getSize());
    }


    @Test(expected = NotExistedValueException.class)
    public void removeByValueNotExistedValue() {
        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.remove("2");
    }




}