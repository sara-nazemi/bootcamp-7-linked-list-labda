package org.example.linkedlist;

import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void addWithHead(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.head == null) {
            head = newNode;
        } else {
            Node<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    private Node<T> findNode(T item) {

        if (head == null || item == null) {
            return null;
        } else {
            Node<T> node = head;
            while (node != null) {
                if (node.getData().equals(item)) {
                    return node;
                }
                node = node.getNext();
            }
            return null;
        }
    }

    public void forEach2(ForEach<T> each) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            each.call(data);
        }
    }

    public List<T> filter2(Filter<T> f) {
        List<T> temp = new java.util.LinkedList<>();
        forEach2((data) -> {
            if (f.filter(data))
                temp.add(data);
        });
        return temp;
    }

    public List<T> filter(Filter<T> f) {
        List<T> temp = new java.util.LinkedList<>();
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (f.filter(data))
                temp.add(data);
        }
        return temp;
    }


    public List<T> map2(Map<T> m) {
        List<T> temp = new java.util.LinkedList<>();
        forEach2((data) -> {
            temp.add(m.map(data));
        });
        return temp;
    }


    public List<T> map(Map<T> m) {
        List<T> temp = new java.util.LinkedList<>();
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            temp.add(m.map(data));
        }
        return temp;
    }

    public void remove(T item) {
        Node<T> node = findNode(item);
        if (node == null) {
            throw new ItemNotFoundation();
        } else {
            Node<T> beforeNode = null;
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                if (currentNode.getNext() == node) {
                    beforeNode = currentNode;
                    break;
                }
                currentNode = currentNode.getNext();
            }
            if (beforeNode == null) {
                head = head.getNext();
            }
            beforeNode.setNext(node.getNext());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = LinkedList.this.head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (node == null) {
                    return null;
                }
                T data = node.getData();
                node = node.getNext();
                return data;

            }
        };
    }
}
