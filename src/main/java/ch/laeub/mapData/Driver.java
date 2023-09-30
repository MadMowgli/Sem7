package ch.laeub.mapData;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        Kml2Csv transformer = new Kml2Csv();

        // Create nodes & edges
        transformer.parseKml("src/main/java/ch/laeub/mapData/mapdata2.kml");
        ArrayList<KmlNode> nodeList = transformer.getNodeList();
        ArrayList<KmlEdge> edgeList = transformer.getEdgeList();

        // Connect edges to nodes, naming the edges correctly
        edgeList.stream().forEach(edge -> edge.connectEdge(nodeList));

        // TODO: We still have some edges without length information - see error logs

        System.out.println();
    }

}
