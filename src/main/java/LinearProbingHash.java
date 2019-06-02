import java.util.Arrays;

public class LinearProbingHash<key, value> {
    private int couples;
    private int size;
    private key[] keys;
    private value[] values;

    public LinearProbingHash(int size){
        this.size = size;
    }

    public LinearProbingHash(){
        keys = (key[]) new Object[size];
        values = (value[]) new Object[size];
    }

    private int hash(key k){
        return (k.hashCode() & 0x7ffffff) % size;
    }

    private void resize(int capacity){
        LinearProbingHash<key, value> t = new LinearProbingHash<>(capacity);
        for (int i = 0; i<size; i++){
            if (keys[i] != null){
                t.put(keys[i],values[i]);
            }
        }
        t.keys = keys;
        t.values = values;
        t.size = size;
    }

    private void put(key k, value v){
        if (couples >= size/2){
            resize(2*size);
        }
        int i ;

        for (i = hash(k); keys[i] != null; i = (i+1)%size){
            if (k.equals(keys[i])){
                values[i] = v;
            }
        }
        keys[i] = k;
        values[i] = v;
        size = size+1;
    }

    private value get(key k){
        for (int i = hash(k); keys[i] != null; i = (i+1)%size){
            if (keys[i].equals(k)){
                return values[i];
            }
        }
        return null;
    }

    public void delete(key k){
        if (!Arrays.asList(keys).contains(k)){
            return;
        }
        int i = hash(k);
        while (!k.equals(keys[i])){
            i = (i+1)%size;
        }
        keys[i] = null;
        values[i] = null;

        i = (i+1)%size;
        while (keys[i] != null){
            key ktodo = keys[i];
            value vtodo = values[i];
            keys[i] = null;
            values[i] = null;
//            put(ktodo,vtodo);
            size = size-1;
            put(ktodo, vtodo);
            i = (i+1)%size;
        }
        size = size-1;
        if (size>0 & size == couples/8){
            resize(size/2);
        }
    }
}
