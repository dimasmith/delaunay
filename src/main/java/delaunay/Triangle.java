package delaunay;

import lombok.Value;

@Value
public class Triangle {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
}
