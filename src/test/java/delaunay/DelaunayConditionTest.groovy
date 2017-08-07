package delaunay

import spock.lang.Specification

class DelaunayConditionTest extends Specification {

    def triangle = new Triangle(
            new Point(-1, 0),
            new Point(0, 1),
            new Point(1,0)
    )

    def condition = new DelaunayCondition(triangle)

    def "point of triangle not satisfy condition"() {
        given:
        Point trianglePoint = new Point(0, 1)

        expect:
        !condition.satisfiedBy(trianglePoint)
    }

    def "point outside of circumscribe satisfies condition"() {
        given:
        Point outsidePoint = new Point(0, 2)

        expect:
        condition.satisfiedBy(outsidePoint)
    }

    def "point inside triangle does not satisfy condition"() {
        given:
        Point insidePoint = new Point(0, 0.5)

        expect:
        !condition.satisfiedBy(insidePoint)
    }

    def "point inside of circumsribe not satisfy condition"() {
        given:
        Point insidePoint = new Point(0, -0.5)

        expect:
        !condition.satisfiedBy(insidePoint)
    }
}
