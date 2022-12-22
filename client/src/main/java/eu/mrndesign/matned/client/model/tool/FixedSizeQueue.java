package eu.mrndesign.matned.client.model.tool;

public class FixedSizeQueue<E> {

    private Node first = null;
    private Node last = null;
    private int count = 0;
    private final int size;

    public FixedSizeQueue(int size) {
        if (size <= 0) {
            throw new RuntimeException("Min size 1, was " + size);
        }
        this.size = size;
    }

    public void offer(E e) {
        if (count == 0){
            first = new Node(e);
            last = first;
            count++;
        }else if (count < size) {
            last.next = new Node(e);
            last = last.next;
            count++;
        } else {
            first = first.next;
            last.next = new Node(e);
            last = last.next;
        }
    }

    public E peek() {
        return first == null? null : first.value;
    }

    public boolean contains(E e) {
        Node actual = first;
        while (actual != null){
            if (e.equals(actual.value)){
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    private class Node {

        private final E value;
        private Node next = null;

        private Node(E value) {
            this.value = value;
        }
    }
}
