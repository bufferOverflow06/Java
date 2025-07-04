class Box<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class Pair<K, V>{
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void print(){
        System.out.println(key + " = " + value);
    }
}

class Util{
    public static <T> void printArray(T[] arr){
        for(T elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}

