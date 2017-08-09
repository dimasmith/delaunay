package delaunay;

import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class Triangle {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Set<Point> points;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        points = new HashSet<>();
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;

        return points.size() == triangle.points.size() &&
                points.containsAll(triangle.points);
    }

    @Override
    public int hashCode() {
        return 31 * points.stream().mapToInt(Point::hashCode).sum();
    }
}
