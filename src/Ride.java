import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Amusement Rides in Theme Parks
 * Implement the RideInterface, including:
 * - Waiting queue (Queue<Visitor> waitingLine) —— Part 3
 * - Ride history (LinkedList<Visitor> rideHistory) —— Part 4A/4B
 * - Running one cycle of the ride —— Part 5
 * - Importing and exporting history records —— Part 6/7
 */
public class Ride implements RideInterface {

    // ---------- Basic Attributes (Part 1) ----------
    private String name;         // Ride name, e.g., "Super Coaster"
    private String type;         // Ride type, e.g., "Roller Coaster"
    private double minHeight;    // Minimum height requirement (meters)
    private Employee operator;   // Employee responsible for operating the ride

    // ---------- Running Attributes (Part 5) ----------
    private int maxRider;        // Maximum number of visitors per cycle
    private int numOfCycles;     // Number of cycles already run

    // ---------- Collections: Waiting Queue (Part 3) ----------
    private Queue<Visitor> waitingLine;

    // ---------- Collections: Ride History (Part 4A/4B) ----------
    private LinkedList<Visitor> rideHistory;

    // ---------- Constructors ----------

    /**
     * Default constructor (required by the assignment)
     */
    public Ride() {
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * Parameterized constructor, sets all basic fields.
     */
    public Ride(String name, String type, double minHeight,
                Employee operator, int maxRider) {
        this(); // Call default constructor to ensure queues and history are initialized
        this.name = name;
        this.type = type;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // ---------- Getter / Setter ----------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or blank");
        }
        this.type = type;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        if (minHeight < 0) {
            throw new IllegalArgumentException("minHeight cannot be negative");
        }
        this.minHeight = minHeight;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider <= 0) {
            throw new IllegalArgumentException("maxRider must be > 0");
        }
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        if (numOfCycles < 0) {
            throw new IllegalArgumentException("numOfCycles cannot be negative");
        }
        this.numOfCycles = numOfCycles;
    }

    /**
     * Read-only access to rideHistory, used for sorting and demonstration
     */
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // ---------- Part 3: Waiting Queue Related Implementation ----------

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot add null visitor to the waiting line for " + name + ".");
            return;
        }
        waitingLine.offer(visitor);
        System.out.println("Visitor " + visitor.getFullName()
                + " joined the waiting line for " + name + ".");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removed = waitingLine.poll();
        if (removed == null) {
            System.out.println("No visitors in the waiting line for " + name + ".");
        } else {
            System.out.println("Visitor " + removed.getFullName()
                    + " left the waiting line for " + name + ".");
        }
        return removed;
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Waiting line for " + name + " is empty.");
            return;
        }
        System.out.println("Waiting line for " + name + ":");
        int index = 0;
        for (Visitor v : waitingLine) {
            System.out.println("[" + index + "] " + v);
            index++;
        }
    }

    // ---------- Part 4A: Ride History (LinkedList + Iterator) ----------

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot add null visitor to ride history for " + name + ".");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getFullName()
                + " added to ride history of " + name + ".");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Cannot check null visitor in ride history for " + name + ".");
            return false;
        }
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println("Visitor " + visitor.getFullName()
                    + " IS in ride history of " + name + ".");
        } else {
            System.out.println("Visitor " + visitor.getFullName()
                    + " is NOT in ride history of " + name + ".");
        }
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int size = rideHistory.size();
        System.out.println("Number of visitors in ride history of "
                + name + ": " + size);
        return size;
    }

    /**
     * Print ride history using Iterator (explicitly required by the assignment)
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history for " + name + ".");
            return;
        }

        System.out.println("Ride history for " + name + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("[" + index + "] " + v);
            index++;
        }
    }

    // ---------- Part 4B: Sorting Ride History ----------

    /**
     * Sort ride history using the given Comparator.
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("Cannot sort ride history for " + name + " because it is empty.");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history for " + name + " has been sorted.");
    }

    // ---------- Part 5: Running One Cycle of the Ride ----------

    @Override
    public void runOneCycle() {
        // Take up to maxRider visitors from the waiting queue and add them to the history
        if (operator == null) {
            System.out.println("Cannot run " + name + " because there is no operator assigned.");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("Cannot run " + name + " because there are no waiting visitors.");
            return;
        }
        if (maxRider <= 0) {
            System.out.println("Cannot run " + name + " because maxRider is not set properly.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("Running one cycle of " + name
                + " for " + ridersThisCycle + " visitors.");

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor v = waitingLine.poll();
            if (v != null) {
                addVisitorToHistory(v);
            }
        }

        numOfCycles++;
        System.out.println(name + " has now run " + numOfCycles + " cycle(s).");
    }

    // ---------- Part 6: Export Ride History to CSV File (with Enhanced Validation) ----------

    /**
     * Export rideHistory to a simple CSV file.
     * Each line format: id,fullName,age,ticketType,fastPass
     */
    public void exportRideHistory(String fileName) {
        // New addition: File name validation
        if (fileName == null || fileName.isBlank()) {
            System.out.println("File name cannot be null or blank. Export cancelled.");
            return;
        }

        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history of " + name + " to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //Write a table header (optional).
            writer.write("id,fullName,age,ticketType,fastPass");
            writer.newLine();

            for (Visitor v : rideHistory) {
                String line = String.format("%s,%s,%d,%s,%b",
                        v.getId(),
                        v.getFullName(),
                        v.getAge(),
                        v.getTicketType(),
                        v.isFastPass());
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Ride history for " + name + " has been exported to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting ride history to file '" + fileName + "': " + e.getMessage());
        }
    }

    // ---------- Part 7: Import Ride History from CSV File (with Enhanced Validation) ----------

    /**
     * Import rideHistory from a CSV file, the file format should be consistent with exportRideHistory output.
     * The current history will be cleared before importing.
     */
    public void importRideHistory(String fileName) {
        // New addition: File name validation
        if (fileName == null || fileName.isBlank()) {
            System.out.println("File name cannot be null or blank. Import cancelled.");
            return;
        }

        rideHistory.clear(); // Clear current history

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // Read and discard header

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("Invalid line in file, skipped: " + line);
                    continue;
                }

                String id = parts[0];
                String fullName = parts[1];
                int age;
                try {
                    age = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age value for line, skipped: " + line);
                    continue;
                }
                String ticketType = parts[3];
                boolean fastPass = Boolean.parseBoolean(parts[4]);

                Visitor v = new Visitor(id, fullName, age, ticketType, fastPass);
                addVisitorToHistory(v);
            }

            System.out.println("Ride history for " + name + " has been imported from file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error importing ride history from file '" + fileName + "': " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", minHeight=" + minHeight +
                ", operator=" + (operator != null ? operator.getFullName() : "none") +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                '}';
    }
}
