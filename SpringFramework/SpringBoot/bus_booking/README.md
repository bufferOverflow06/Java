## Bus booking Management System

## Schema
---

### 1. **users**
- **Who?**: Every person using the system: Admins, Agents, and Passengers
- **Purpose**: Base entity to store login and role info.
- **Fields**:
  - `id`: Primary key
  - `name`, `email`, `password`: Login info
  - `role`: `ADMIN`, `AGENT`, `USER` (used for permission control)
- **Special logic**:
  - Admins control the system (add agents, buses, etc.)
  - Agents manage buses/schedules
  - Users book tickets

---

### 2. **agents**
- **Who?**: People who run bus services (like private operators)
- **Linked to**: One row in the `users` table (with `role = AGENT`)
- **Fields**:
  - `id`: Primary key
  - `user_id`: Foreign key to `users` (1–1 relationship)
  - `agency_name`: Name of their bus company (e.g., “City Travels”)
- **Purpose**:
  - An agent logs in → they can add/edit buses, schedules
  - Think of them as bus owners

---

### 3. **buses**
- **What?**: Actual buses added by agents
- **Fields**:
  - `id`: Primary key
  - `agent_id`: FK to `agents`
  - `bus_no`: Unique identifier (e.g., “KA-01-B1234”)
  - `capacity`: Total seats
- **Purpose**:
  - Each agent can add multiple buses
  - Buses are assigned to schedules (timings + routes)

---

### 4. **routes**
- **What?**: Predefined paths between two cities
- **Fields**:
  - `id`: Primary key
  - `source`: Starting city
  - `destination`: Ending city
  - `distance`: Optional — for fare calculation
- **Purpose**:
  - Routes are shared across buses
  - You define them once, and use in multiple schedules

---

### 5. **schedules**
- **What?**: A specific bus trip on a route at a date and time
- **Fields**:
  - `id`: Primary key
  - `bus_id`: FK to buses
  - `route_id`: FK to routes
  - `date`, `time`: When the bus leaves
- **Purpose**:
  - One bus can have multiple schedules
  - Users book *schedules*, not buses directly
- **Example**:
  - Bus KA-01-B1234 from Chennai to Bangalore on `2025-04-20` at `10:00 AM`

---

### 6. **bookings**
- **What?**: Ticket bookings by users
- **Fields**:
  - `id`: Primary key
  - `user_id`: FK to `users`
  - `schedule_id`: FK to `schedules`
  - `seat_no`: Which seat is booked
  - `status`: `CONFIRMED`, `CANCELLED`, etc.
- **Purpose**:
  - Tracks who booked what, and when
  - Used for seat availability checks and history

---

## 🔁 Real-World Flow of a Booking:

1. **Admin** logs in
   - Creates routes
   - Adds agents

2. **Agent** logs in
   - Adds buses
   - Assigns those buses to schedules using existing routes

3. **User** registers/logs in
   - Searches for buses between source and destination
   - Picks a schedule and books a seat

4. **System** checks:
   - Available schedules for a route
   - Remaining seats
   - If seat is available, saves a booking

---

- [Flow Diagram](./img/2025-04-24T20:16:04,274984330+05:30.png)
