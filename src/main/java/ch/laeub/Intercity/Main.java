package ch.laeub.Intercity;


import ch.laeub.Intercity.Graph;
import ch.laeub.Intercity.Graph.Node;
import ch.laeub.Intercity.Graph.Edge;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph("CityMap");
        Node bern = graph.addNode("Bern");
        Node olten = graph.addNode("Olten");

        bern.connect(olten, true);

        System.out.println();



    }

}
