public class TestRunner {

    public static void main(String[] args) {
        //  Run the two simple tests in sequence
        SimpleTest.main(args);
        VisitorComparatorTest.main(args);
        System.out.println("All manual tests finished.");
    }
}
