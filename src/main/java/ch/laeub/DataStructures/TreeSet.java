package main.java.ch.laeub.DataStructures;

import java.util.Set;

public class TreeSet<T> {

    // ----------------------------------------------------------- Fields
    T root;
    Set<T> allNodes;

    // ----------------------------------------------------------- Constructors
    public TreeSet(T root) {
        this.root = root;
    }
    public TreeSet() {

    }

    // ----------------------------------------------------------- Inner class
    private class Node<T> {
        T parent;
        Set<T> children;
    }

    // ----------------------------------------------------------- Methods
    public T getRoot() { return this.root;}

    // Only set new root when current root is null
    public boolean setRoot(T root) {
        if (this.root == null) {
            this.root = root;
            return true;
        } else {
            return false;
        }
    }

}
