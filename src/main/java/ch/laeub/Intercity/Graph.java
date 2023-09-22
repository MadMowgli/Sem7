package ch.laeub.Intercity;

import java.util.HashMap;

public class Graph {

    // Fields
    private String name;
    private HashMap<String, Node> nodes;

    // Constructor

    public Graph(String name) {
        this.nodes = new HashMap<>();
        this.name = name;
    }


    // Methods
    public Node addNode(String name) {
        Node node = new Node(name);
        this.nodes.put(name, node);
        return node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, Node> nodes) {
        this.nodes = nodes;
    }

    // ------------------------------------------------------------------------ Inner classes
    public class Node {

        // Fields
        private String name;
        private HashMap<String, Edge> edges;

        // Constructor
        public Node(String name) {
            this.edges = new HashMap<>();
            this.name = name;
        }

        // Methods
        public void connect(Node target, boolean twoWay) {
            Edge edge = new Edge(this.name + "2" + target.name, this, target);
            this.edges.put(edge.name, edge);
            if(twoWay) {
                Edge edge1 = new Edge(target.getName() + "2" + this.getName(), target, this);
                target.getEdges().put(edge1.getName(), edge1);
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, Edge> getEdges() {
            return edges;
        }

        public void setEdges(HashMap<String, Edge> edges) {
            this.edges = edges;
        }
    }

    public class Edge {

        // Fields
        private String name;
        private HashMap<String, Node> nodes;

        // Constructor
        public Edge(String name, Node source, Node target) {
            this.nodes = new HashMap<>();
            this.nodes.put(source.getName(), source);
            this.nodes.put(target.getName(), target);
            this.name = name;
        }

        // Methods


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, Node> getNodes() {
            return nodes;
        }

        public void setNodes(HashMap<String, Node> nodes) {
            this.nodes = nodes;
        }
    }

}
