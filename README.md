# username-A2

PROG2004 / Object Oriented Programming – Assignment Two  
**Park Rides Visitor Management System (PRVMS)**

This repository contains the source code, tests and documentation for Assignment Two.  
The project implements a theme park ride management system that demonstrates:

- Object-oriented class design with inheritance and abstraction (Parts 1–2)
- Use of advanced collection classes (`Queue`, `LinkedList`, `Iterator`, `Comparator`) (Parts 3–5)
- Input/output using CSV files for backing up and restoring ride history (Parts 6–7)

---

## Learning Outcomes

This project is designed to support the unit learning outcomes:

- **ULO2:** Apply object-oriented programming principles to solve intermediate problems  
- **ULO3:** Distinguish between and use advanced collection classes  
- **ULO4:** Apply inbuilt mechanisms for managing input and output

---

## Project Structure

> Note: Some folders are optional; only those used in your setup will appear in the repository.

- `src/`
  - Core domain classes: `Person`, `Employee`, `Visitor`, `Ride`
  - Interface: `RideInterface`
  - Comparator: `VisitorComparator`
  - Demo/driver class: `AssignmentTwo` (contains `main` and `partThree`–`partSeven`)
- `test/`  
  - Simple manual test classes (e.g. `SimpleTest`, `VisitorComparatorTest`, `TestRunner`)
- `data/`  
  - (Optional) Sample CSV files or exported ride history files, if you choose to store them here
- `docs/`  
  - (Optional) Design notes, testing strategy, user manual, video script, UML diagrams, etc.
- `commit_history`  
  - Human-readable summary of important Git commits and how the project evolved
- `.gitignore`  
  - Git ignore rules for build artefacts, IDE files, and generated CSV data
- `README.md`  
  - This file

---

## Implemented Features (Mapped to Assignment Parts)

- **Parts 1–2: Class Design, Abstract Class & Interface**
  - `Person` is an abstract base class with common attributes and `getDescription()` for polymorphism.
  - `Employee` and `Visitor` extend `Person` and add role-specific fields.
  - `Ride` models a theme park ride and implements `RideInterface`, which defines:
    - Queue operations
    - Ride history operations
    - `runOneCycle()` to execute a ride cycle.

- **Part 3: Waiting Line (Queue)**
  - `Ride` maintains a `Queue<Visitor> waitingLine`.
  - Methods:
    - `addVisitorToQueue(Visitor)`
    - `removeVisitorFromQueue()`
    - `printQueue()`
  - Demonstrated in `AssignmentTwo.partThree()`.

- **Part 4A: Ride History (LinkedList & Iterator)**
  - `Ride` maintains a `LinkedList<Visitor> rideHistory` for visitors who have taken the ride.
  - Methods:
    - `addVisitorToHistory(Visitor)`
    - `checkVisitorFromHistory(Visitor)`
    - `numberOfVisitors()`
    - `printRideHistory()` (uses an `Iterator` as required)
  - Demonstrated in `AssignmentTwo.partFourA()`.

- **Part 4B: Sorting Ride History (Comparator)**
  - `VisitorComparator` implements multi-field comparison:
    1. FastPass visitors first  
    2. Ticket type priority (VIP → Adult → Child → Other)  
    3. Age (descending)  
    4. Full name (A–Z, case-insensitive)
  - `Ride.sortRideHistory(Comparator<Visitor>)` sorts the `rideHistory`.
  - Demonstrated in `AssignmentTwo.partFourB()` with before/after printing.

- **Part 5: Run a Ride Cycle**
  - `Ride` has `maxRider` and `numOfCycles`.
  - `runOneCycle()`:
    - Validates operator, queue, and `maxRider`
    - Moves up to `maxRider` visitors from `waitingLine` to `rideHistory`
    - Increments `numOfCycles`
  - Demonstrated in `AssignmentTwo.partFive()` with multiple cycles and edge cases.

- **Part 6: Writing to a File (CSV Export)**
  - `Ride.exportRideHistory(String fileName)`:
    - Exports ride history to CSV: `id,fullName,age,ticketType,fastPass`
    - Includes header row, validation for file name, and error handling
  - Demonstrated in `AssignmentTwo.partSix()`, typically producing `ride_history.csv`
    (and optionally `empty_history.csv` for edge-case testing).

- **Part 7: Reading from a File (CSV Import)**
  - `Ride.importRideHistory(String fileName)`:
    - Validates file name and clears existing history
    - Reads CSV lines, parses values, and rebuilds `rideHistory`
    - Handles malformed lines and I/O errors gracefully
  - Demonstrated in `AssignmentTwo.partSeven()`:
    - Imports from `ride_history.csv`
    - Verifies the number and details of imported visitors
    - Tests behaviour with a non-existent file.

---

## How to Build & Run

### Requirements

- Java **17+** (or a compatible JDK used in your PROG2004 environment)
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or a terminal with `javac`/`java`

### Running with an IDE

1. Clone or download the repository.
2. Open the project in your IDE.
3. Make sure `src/` is marked as the **Source Root**.
4. Set `AssignmentTwo` as the **main class**.
5. Run `AssignmentTwo.main()`.
6. Observe the console output:
   - Part 3–7 demonstrations will run in sequence and clearly labelled.

### Running from the Command Line (Example)

From the project root:

```bash
# Compile all source files into an out/ directory
javac -d out src/*.java

# Run the main demo class
cd out
java AssignmentTwo
