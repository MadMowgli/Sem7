package ch.laeub.mapData;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<KmlNode> nodes = new ArrayList<>();

        for(KmlNode node : nodeList) {
            if(this.coordinates.contains(node.getCoordinate())) {
                nodes.add(node);
            }
        }

        if(nodes.size() == 2) {
            this.node1 = nodes.get(0).getName();
            this.node2 = nodes.get(1).getName();
        } else {
            System.out.println();
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
}