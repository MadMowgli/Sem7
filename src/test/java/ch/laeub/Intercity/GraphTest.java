package ch.laeub.Intercity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ch.laeub.Intercity.Graph.Node;

import java.util.HashMap;

public class GraphTest {

    // Fields
    Graph graph;

    // Methods

    @BeforeEach
    public void setup() {
        this.graph = new Graph("cityMap");
        graph.addNode("Bern");
        graph.addNode("Olten");
        graph.addNode("Spiez");
        graph.addNode("Lausanne");
        graph.addNode("Zürich");
        graph.addNode("Basel");
        graph.addNode("Brig");
        graph.addNode("Interlaken");
        graph.addNode("Luzern");
        graph.addNode("Arth-Goldau");
        graph.addNode("Lugano");
        graph.addNode("Chur");
        graph.addNode("St. Gallen");
        graph.addNode("Romanshorn");
        graph.addNode("Schaffhausen");
        graph.addNode("Biel");
        graph.addNode("Yverdon");
        graph.addNode("Genf");

        HashMap<String, Node> nodes = graph.getNodes();
        nodes.get("Bern").connect(nodes.get("Olten"), true);
        nodes.get("Bern").connect(nodes.get("Lausanne"), true);
        nodes.get("Bern").connect(nodes.get("Spiez"), true);
        nodes.get("Bern").connect(nodes.get("Zürich"), true);
        nodes.get("Bern").connect(nodes.get("St. Gallen"), true);
        nodes.get("Bern").connect(nodes.get("Romanshorn"), true);
        nodes.get("Bern").connect(nodes.get("Genf"), true);

        // TODO: Make connections

    }

    @Test
    public void graphtest() {

        // TODO: Write test

    }

}
