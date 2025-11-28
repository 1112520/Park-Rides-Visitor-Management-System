public class SimpleTest {

    public static void main(String[] args) {
        testVisitorEquals();
    }

    private static void testVisitorEquals() {
        Visitor v1 = new Visitor("T001", "Test Visitor", 20, "Adult", false);
        Visitor v2 = new Visitor("T001", "Test Visitor", 20, "Adult", false);

        if (!v1.equals(v2)) {
            throw new AssertionError("Visitors with same id should be equal");
        }

        System.out.println("SimpleTest: testVisitorEquals passed.");
    }
}
