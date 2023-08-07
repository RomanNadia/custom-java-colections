import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyHashMapTest {

//    @Test                                for put and remove? convert to array?
//    public void put() {
//
//    }


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