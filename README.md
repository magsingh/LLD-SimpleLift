# LLD-SimpleLift
---------------------------------------------------------------------------------
###Commit 2 output:
	Sorted scheduledStops = [5]
	Sorted scheduledStops = [5]
	Sorted scheduledStops = [3, 5]
	Sorted scheduledStops = [3, 5]
	----- STEP 0 -----
	More stops in current direction
	----- STEP 1 -----
	At floor 3
	scheduledStops after removing 3 = [5]
	Lift stopped at floor 3
	User boarded. Destination = 8
	Sorted scheduledStops = [5, 8]
	More stops in current direction
	----- STEP 2 -----
	More stops in current direction
	----- STEP 3 -----
	At floor 5
	scheduledStops after removing 5 = [8]
	Lift stopped at floor 5
	User boarded. Destination = 9
	Sorted scheduledStops = [8, 9]
	More stops in current direction
	----- STEP 4 -----
	More stops in current direction
	----- STEP 5 -----
	More stops in current direction
	----- STEP 6 -----
	At floor 8
	scheduledStops after removing 8 = [9]
	Lift stopped at floor 8
	More stops in current direction
	----- STEP 7 -----
	At floor 9
	scheduledStops after removing 9 = []
	Lift stopped at floor 9
	----- STEP 8 -----
	Lift still
	----- STEP 9 -----
	Lift still
	----- STEP 10 -----
	Lift still
	----- STEP 11 -----
	Lift still
	----- STEP 12 -----
	Lift still
	----- STEP 13 -----
	Lift still
	----- STEP 14 -----
	Lift still
	----- STEP 15 -----
	Lift still
	----- STEP 16 -----
	Lift still
	----- STEP 17 -----
	Lift still
	----- STEP 18 -----
	Lift still
	----- STEP 19 -----
	Lift still

Feedback:
| Area                      |    Rating    | Comments                                                                                                                                                                                                 |
| ------------------------- | :----------: | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Class decomposition       |  **9.5/10**  | `Building`, `LiftController`, `Lift`, `LiftLobby`, `User` are well separated. No unnecessary classes.                                                                                                    |
| Responsibility assignment |  **8.5/10**  | Controller orchestrates, Lift moves, Building owns infrastructure. A few responsibilities (boarding logic, hall request handling) are beginning to mix inside `Lift`, but that's expected at this stage. |
| Encapsulation             |   **8/10**   | Better than before, but `getScheduledStops()` still exposes internal state. The controller shouldn't know how the lift stores its schedule.                                                              |
| Readability               |   **9/10**   | Easy to follow. Method sizes are reasonable.                                                                                                                                                             |
| Extensibility             |   **7/10**   | Supports multiple users and lifts, but the single `scheduledStops` list will become a limitation for more advanced scheduling.                                                                           |
| Correctness               |   **8/10**   | Works correctly for your current simulation. There are still edge cases around direction changes and current-floor pickups.                                                                              |
| OO Design                 |  **8.5/10**  | Good use of objects. Some methods expose implementation details, but nothing fundamental.                                                                                                                |
| Interview impression      | **8.5–9/10** | I'd be impressed. Most candidates never get this far in 45–60 minutes.                                                                                                                                   |
---------------------------------------------------------------------------------