package delaunay;

import lombok.Value;

@Value
public class Triangle {

    private final Edge edgeA;
    private final Edge edgeB;
    private final Edge edgeC;
}
