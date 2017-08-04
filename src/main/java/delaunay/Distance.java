package delaunay;

import lombok.Getter;
import lombok.Value;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Value
public class Distance implements Comparable<Distance> {
    private final Point a;
    private final Point b;
    @Getter(lazy = true)
    private final double value = calculateDistance();

    private double calculateDistance() {
        return sqrt(pow(a.getX() - b.getX(), 2) + pow(a.getY() - b.getY(), 2));
    }

    @Override
    public int compareTo(Distance o) {
        return Double.compare(this.getValue(), o.getValue());
    }
}
