# 🛠️ Finite State Machine (FSM) Requirements

## 📌 Functional Requirements

### ✅ FSM Creation
- The FSM must start with a **single start state**.
- It must support **multiple end states**.
- All states are **uniquely named**.

### 🔁 Transitions
- Transitions are **directional**: from one state to another.
- Transitions are triggered by **events**.
- A single state can have **multiple transitions for different events**.

### 🧩 Extensibility
At any point, you should be able to:
- ➕ Add a new **state**.
- ➕ Add a new **transition**.
- 🔁 **Update** an existing transition (overwrite if already exists).

### 🚦 State Movement
- You can **trigger an event** on the FSM.
- Based on the **current state** and **event**, the FSM moves to the **next state**.

### 🔔 Notifications
- Notifications (on/off) can be set at:
    - The **FSM level** (global toggle).
    - The **individual state level** (per-state toggle).
- If **both global and per-state notification flags** are enabled, show a notification when entering that state.

### 🖥️ Display
- 👁️ View the **current state**.
- 🧭 View the **FSM configuration** (states, transitions).
- 📜 View the **transition history** (list of state changes).

```shell
ADD_STATE <state_name> [is_end_state] [notify_enabled]
SET_START_STATE <state_name>
ADD_TRANSITION <from_state> <event> <to_state>
TRIGGER_EVENT <event>
SET_FSM_NOTIFICATION <on/off>
SET_STATE_NOTIFICATION <state_name> <on/off>
PRINT_CURRENT_STATE
PRINT_TRANSITION_HISTORY
PRINT_FSM

```