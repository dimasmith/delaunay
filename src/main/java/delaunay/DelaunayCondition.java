package delaunay;

public class DelaunayCondition {

    private final Triangle triangle;

    public DelaunayCondition(Triangle triangle) {
        this.triangle = triangle;
    }

    public boolean satisfiedBy(Point point) {
        if (point.equals(triangle.getPointA()) || point.equals(triangle.getPointB()) || point.equals(triangle.getPointC())) {
            return false;
        }

        double x0 = point.getX();
        double x1 = triangle.getPointA().getX();
        double x2 = triangle.getPointB().getX();
        double x3 = triangle.getPointC().getX();
        double y0 = point.getY();
        double y1 = triangle.getPointA().getY();
        double y2 = triangle.getPointB().getY();
        double y3 = triangle.getPointC().getY();

        return ((x0 - x1) * (y0 - y3) - (x0 - x3) * (y0 - y1)) *
                ((x2 - x1) * (x2 - x3) + (y2 - y1) * (y2 - y3)) +
                ((x0 - x1) * (x0 - x3) + (y0 - y1) * (y0 - y3)) *
                        ((x2 - x1) * (y2 - y3) - (x2 - x3) * (y2 - y1)) >= 0;
    }
}
