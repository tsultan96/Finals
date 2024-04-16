public class DynamicArray {
    private int capacity; // Initial capacity of the array
    private int size;     // Number of elements currently in the array
    private int[] array;

    public DynamicArray() {
        capacity = 1;
        size = 0;
        array = new int[capacity];
    }

    public void append(int element) {
        // If the array is full, double its capacity
        if (size == capacity) {
            resize(2 * capacity);
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0; // Optional: set the last element to default value
        size--;
        // If the array size is less than 1/4 of its capacity, halve its capacity
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }
    }

    public int length() {
        return size;
    }

    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        // Copy elements from the old array to the new array
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        dynamicArray.append(4);

        System.out.println("Length: " + dynamicArray.length()); // Output: Length: 4

        dynamicArray.remove(1);

        System.out.println("Element at index 1: " + dynamicArray.get(1)); // Output: Element at index 1: 3
        System.out.println("Length after removal: " + dynamicArray.length()); // Output: Length after removal: 3
    }
}
