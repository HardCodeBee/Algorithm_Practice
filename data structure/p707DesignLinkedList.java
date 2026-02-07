import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class p707DesignLinkedList {
             public class MyLinkedList {
        private static final int INT_CAPACITY = 10;

        private int[] data;
        private int size = 0;


        public MyLinkedList() {
            this(INT_CAPACITY);
        }

        public MyLinkedList(int int_CAPACITY){
            if(int_CAPACITY<0){
                throw new IllegalAccessError();
            }

            this.data = new int[int_CAPACITY];
            size = 0;
        }
    
        public int get(int index) {
            if (!helper_isElementIndex(index)) return -1;
            return data[index];
        }

    
    public void addAtHead(int val) {
    addAtIndex(0, val);
}

    
    
    public void addAtTail(int val) {
    addAtIndex(size, val);
}

    
    public void addAtIndex(int index, int val) {
    // rulse    
    if (index > size) return;
    if (index < 0) index = 0;

    // check the capcity
    if (size == data.length) {
        int new_cap = (data.length == 0) ? 1 : data.length * 2;
        helper_extend(new_cap);
    }

    // move to right ：[index..size-1] -> [index+1..size]
    for (int i = size - 1; i >= index; i--) {
        data[i + 1] = data[i];
    }

    data[index] = val;
    size++;
}

    //size = 2 index =1 val=2
    //i    =1 i >0 data[2] = data[1]
    
    public void deleteAtIndex(int index) {
    if (!helper_isElementIndex(index)) return;

    // move to left：[index+1..size-1] -> [index..size-2]
    for (int i = index; i < size - 1; i++) {
        data[i] = data[i + 1];
    }
    size--;
}


    public void helper_extend(int newCap){
        int[] newData = new int[newCap];

        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    
    private boolean helper_isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean helper_isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

        
    

    
    }



}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */