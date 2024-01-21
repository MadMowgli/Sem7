package main.java.ch.laeub.DataStructures;

import java.util.ArrayList;
import java.util.List;

public class CustomTreeSet<T> {

    // --------------------------------------------------- Fields
    Node<T> root;

    // --------------------------------------------------- Private Nested Class
    private class Node<T> {
        T data;
        Node<T> parent;
        List<Node<T>> children;

        public Node(T data) {
            this.data = data;
            this.parent = null;
            this.children = new ArrayList<Node<T>>();
        }
    }

    // --------------------------------------------------- Constructor
    public CustomTreeSet (T rootData) {
        this.root = new Node<T>(rootData);
    }

    // --------------------------------------------------- Methods
    public T get(T searchData) {
        return null;
    }

}
