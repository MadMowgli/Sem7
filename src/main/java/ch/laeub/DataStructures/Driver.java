package main.java.ch.laeub.DataStructures;

public class Driver {
    public static void main(String[] args) {

        record FamilyMember(FamilyMember mother, FamilyMember father, String name) { }
        TreeSet<FamilyMember> treeSet = new TreeSet<>();

    }
}
