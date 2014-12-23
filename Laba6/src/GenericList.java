import java.util.AbstractList;
import java.util.Arrays;

public class GenericList<E> extends AbstractList<E> {

    private E[] Array;
    private int size = 0;

    //@SuppressWarnings("unchecked")
    public GenericList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Неверный размер " + capacity);
        }
        this.Array = (E[]) new Object[capacity];
    }

    public int size() {
        return Array.length;
    }

    public int occupied() {
        return size;
    }

    public E get(int index) {
        rangeCheck(index);
        return Array[index];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {

        if (Array.length - size == 0) {
            Array = Arrays.copyOf(Array, Array.length + 2);
            System.out.println("Вместимость " + Array.length);
        }
        Array[size++] = e;
        return true;
    }

    //проверка есть ли элемент с таким индексом
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы");
        }
    }
    public void removeByIndex(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(Array, index + 1, Array, index,
                    numMoved);
        Array[--size] = null;
    }
    public void removeAll(){
        for (int i = 0; i< Array.length; i++){
            Array[i] = null;
            size = 0;
        }
    }
}
