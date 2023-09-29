package ch.laeub.mapData;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class Kml2Csv {

    // Fields
    File inputFile;

    // Constructor


    // Methods
    public void readKml(String kmlPath) {
        try {
            // Read input from KML
            this.inputFile = new File(kmlPath);

            // Do we have data?
            Scanner scanner = new Scanner(inputFile);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

            // Parse it to XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(this.inputFile);

            //  Normalize XML structure
            doc.getDocumentElement().normalize();


            // Get a NodeList of all "Placemark" elements
            NodeList placemarkList = doc.getElementsByTagNameNS("http://www.opengis.net/kml/2.2", "Placemark");


            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
