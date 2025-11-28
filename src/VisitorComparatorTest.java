public class VisitorComparatorTest {

    public static void main(String[] args) {
        testComparatorOrder();
    }

    private static void testComparatorOrder() {
        VisitorComparator comparator = new VisitorComparator();

        Visitor vFast = new Visitor("C001", "Fast", 25, "Adult", true);
        Visitor vSlow = new Visitor("C002", "Slow", 25, "Adult", false);

        int result = comparator.compare(vFast, vSlow);
        if (result >= 0) {
            throw new AssertionError("Fast-pass visitor should come before normal visitor");
        }

        System.out.println("VisitorComparatorTest: testComparatorOrder passed.");
    }
}
