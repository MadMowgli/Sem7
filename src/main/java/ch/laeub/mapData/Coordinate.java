package ch.laeub.mapData;

import java.util.Objects;

public class Coordinate implements Comparable{

    private String east;
    private String west;
    private Double eastD;
    private Double westD;

    public Coordinate(String east, String west) {
        this.east = east;
        this.west = west;

        try {
            this.eastD = Double.parseDouble(east);
            this.westD = Double.parseDouble(west);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getEast() {
        return east;
    }
    public String getWest() {
        return west;
    }

    public Double getEastD() { return eastD; }

    public Double getWestD() { return westD; }

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


    @Override
    public int compareTo(Object object) {

        // Try to cast the object
        try {
            Coordinate comparer = (Coordinate) object;

            Double comprarerTotal = comparer.getEastD() + comparer.getWestD();
            Double thisTotal = this.getEastD() + this.getWestD();

            return thisTotal.compareTo(comprarerTotal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
