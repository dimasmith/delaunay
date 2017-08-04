package delaunay

import spock.lang.Specification

class DistanceTest extends Specification {

    def "calculate distance between points"() {
        given:
        def a = new Point(0.0, 3.0)
        def b = new Point(4.0, 0.0)

        when:
        def distance = new Distance(a, b)

        then:
        distance.getValue() == 5.0
    }

    def "distance between point on same position is zero"() {
        given:
        def a = new Point(0.0, 3.0)
        def b = new Point(0.0, 3.0)

        when:
        def distance = new Distance(a, b)

        then:
        distance.getValue() == 0.0
    }

    def "compare distances"() {
        given:
        def shorterDistance = new Distance(new Point(0, 0), new Point(1, 1))
        def longerDistance = new Distance(new Point(0, 0), new Point(2, 2))

        expect:
        shorterDistance.compareTo(longerDistance) < 0
        longerDistance.compareTo(shorterDistance) > 0
        shorterDistance.compareTo(shorterDistance) == 0
    }
}
