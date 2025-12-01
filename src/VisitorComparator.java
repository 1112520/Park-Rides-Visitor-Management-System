import java.util.Comparator;

/**
 * A comparator for multi-field sorting of visitors (Part 4B).
 *
 * Sorting priority:
 *  1) Visitors with fastPass = true come first;
 *  2) ticketType priority: VIP -> Adult -> Child -> Others;
 *  3) Age in descending order (older visitors come first);
 *  4) fullName in ascending alphabetical order (case-insensitive).
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * Assign a "sorting weight" to different ticket types, smaller values have higher priority.
     */
    private int ticketRank(String ticketType) {
        if (ticketType == null) {
            return Integer.MAX_VALUE; // Unknown ticket types are ranked last
        }
        String t = ticketType.trim().toUpperCase();
        switch (t) {
            case "VIP":
                return 0;
            case "ADULT":
                return 1;
            case "CHILD":
                return 2;
            default:
                return 3;
        }
    }

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Handle the same object or null cases
        if (v1 == v2) {
            return 0;
        }
        if (v1 == null) {
            return 1; // null is considered "largest", sorted last
        }
        if (v2 == null) {
            return -1;
        }

        // 1) fastPass priority: visitors with fastPass come first
        if (v1.isFastPass() && !v2.isFastPass()) {
            return -1;
        }
        if (!v1.isFastPass() && v2.isFastPass()) {
            return 1;
        }

        // 2) ticketType priority: VIP -> Adult -> Child -> Others
        int t1 = ticketRank(v1.getTicketType());
        int t2 = ticketRank(v2.getTicketType());
        if (t1 != t2) {
            return Integer.compare(t1, t2);
        }

        // 3) Age in descending order (older visitors come first)
        int ageCompare = Integer.compare(v2.getAge(), v1.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }

        // 4) fullName in ascending alphabetical order (case-insensitive)
        String n1 = v1.getFullName();
        String n2 = v2.getFullName();
        if (n1 == n2) {
            return 0;
        }
        if (n1 == null) {
            return 1;
        }
        if (n2 == null) {
            return -1;
        }
        return n1.compareToIgnoreCase(n2);
    }
}

