package ch.laeub.mapData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class KmlEdge {

    // Fields
    private String node1;
    private String node2;
    private Double length;
    private final ArrayList<Coordinate> coordinates;

    // Constructor
    public KmlEdge(String[] coordinates, String lengthString) {
        this.coordinates = new ArrayList<>(Arrays.asList(
                new Coordinate(coordinates[1], coordinates[0]),
                new Coordinate(coordinates[3], coordinates[2])
        ));
        try { lengthString = lengthString.replace("m", ""); } catch (Exception ignore) {} // Try to remove the "m", if it exists
        this.length = Double.parseDouble(lengthString);
    }

    // Methods
    public void connectEdge(ArrayList<KmlNode> nodeList) {

        // Connect edges with nodes where possible
        ArrayList<KmlNode> nodes = nodeList.stream()
                .filter(node -> this.coordinates.contains(node.getCoordinates()))
                .collect(Collectors.toCollection(ArrayList::new));

        if(nodes.size() == 2) {
            // If we end up here, we found our two nodes
            this.node1 = nodes.get(0).getName();
            this.node2 = nodes.get(1).getName();
        } else if(nodes.size() == 1) {

            // If we end up here, we only got 1 node. Search for the second one

            // TODO: I don't think this works yet
            ArrayList<KmlNode> sortedNodes = nodeList.stream()
                    .filter(node -> !nodes.contains(node))
                    .sorted((node1, node2) -> node1.getCoordinates().compareTo(node2.getCoordinates()))
                    .collect(Collectors.toCollection(ArrayList::new));

            this.node1 = sortedNodes.get(0).getName();
            System.out.println(node1);
            System.out.println(node2);
        } else {
            System.out.println("Found " + nodes.size() + " nodes for edge.");
            nodes.forEach(System.out::println);
        }

    }

    public String getNode1() {
        return node1;
    }

    public String getNode2() {
        return node2;
    }

    public Double getLength() {
        return length;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return this.node1 + ";" + this.node2 + ";" + this.length.toString();
    }

}
