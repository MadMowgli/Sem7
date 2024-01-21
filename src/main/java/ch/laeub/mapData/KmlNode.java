package ch.laeub.mapData;

public class KmlNode {

    // Fields
    private final String name;
    private final Coordinate coordinates;
    private final String[] coordinateStrings;

    // Constructor
    public KmlNode(String name, String[] coordinates, String[] coordinateStrings) {
        this.name = name;
        this.coordinates = new Coordinate(coordinates[0], coordinates[1]);
        this.coordinateStrings = coordinateStrings;
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
        return this.name + ";" + this.coordinateStrings[0] + ";" + this.coordinateStrings[1];
    }
}
