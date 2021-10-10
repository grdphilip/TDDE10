package myutil;

public class MyHashMap<K, V> {

    private MyList<K> keys = new MyList<K>();
    private MyList<V> values = new MyList<V>();

    public MyHashMap() {

    }

    public void put(K key, V value) {
        this.getKeys().add(key);
        this.getValues().add(value);
    }

    public V get(K key) throws MyException {
        int index = this.getKeys().getIndex(key);
      
        
      return this.getValues().getElementAtMap(index);
      
    }

    private MyList<K> getKeys() {
        return this.keys;
    }

    private MyList<V> getValues() {
        return this.values;
    }

}
