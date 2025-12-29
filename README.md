# InterviewOS 
### DSA-Driven Coding Interview Preparation Engine

InterviewOS is an intelligent interview preparation system that recommends coding problems based on a user’s performance using core Data Structures and Algorithms (DSA).  
The project emphasizes **algorithmic reasoning, adaptive learning paths, and system design**, not UI complexity.

---

##  Project Overview

Unlike linear problem lists, InterviewOS models interview preparation as a **learning graph**.  
When a user fails a problem, the system intelligently recommends **conceptually similar and easier problems** to reinforce understanding.

---

## Link to product walkthrough
### Check out the live demo of the project [here](interviewos-production.up.railway.app).


<img width="2545" height="1342" alt="image" src="https://github.com/user-attachments/assets/a53756ab-e775-4272-943e-5d5b717877e3" />
<img width="2553" height="1326" alt="image" src="https://github.com/user-attachments/assets/857d36b2-2308-471e-addf-4289494619f5" />


##  Architecture

```text
Frontend (HTML / CSS / Vanilla JavaScript)
        ↓
Controller Layer (Spring Boot REST APIs)
        ↓
Service Layer (Business Logic)
        ↓
DSA Layer
 ├── Graph (Adjacency List + BFS Traversal)
 ├── Trie (Prefix-based Tag Indexing)
 ├── Heap (PriorityQueue-based Ranking)
        ↓
In-Memory Storage (HashMaps)

```

---

##  Core Data Structures Used

### 1. Graph (Adjacency List)
- Models problems as nodes
- Edges represent conceptual similarity and difficulty progression
- BFS traversal recommends nearby learning problems

### 2. Trie
- Stores problem tags
- Supports prefix-based tag search in O(L)
- Faster than scanning all tags

### 3. Heap (PriorityQueue)
- Dynamically ranks problems
- Prioritizes:
  - Higher failure count
  - Lower difficulty
  - Lower average solve time

### 4. HashMap
- Stores problems and attempts in memory
- Enables O(1) access

---

##  Recommendation Flow (Example)
```text
User fails "3Sum"
      ↓
Failure recorded (Performance Engine)
      ↓
Graph BFS finds related problems
      ↓
Filter problems with same or lower difficulty
      ↓
Heap ranks based on failure frequency
      ↓
Top-K recommendations returned
```

---

##  REST APIs

| Method | Endpoint | Description |
|------|--------|------------|
| GET | /problems | Fetch all problems |
| POST | /attempt | Record solve/fail attempt |
| GET | /recommend | Fetch recommendations |
| GET | /stats | Fetch performance stats |

All APIs return JSON.

---

##  Time & Space Complexity

| Component | Complexity |
|--------|-----------|
| Graph BFS | O(V + E) |
| Trie Prefix Search | O(L) |
| Heap Insertion | O(log N) |
| Heap Top-K | O(K log N) |
| HashMap Access | O(1) |

---

##  Future Improvements

- Replace aggregated metrics with **Segment Tree**
- Persist data using database
- Add user authentication
- Difficulty heatmap & progress visualization
- Adaptive learning paths using ML

---

##  Tech Stack

- Backend: Java, Spring Boot
- Frontend: HTML, CSS, Vanilla JavaScript
- Storage: In-memory data structures
- Deployment: Single Spring Boot JAR (Render / Railway compatible)

---

##  Key Takeaway

InterviewOS demonstrates:
- Strong DSA fundamentals
- Clean system design
- Scalable thinking
- Interview-ready backend engineering
