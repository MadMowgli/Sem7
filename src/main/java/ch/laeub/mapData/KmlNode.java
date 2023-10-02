package ch.laeub.mapData;

public class KmlNode {

    // Fields
    private final String name;
    private final Coordinate coordinate;

    // Constructor
    public KmlNode(String name, String[] coordinates) {
        this.name = name;
        this.coordinate = new Coordinate(coordinates[1], coordinates[0]);
    }

    // Methods
    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.coordinate.getEast() + ";" + this.coordinate.getWest();
    }
}
