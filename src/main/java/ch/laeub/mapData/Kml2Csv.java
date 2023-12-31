package ch.laeub.mapData;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Kml2Csv {

    // Fields
    private File inputFile;
    private ArrayList<KmlNode> nodeList;
    private ArrayList<KmlEdge> edgeList;

    // Constructor
    public Kml2Csv() {
        this.nodeList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }


    // Methods
    public void parseKml(String kmlPath) {
        try {
            // Read input from KML
            this.inputFile = new File(kmlPath);

            // Parse it to XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(this.inputFile);

            //  Normalize XML structure
            doc.getDocumentElement().normalize();

            // Get a NodeList of all "Placemark" elements
            NodeList placemarkList = doc.getElementsByTagNameNS("http://www.opengis.net/kml/2.2", "Placemark");

            // Iterate through each element and create objects for it
            for (int i = 0; i < placemarkList.getLength(); i++) {
                try {

                    // We should fine KmlNodes here
                    Node item = placemarkList.item(i);
                    if (item.getChildNodes().item(0).getTextContent().equalsIgnoreCase("marker")) {
                        String name = item.getChildNodes().item(1).getTextContent();
                        String[] coordinateStrings = item.getChildNodes().item(2).getTextContent().split(", ");
                        String[] coordinates = item.getChildNodes().item(4).getTextContent()
                                .replace("1clampToGround", "")
                                .split(",| ");
                        this.nodeList.add(new KmlNode(name, coordinates, coordinateStrings));
                        System.out.println("New node created");
                    } else if (item.getChildNodes().item(0).getTextContent().equalsIgnoreCase("linepolygon")) {

                        // We got an edge here
                        Node item2 = placemarkList.item(i);
                        String[] coordinates = item2.getChildNodes().item(3).getTextContent()
                                .replace("1clampToGround", "")
                                .split(",| ");
                        String lengthString = item2.getChildNodes().item(1).getTextContent();
                        KmlEdge edge = new KmlEdge(coordinates, lengthString);
                        this.edgeList.add(edge);
                        System.out.println("New edge created");
                    }


                } catch (Exception e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("... done!");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }

    }

    // Getters & Setters
    public ArrayList<KmlNode> getNodeList() {
        return nodeList;
    }

    public ArrayList<KmlEdge> getEdgeList() {
        return edgeList;
    }

    public void writeToCsv() {

        if (!this.nodeList.isEmpty() && !this.edgeList.isEmpty()) {

            // Writing the nodes
            try {
                File nodeFile = new File("Nodes.csv");
                if (nodeFile.createNewFile()) {

                    FileWriter fileWriter = new FileWriter(nodeFile);
                    this.nodeList.forEach(node -> {
                        try {
                            fileWriter.write(node.toString() + "\n");
                            fileWriter.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.println(e.getMessage());
            }

            // Writing the edges
            // Writing the nodes
            try {
                File edgeFile = new File("Edges.csv");
                if (edgeFile.createNewFile()) {

                    FileWriter fileWriter = new FileWriter(edgeFile);
                    this.edgeList.forEach(edge -> {
                        try {
                            fileWriter.write(edge.toString() + "\n");
                            fileWriter.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.println(e.getMessage());
            }

        }

    }

}
