package ch.laeub.mapData;

public class Driver {

    public static void main(String[] args) {
        Kml2Csv transformer = new Kml2Csv();
        transformer.readKml("src/main/java/ch/laeub/mapData/mapdata.kml");
    }

}
