/*
CORE IDEA of circular array:
Maintains two pointers: start and end. 

Start points to the index of the first valid element, 
and end points to the index of the next position after the last valid element.

So, when I add or remove elements at the head, we only move start. 
When we add or remove elements at the tail, we only move end.

When start or end moves out of the array range (< 0 or >= arr.length), 
we use the modulo operator "%" to make them wrap around to the head or tail of the array and keep working. 
This is how to get the effect of a circular array.

The circular array uses a left-closed, right-open interval
*/

public class Circular_Array {
    
    public class CycleArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int size) {
        this.size = size;
        // Since Java does not support direct creation of
        // generic arrays, type casting is used here
        this.arr = (T[]) new Object[size];
        // start points to the index of the first valid element, closed interval
        this.start = 0;
        // remember that end is an open interval,
        // that is, end points to the next position index of the last valid element
        this.end = 0;
        this.count = 0;
    }

    // Helper function for automatic resizing
    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        // Create a new array
        T[] newArr = (T[]) new Object[newSize];
        // Copy elements from the old array to the new array
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        arr = newArr;
        // Reset start and end pointers
        start = 0;
        end = count;
        size = newSize;
    }

    // Add element to the start of the array, time complexity O(1)
    public void addFirst(T val) {
        // When the array is full, expand to twice its original size
        if (isFull()) {
            resize(size * 2);
        }
        // Since start is a closed interval, move left first, then assign value
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    // Remove element from the start of the array, time complexity O(1)
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // Since start is a closed interval, assign value first, then move right
        arr[start] = null;
        start = (start + 1) % size;
        count--;
        // If the number of elements in the array is reduced to one-fourth
        // of the original size, reduce the array size by half
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    // Add element to the end of the array, time complexity O(1)
    public void addLast(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        // Since end is an open interval, assign value first, then move right
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    // Remove element from the end of the array, time complexity O(1)
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // Since end is an open interval, move left first, then assign value
        end = (end - 1 + size) % size;
        arr[end] = null;
        count--;
        // Shrink
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    // Get the first element of the array, time complexity O(1)
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }

    // Get the last element of the array, time complexity O(1)
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        // end is an open interval, pointing to the next element's position, so subtract 1
        return arr[(end - 1 + size) % size];
    }

    public boolean isFull() {
        return count == size;
    }
    
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
}
