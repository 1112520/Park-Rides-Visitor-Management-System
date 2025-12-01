/**
 * AssignmentTwo - Theme Park Management System Demonstrator
 *
 * Demonstrates all parts (3–7) of the assignment requirements
 * for the Park Rides Visitor Management System (PRVMS).
 *
 * NOTE: Part 1–2 (class design, abstract class, interface) are
 * demonstrated implicitly via the use of Person, Employee, Visitor and Ride.
 */
public class AssignmentTwo {

    /**
     * Main entry point for the assignment demonstration.
     * Executes all part demonstrations in sequence.
     */
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Park Rides Visitor Management System (PRVMS)");
        System.out.println("  PROG2004 - Assignment 2 Demonstration");
        System.out.println("==================================================\n");

        AssignmentTwo demo = new AssignmentTwo();

        // Execute all part demonstrations in order
        demo.partThree();   // Queue operations
        demo.partFourA();   // LinkedList with Iterator
        demo.partFourB();   // Sorting with Comparator
        demo.partFive();    // Ride cycle simulation
        demo.partSix();     // File export
        demo.partSeven();   // File import

        System.out.println("\n==================================================");
        System.out.println("  All demonstrations completed successfully!");
        System.out.println("==================================================");
    }

    // ------------------- Part 3: Queue 演示 -------------------

    /**
     * Part 3: Demonstrates Queue operations for visitor waiting line.
     * Shows FIFO behavior by adding visitors, removing one, and printing queue.
     */
    public void partThree() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                 PART 3: QUEUE                 ║");
        System.out.println("║          Waiting Line Demonstration           ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        // Create employee and ride
        Employee operator = new Employee("E001", "Alice Operator", 30, "Ride Operator", 30.0);
        Ride ride = new Ride("Super Coaster", "Roller Coaster", 1.4, operator, 4);

        System.out.println("\n Created Ride: " + ride.getName());
        System.out.println(" Operator: " + operator.getFullName());

        // Create and add 5 visitors to queue
        Visitor[] visitors = {
                new Visitor("Q001", "Bob Visitor", 20, "Adult", true),
                new Visitor("Q002", "Charlie Visitor", 25, "Adult", false),
                new Visitor("Q003", "Daisy Visitor", 16, "Child", false),
                new Visitor("Q004", "Eric Visitor", 35, "VIP", false),
                new Visitor("Q005", "Frank Visitor", 28, "Adult", true)
        };

        // Small polymorphism demo: Person reference to Employee / Visitor
        printPersonDescriptions(operator, visitors[0], visitors[1]);

        System.out.println("\n Adding " + visitors.length + " visitors to queue...");
        for (Visitor visitor : visitors) {
            ride.addVisitorToQueue(visitor);
        }

        System.out.println("\n Queue after adding visitors:");
        ride.printQueue();

        // Remove first visitor from queue
        System.out.println("\n Removing first visitor from queue...");
        Visitor removed = ride.removeVisitorFromQueue();
        if (removed != null) {
            System.out.println(" Removed: " + removed.getFullName());
        }

        System.out.println("\n Queue after removing one visitor:");
        ride.printQueue();

        // Test edge case: remove from empty queue
        System.out.println("\n Testing edge case - removing from empty queue:");
        Ride emptyRide = new Ride("Empty Ride", "Test Ride", 1.0, operator, 2);
        emptyRide.removeVisitorFromQueue();
    }

    // ------------------- Part 4A: 历史记录演示 -------------------

    /**
     * Part 4A: Demonstrates LinkedList operations for ride history.
     * Uses Iterator for printing and shows history management operations.
     */
    public void partFourA() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║                PART 4A: LINKEDLIST             ║");
        System.out.println("║           Ride History with Iterator           ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        Employee operator = new Employee("E101", "Olivia Operator", 29, "Ride Operator", 32.0);
        Ride ride = new Ride("River Rapids", "Water Ride", 1.2, operator, 6);

        System.out.println("\n Created Ride: " + ride.getName());

        // Add visitors to history
        Visitor[] historyVisitors = {
                new Visitor("H001", "Henry Visitor", 22, "Adult", false),
                new Visitor("H002", "Ivy Visitor", 18, "Student", false),
                new Visitor("H003", "Jack Visitor", 30, "Adult", true),
                new Visitor("H004", "Kelly Visitor", 12, "Child", false),
                new Visitor("H005", "Leo Visitor", 40, "VIP", true)
        };

        System.out.println("\n Adding " + historyVisitors.length + " visitors to ride history...");
        for (Visitor visitor : historyVisitors) {
            ride.addVisitorToHistory(visitor);
        }

        // Demonstrate all required operations
        System.out.println("\n Ride history (using Iterator):");
        ride.printRideHistory();

        System.out.println("\n Counting visitors in history:");
        ride.numberOfVisitors();

        System.out.println("\n Checking if visitor exists in history:");
        ride.checkVisitorFromHistory(historyVisitors[2]); // Check Jack Visitor

        System.out.println("\n Checking non-existent visitor:");
        Visitor nonExistent = new Visitor("H999", "Ghost Visitor", 99, "Unknown", false);
        ride.checkVisitorFromHistory(nonExistent);
    }

    // ------------------- Part 4B: 多字段排序演示 -------------------

    /**
     * Part 4B: Demonstrates sorting ride history using Comparator.
     * Shows multi-field sorting with clear before/after comparison.
     */
    public void partFourB() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║                PART 4B: SORTING                ║");
        System.out.println("║         Multi-field Visitor Comparison         ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        Employee operator = new Employee("E201", "Peter Operator", 33, "Ride Operator", 31.0);
        Ride ride = new Ride("Galaxy Spinner", "Thrill Ride", 1.3, operator, 8);

        System.out.println("\n Created Ride: " + ride.getName());

        // Create visitors with varied attributes for clear sorting demonstration
        Visitor[] sortVisitors = {
                new Visitor("S001", "Alice",   25, "Adult",   false),
                new Visitor("S002", "Bob",     20, "Adult",   true),
                new Visitor("S003", "Charlie", 15, "Child",   false),
                new Visitor("S004", "Daisy",   30, "VIP",     true),
                new Visitor("S005", "Eve",     18, "Student", false)
        };

        System.out.println("\n Adding " + sortVisitors.length + " visitors to ride history...");
        for (Visitor visitor : sortVisitors) {
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("\n Ride history BEFORE sorting (insertion order):");
        ride.printRideHistory();

        System.out.println("\n Sorting ride history using VisitorComparator...");
        ride.sortRideHistory(new VisitorComparator());

        System.out.println("\n Ride history AFTER sorting:");
        ride.printRideHistory();

        System.out.println("\n Sorting criteria used by VisitorComparator:");
        System.out.println(" 1) FastPass visitors first");
        System.out.println(" 2) Then by ticket type priority: VIP -> Adult -> Child -> Other");
        System.out.println(" 3) Then by age (descending: older visitors first)");
        System.out.println(" 4) Finally by full name (A-Z, case-insensitive)");
    }

    // ------------------- Part 5: runOneCycle 演示 -------------------

    /**
     * Part 5: Demonstrates running ride cycles with queue management.
     * Shows visitor movement from queue to history during cycle execution.
     */
    public void partFive() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║                 PART 5: RIDE CYCLE             ║");
        System.out.println("║           runOneCycle Demonstration            ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        Employee operator = new Employee("E100", "Cycle Operator", 30, "Ride Operator", 5);
        Ride ride = new Ride("Thunder Coaster", "Roller Coaster", 1.2, operator, 4);

        System.out.println("\n📋 Created Ride: " + ride.getName());
        System.out.println("⚙️  Max riders per cycle: " + ride.getMaxRider());

        // Create 10 visitors for comprehensive demonstration
        Visitor[] cycleVisitors = {
                new Visitor("P001", "Alex Rider",       20, "Adult",   false),
                new Visitor("P002", "Bella Adventurer", 22, "Adult",   true),
                new Visitor("P003", "Chris Junior",     11, "Child",   false),
                new Visitor("P004", "Diana Explorer",   35, "Adult",   false),
                new Visitor("P005", "Ethan Thrill",     28, "Adult",   true),
                new Visitor("P006", "Fiona Student",    17, "Student", false),
                new Visitor("P007", "George VIP",       40, "VIP",     true),
                new Visitor("P008", "Hannah Kid",       15, "Child",   false),
                new Visitor("P009", "Ian College",      19, "Student", false),
                new Visitor("P010", "Jessica Adult",    27, "Adult",   false)
        };

        System.out.println("\n Adding " + cycleVisitors.length + " visitors to queue...");
        for (Visitor visitor : cycleVisitors) {
            ride.addVisitorToQueue(visitor);
        }

        // Run multiple cycles to demonstrate complete functionality
        runCycleWithDetails(ride, "First");
        runCycleWithDetails(ride, "Second");
        runCycleWithDetails(ride, "Third");

        // Test edge cases
        System.out.println("\n Testing edge cases:");

        System.out.println("\n Testing ride without operator:");
        Ride noOperatorRide = new Ride("Broken Ride", "Test", 1.0, null, 2);
        noOperatorRide.addVisitorToQueue(new Visitor("T001", "Test Visitor", 25, "Adult", false));
        noOperatorRide.runOneCycle();

        System.out.println("\n Testing ride with empty queue:");
        Ride emptyQueueRide = new Ride("Empty Ride", "Test", 1.0, operator, 2);
        emptyQueueRide.runOneCycle();
    }

    /**
     * Helper method to run a cycle and print detailed before/after information.
     */
    private void runCycleWithDetails(Ride ride, String cycleName) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" " + cycleName + " CYCLE EXECUTION");
        System.out.println("=".repeat(50));

        System.out.println("\n Queue BEFORE " + cycleName.toLowerCase() + " cycle:");
        ride.printQueue();

        System.out.println("\n  Executing " + cycleName.toLowerCase() + " cycle...");
        ride.runOneCycle();

        System.out.println("\n Queue AFTER " + cycleName.toLowerCase() + " cycle:");
        ride.printQueue();

        System.out.println("\n Ride history AFTER " + cycleName.toLowerCase() + " cycle:");
        ride.printRideHistory();

        System.out.println("\n Current cycle count: " + ride.getNumOfCycles());
    }

    // ------------------- Part 6: 导出历史记录到 CSV -------------------

    /**
     * Part 6: Demonstrates exporting ride history to CSV file.
     * Shows file creation and data export with proper error handling.
     */
    public void partSix() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║                 PART 6: FILE EXPORT            ║");
        System.out.println("║          CSV Export Demonstration              ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        Employee operator = new Employee("E200", "Export Operator", 32, "Ride Operator", 4);
        Ride ride = new Ride("Water Adventure", "Water Ride", 1.0, operator, 4);

        System.out.println("\n Created Ride: " + ride.getName());

        // Add visitors to history for export
        Visitor[] exportVisitors = {
                new Visitor("F001", "File Visitor One",   21, "Adult",   false),
                new Visitor("F002", "File Visitor Two",   30, "Adult",   true),
                new Visitor("F003", "File Visitor Three", 16, "Student", false),
                new Visitor("F004", "File Visitor Four",  12, "Child",   false),
                new Visitor("F005", "File Visitor Five",  40, "VIP",     true)
        };

        System.out.println("\n Adding " + exportVisitors.length + " visitors to ride history...");
        for (Visitor visitor : exportVisitors) {
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("\n Current ride history to be exported:");
        ride.printRideHistory();

        // Export to CSV file
        String fileName = "ride_history.csv";
        System.out.println("\n Exporting ride history to: " + fileName);
        ride.exportRideHistory(fileName);

        // Test edge case: export empty history
        System.out.println("\n Testing export with empty history:");
        Ride emptyRide = new Ride("Empty Export", "Test", 1.0, operator, 2);
        emptyRide.exportRideHistory("empty_history.csv");
    }

    // ------------------- Part 7: 从 CSV 文件导入历史记录 -------------------

    /**
     * Part 7: Demonstrates importing ride history from CSV file.
     * Shows file reading, data parsing, and validation of imported data.
     */
    public void partSeven() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║                 PART 7: FILE IMPORT            ║");
        System.out.println("║          CSV Import Demonstration              ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        Employee operator = new Employee("E201", "Import Operator", 29, "Ride Operator", 4);
        Ride ride = new Ride("Data Loader", "Family Ride", 1.1, operator, 4);

        System.out.println("\n Created Ride: " + ride.getName());
        System.out.println(" Initial ride history (should be empty):");
        ride.printRideHistory();

        // Import from CSV file
        String fileName = "ride_history.csv";
        System.out.println("\n Importing ride history from: " + fileName);
        ride.importRideHistory(fileName);

        // Verify import results
        System.out.println("\n Import completed. Verification:");
        System.out.println("\n Number of visitors imported:");
        ride.numberOfVisitors();

        System.out.println("\n Visitors imported into ride history:");
        ride.printRideHistory();

        // Test edge case: import non-existent file
        System.out.println("\n Testing import with non-existent file:");
        Ride testRide = new Ride("Test Import", "Test", 1.0, operator, 2);
        testRide.importRideHistory("non_existent_file.csv");
    }

    /**
     * Small helper to demonstrate polymorphism:
     * one method working with abstract Person type.
     */
    private void printPersonDescriptions(Person... people) {
        System.out.println("\n[Polymorphism demo - Person.getDescription()]");
        for (Person p : people) {
            System.out.println(" - " + p.getDescription());
        }
    }
}
