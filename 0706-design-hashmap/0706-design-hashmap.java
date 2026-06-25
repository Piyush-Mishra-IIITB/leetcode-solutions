class MyHashMap {

    List<int[]> ll;

    public MyHashMap() {
        ll = new ArrayList<>();
    }

    public void put(int key, int value) {
        for (int i = 0; i < ll.size(); i++) {
            int[] a = ll.get(i);
            if (a[0] == key) {
                a[1] = value;
                return;
            }
        }

        ll.add(new int[]{key, value});
    }

    public int get(int key) {
        for (int i = 0; i < ll.size(); i++) {
            int[] a = ll.get(i);
            if (a[0] == key) {
                return a[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < ll.size(); i++) {
            int[] a = ll.get(i);
            if (a[0] == key) {
                ll.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */