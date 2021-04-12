package Face_test._001_MostPopular._007_LRU.LRUCache_01;

//  题目： Lru 缓存机制；

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_01 {
    private int cap;
    private HashMap<Integer,Integer> map;

    public LRUCache_01(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<Integer,Integer>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }else if(map.size() == cap){
            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key,value);
    }
}
