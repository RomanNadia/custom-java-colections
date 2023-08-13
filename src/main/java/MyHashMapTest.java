import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyHashMapTest {


    @Test
    public void putWithoutChaining() {
        String[] expectingKeyArray = {null, "1", "2"};
        String[] expectingValueArray = {"0", "1", "2"};

        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "2");
        hashmap.put(null, "0");
        hashmap.put("1", "1");

        Object[] actualKeyArray = hashmap.convertKeyToArray();
        Object[] actualValueArray = hashmap.convertValueToArray();

        assertArrayEquals(expectingKeyArray, actualKeyArray);
        assertArrayEquals(expectingValueArray, actualValueArray);
    }


    @Test
    public void putWithChaining() {
        MyKey[] expectingKeyArray = {new MyKey("2"), new MyKey("1"), new MyKey("3")};
        String[] expectingValueArray = {"0", "2", "1"};

        MyHashMap<MyKey, String> hashmap = new MyHashMap<MyKey, String>();
        hashmap.put(new MyKey("1"), "2");
        hashmap.put(new MyKey("2"), "0");
        hashmap.put(new MyKey("3"), "1");

        Object[] actualKeyArray = hashmap.convertKeyToArray();
        Object[] actualValueArray = hashmap.convertValueToArray();

        assertArrayEquals(expectingKeyArray, actualKeyArray);
        assertArrayEquals(expectingValueArray, actualValueArray);
    }


    @Test
    public void removeWithoutChaining() {
        String[] expectingKeyArray = {null, "1"};
        String[] expectingValueArray = {"0", "1"};

        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "2");
        hashmap.put(null, "0");
        hashmap.put("1", "1");

        hashmap.remove("2");

        Object[] actualKeyArray = hashmap.convertKeyToArray();
        Object[] actualValueArray = hashmap.convertValueToArray();

        assertArrayEquals(expectingKeyArray, actualKeyArray);
        assertArrayEquals(expectingValueArray, actualValueArray);
    }


    @Test
    public void removeWithChainingSecondChainingElement() {
        MyKey keyForDelete = new MyKey("3");

        MyKey[] expectingKeyArray = {new MyKey("2"), new MyKey("1")};
        String[] expectingValueArray = {"0", "2"};

        MyHashMap<MyKey, String> hashmap = new MyHashMap<MyKey, String>();
        hashmap.put(new MyKey("1"), "2");
        hashmap.put(new MyKey("2"), "0");
        hashmap.put(keyForDelete, "1");

        hashmap.remove(keyForDelete);

        Object[] actualKeyArray = hashmap.convertKeyToArray();
        Object[] actualValueArray = hashmap.convertValueToArray();

        assertArrayEquals(expectingKeyArray, actualKeyArray);
        assertArrayEquals(expectingValueArray, actualValueArray);
    }


    @Test
    public void removeWithChainingFirstChainingElement() {
        MyKey keyForDelete = new MyKey("1");

        MyKey[] expectingKeyArray = {new MyKey("2"), new MyKey("3")};
        String[] expectingValueArray = {"0", "1"};

        MyHashMap<MyKey, String> hashmap = new MyHashMap<MyKey, String>();
        hashmap.put(keyForDelete, "2");
        hashmap.put(new MyKey("2"), "0");
        hashmap.put(new MyKey("3"), "1");

        hashmap.remove(keyForDelete);

        Object[] actualKeyArray = hashmap.convertKeyToArray();
        Object[] actualValueArray = hashmap.convertValueToArray();

        assertArrayEquals(expectingKeyArray, actualKeyArray);
        assertArrayEquals(expectingValueArray, actualValueArray);
    }


    @Test(expected = NotExistedKeyExeption.class)
    public void removeNotExistingId() {
        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();

        hashmap.remove("1");
    }


    @Test
    public void getNullValue() {
        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "22");
        hashmap.put("1", "44");
        hashmap.put(null, "223");
        hashmap.put("10", "33");

        String actualValue = hashmap.get(null);
        assertEquals("223", actualValue);
    }

    @Test
    public void getLast() {
        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "22");
        hashmap.put("1", "44");
        hashmap.put(null, "223");
        hashmap.put("10", "33");

        String actualValue = hashmap.get("10");
        assertEquals("33", actualValue);
    }


    @Test
    public void getMiddle() {
        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "22");
        hashmap.put("1", "44");
        hashmap.put(null, "223");
        hashmap.put("10", "33");

        String actualValue = hashmap.get("1");
        assertEquals("44", actualValue);
    }


    @Test(expected = NotExistedKeyExeption.class)
    public void getNotExistedKeyExeption() {
        MyHashMap<String, String> hashmap = new MyHashMap<String, String>();
        hashmap.put("2", "22");

        hashmap.get("3");
    }

}