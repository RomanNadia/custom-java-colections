import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {

    @Test
    public void AddWithoutResize() {
        String[] expectedArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");
        arr.add("10");

        Object[] actualArray = arr.convertToArray();

        assertArrayEquals(expectedArr, actualArray);
        assertEquals(10, arr.getArraySize());
        assertEquals(10, arr.getArrayLength());
    }


    @Test
    public void AddWithResize() {
        //preparing data
        String[] expectedArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

        MyArrayList<String> arr = new MyArrayList<>();

        //call tested method
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");
        arr.add("10");
        arr.add("11");

        Object[] actualArray = arr.convertToArray();

        //assert actual and expected
        assertArrayEquals(expectedArr, actualArray);
        assertEquals(11, arr.getArraySize());
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
    public void addNegativId() {
        MyArrayList<String> arr = new MyArrayList<>();

        arr.add(-1, "22");
    }


    @Test(expected = NotExistedIdException.class)
    public void addOutBoudId() {
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
    public void getNegativId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.get(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void getOutBoudId() {
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
    public void replaceNegativId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.replace(-1, "22");
    }


    @Test(expected = NotExistedIdException.class)
    public void replaceOutBoudId() {
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
    public void removeNegativId() {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("1");
        arr.add("2");

        arr.remove(-1);
    }


    @Test(expected = NotExistedIdException.class)
    public void removeOutBoudId() {
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