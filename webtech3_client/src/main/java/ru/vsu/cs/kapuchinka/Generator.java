package ru.vsu.cs.kapuchinka;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import java.time.LocalDate;
import java.util.Random;

public class Generator {
    private static final Random random = new Random();
    private static final String[] NAME_PRODUCT = new String[]{"productName#1", "productName#2", "productName#3", "productName#4", "productName#5"};
    private static final String[] TYPE_PRODUCT = new String[]{"productType#1", "productType#2", "productType#3", "productType#4", "productType#5"};
    private static final String[] NAME_PLACE = new String[]{"placeName#1", "placeName#2", "placeName#3", "placeName#4", "placeName#5"};

    public static Polygon generateRandomPolygon() {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] coordinates = new Coordinate[5];
        for (int i = 0; i < 5; i++) {
            double x = new Random().nextDouble() * 10;
            double y = new Random().nextDouble() * 10;
            coordinates[i] = new Coordinate(x, y);
        }
        coordinates[4] = coordinates[0];
        LinearRing linearRing = geometryFactory.createLinearRing(coordinates);
        return geometryFactory.createPolygon(linearRing, null);
    }

    public static LocalDate generateDate() {
        return LocalDate.now();
    }

    public static String generatePlace() {
        return NAME_PLACE[random.nextInt(NAME_PLACE.length)];
    }

    public static String generateProductName() {
        return NAME_PRODUCT[random.nextInt(NAME_PRODUCT.length)];
    }

    public static String generateProductType() {
        return TYPE_PRODUCT[random.nextInt(TYPE_PRODUCT.length)];
    }
}
