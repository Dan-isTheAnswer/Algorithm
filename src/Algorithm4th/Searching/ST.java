package Algorithm4th.Searching;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ST <Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    public ST() {
        st = new TreeMap<Key, Value>();
    }

    // Remove key from table if value is null
    public void put(Key key, Value val) {
        if (val == null) st.remove(key);
        else st.put(key, val);
    }

    public Value get(Key key) {
        return st.get(key);
    }

    public Value delete(Key key) {
        return st.remove(key);
    }

    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    @Override
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    public Key min() {
        return st.firstKey();
    }

    public Key max() {
        return st.lastKey();
    }

    /* From k; at least k
     * Return the smalleset key in the table >= k
     */
    public Key ceil(Key k) {
        SortedMap<Key, Value> tail = st.tailMap(k);  
        if (tail.isEmpty()) return null;
        else return tail.firstKey();
    }

    /* Up to k; at most k
     * Return the largest Key in the table <= k 
     */
    public Key floor(Key k) {
        if (st.containsKey(k)) return k;

        SortedMap<Key, Value> head = st.headMap(k);
        if (head.isEmpty()) return null;
        else return head.lastKey();
    }
}