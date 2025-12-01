# Commit History

This file keeps a human-readable summary of important commits for Assignment 2
(Park Rides Visitor Management System).

---

## Commit 1 – `chore: initialise assignment 2 project structure`

**Summary:**  
Created the initial project layout and empty class stubs to prepare for implementing Parts 1–7.

**Details:**
- Set up the base Java project structure.
- Added placeholder classes for `Person`, `Visitor`, `Employee`, `Ride`, and simple test classes.
- Prepared the repository for incremental, feature-based commits.

---

## Commit 2 – `feat: add core domain classes and ride interface`

**Summary:**  
Implemented the core domain model and interface required for Parts 1–2.

**Details:**
- Implemented `Person` as an abstract base class with common fields (`id`, `fullName`, `age`) and `getDescription()` for polymorphic behaviour.
- Implemented `Visitor` and `Employee` as subclasses with extra fields (`ticketType`, `fastPass`, `position`, `hourlyRate`) and validation.
- Added the `Ride` class with key attributes and introduced `RideInterface` to define required ride behaviours (queue, history, runOneCycle, etc.).

---

## Commit 3 – `feat: implement visitor queue logic in Ride`

**Summary:**  
Implemented Part 3 – the waiting line using a queue.

**Details:**
- Added `waitingLine` as a `Queue<Visitor>` inside `Ride`.
- Implemented `addVisitorToQueue`, `removeVisitorFromQueue`, and `printQueue` to provide FIFO behaviour.
- Added null checks and user-friendly console messages, plus handling for empty queues.

---

## Commit 4 – `feat: implement ride history management in Ride`

**Summary:**  
Implemented Part 4A – ride history using a LinkedList and Iterator.

**Details:**
- Added `rideHistory` as a `LinkedList<Visitor>` to record visitors who have taken the ride.
- Implemented `addVisitorToHistory`, `checkVisitorFromHistory`, `numberOfVisitors`, and `printRideHistory`.
- Ensured `printRideHistory` uses an `Iterator` (as required by the assignment brief).
- Added simple validations and clear console feedback for history operations.

---

## Commit 5 – `Finish Parts 3-4B: queue, history, and sorting`

**Summary:**  
Refined Parts 3–4 and prepared the system for sorting and further features.

**Details:**
- Cleaned up queue and history logic in `Ride` for better readability and consistency.
- Ensured queue and history methods work together correctly for later ride cycle and I/O features.
- Prepared the codebase for integrating sorting and demonstrations in `AssignmentTwo`.

---

## Commit 6 – `feat: complete Part 4B ride history sorting and demonstration`

**Summary:**  
Implemented Part 4B – sorting ride history using a Comparator.

**Details:**
- Implemented `VisitorComparator` with multi-field comparison:
  1. FastPass visitors first,  
  2. Ticket type priority: VIP → Adult → Child → Other,  
  3. Age in descending order,  
  4. Full name A–Z (case-insensitive).
- Added `sortRideHistory(Comparator<Visitor>)` to `Ride`.
- Updated `AssignmentTwo.partFourB()` to show ride history before and after sorting, making the sorting behaviour visible for marking and the video explanation.

---

## Commit 7 – `Finish Part 5: implement runOneCycle in Ride`

**Summary:**  
Implemented the core logic for Part 5 – running a ride cycle.

**Details:**
- Added `maxRider` and `numOfCycles` fields to `Ride`.
- Implemented `runOneCycle` with validations:
  - Operator must be assigned,
  - Queue must not be empty,
  - `maxRider` must be a positive value.
- Moved up to `maxRider` visitors from the queue to ride history per cycle, updating `numOfCycles` accordingly.

---

## Commit 8 – `Implement AssignmentTwo Part 5-7: runOneCycle demo & CSV import/export`

**Summary:**  
Hooked up Parts 5–7 into `AssignmentTwo` for complete demonstrations.

**Details:**
- Implemented `partFive()` in `AssignmentTwo` to run multiple cycles and print queue and history before/after each cycle.
- Implemented `partSix()` to demonstrate exporting ride history to a CSV file.
- Implemented `partSeven()` to demonstrate importing ride history from a CSV file.
- Added edge-case demonstrations:
  - Running without an operator,
  - Running with an empty queue,
  - Exporting an empty history,
  - Importing from a non-existent file.

---

## Commit 9 – `feat: Update main: invoke 5–7`

**Summary:**  
Ensured the main method demonstrates all implemented parts.

**Details:**
- Updated `main` in `AssignmentTwo` to call `partThree()` through `partSeven()` in sequence.
- Improved console headings and separators so each part (3–7) is clearly visible in the output for marking and for the explanation video.

---

## Commit 10 – `feat: implement Parts 5-7 with complete functionality`
## Commit 11 –  docs: update commit_history and gitignore

**Summary:**  
Final polish and completion of Parts 5–7 features.

**Details:**
- Refined `runOneCycle` messages and cycle-count reporting for clearer logs.
- Polished CSV export/import logic and error handling to improve robustness and clarity.
- Verified that queue management, ride history, sorting, ride cycles, and file I/O all work together according to the assignment requirements.
