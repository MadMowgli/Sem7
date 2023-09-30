package ch.laeub.mapData;

public class Coordinate {

    private String east;
    private String west;

    public Coordinate(String east, String west) {
        this.east = east;
        this.west = west;
    }

    public String getEast() {
        return east;
    }
    public String getWest() {
        return west;
    }

    @Override
    public boolean equals(Object object) {

        // Basic checks
        if(object == null) return false;
        if(this == object) return true;
        if(this.getClass() != object.getClass()) return false;

        // We can cast the object to a Coordinate now, we know it's not null and the class matches
        Coordinate comparer = (Coordinate) object;

        // Check if both ends of the coordinate are the same
        // That is: if (west == west && east == east) || (west == east && east == west)
        return (this.getWest().equalsIgnoreCase(comparer.getWest()) && this.getEast().equalsIgnoreCase(comparer.getEast()))
                || (this.getWest().equalsIgnoreCase(comparer.getEast()) && this.getEast().equalsIgnoreCase(comparer.getWest()));

    }

}
