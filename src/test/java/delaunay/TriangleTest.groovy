package delaunay

import spock.lang.Specification

class TriangleTest extends Specification {

    def a = new Point(0, 0)
    def b = new Point(1, 0)
    def c = new Point(0, 1)
    def d = new Point(1, 1)

    def "triangles are equal when points are equal"() {
        given: 'Triangles with the same points'
        def triangleA = new Triangle(a, b, c)
        def triangleB = new Triangle(a, b, c)

        expect:
        triangleA == triangleB
    }

    def "triangles equal regardless of points order"() {
        given: 'Triangles with the same points in different order'
        def triangleA = new Triangle(a, b, c)
        def triangleB = new Triangle(c, a, b)

        expect:
        triangleA == triangleB
    }

    def "triangles are different if points are different"() {
        given: 'Triangles with different points'
        def triangleA = new Triangle(a, b, c)
        def triangleB = new Triangle(a, b, d)

        expect:
        triangleA != triangleB
    }
}
