package ch.laeub.mapData;

public class KmlNode {

    // Fields
    private final String name;
    private final Coordinate coordinates;

    // Constructor
    public KmlNode(String name, String[] coordinates) {
        this.name = name;
        this.coordinates = new Coordinate(coordinates[1], coordinates[0]);
    }

    // Methods
    public String getName() {
        return name;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.coordinates.getEast() + ";" + this.coordinates.getWest();
    }
}
