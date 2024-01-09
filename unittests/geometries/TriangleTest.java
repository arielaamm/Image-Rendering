package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private final double DELTA = 0.000001;
    Point p1 = new Point(0,0,1);
    Point p2 = new Point(1,0,0);
    Point p3 = new Point(0,1,0);
    Triangle triangle = new Triangle(p1,p2,p3);
    @Test
    void getNormal() {
        Vector normal = triangle.getNormal(new Point(0.5, 0.5, 0));
        // ================ Equivalence Partitions Tests ==============
        //TC01: test that normal is correct
        assertTrue(normal.equals(new Vector(1,1,1).normalize()) || normal.equals(new Vector(1,1,1).normalize().scale(-1)), "ERROR: plane normal is not correct");
        //TC02: test that normal is in the right length
        assertEquals(1, normal.length(), "ERROR: plane normal is not in the right length");

        // TC03: test that normal is orthogonal to each one of the edges
        assertEquals(0d, normal.dotProduct(p1.subtract(p2)), DELTA,"Polygon's normal is not orthogonal to one of the edges");
        assertEquals(0d, normal.dotProduct(p2.subtract(p3)), DELTA,"Polygon's normal is not orthogonal to one of the edges");
        assertEquals(0d, normal.dotProduct(p1.subtract(p3)), DELTA,"Polygon's normal is not orthogonal to one of the edges");
    }
}