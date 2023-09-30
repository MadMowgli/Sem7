package ch.laeub.mapData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Kml2CsvTest {

    // Fields
    Kml2Csv transformer;
    URL resourceUrl;
    String resourcePath;

    // Methods

    @BeforeEach
    public void setup() {
        this.transformer = new Kml2Csv();
        assertNotNull(transformer, "transformer is null");
        this.resourceUrl = getClass().getClassLoader().getResource("mapdata2.kml");
        assertNotNull(resourceUrl, "Resource 'mapdata2.kml' not found");
        this.resourcePath = resourceUrl.getPath();
    }

    @Test
    public void kmlTest() {
        transformer.parseKml("src/main/java/ch/laeub/mapData/mapdata2.kml");
        ArrayList<KmlNode> nodeList = transformer.getNodeList();
        ArrayList<KmlEdge> edgeList = transformer.getEdgeList();

        // Connect edges to nodes, naming the edges correctly
        edgeList.stream().forEach(edge -> edge.connectEdge(nodeList));

        // Check that each
        assertFalse(nodeList.isEmpty(), "nodeList is empty!");
    }

}
