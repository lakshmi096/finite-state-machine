package com.machinecoding.command;

import com.machinecoding.service.FSMService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
// Executes parsed commands
public class CommandProcessor {
    private final FSMService service = new FSMService();

    public void process(String input) {
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length == 0) return;

        String command = tokens[0];
        switch (command) {
            case "ADD_STATE":
                if (tokens.length >= 2) {
                    String name = tokens[1];
                    boolean isEndState = tokens.length >= 3 && Boolean.parseBoolean(tokens[2]);
                    boolean notifyEnabled = tokens.length >= 4 && Boolean.parseBoolean(tokens[3]);
                    service.addState(name, isEndState, notifyEnabled);
                } else {
                    System.out.println("Usage: ADD_STATE <state_name> [is_end_state] [notify_enabled]");
                }
                break;
            case "SET_START_STATE":
                if (tokens.length >= 2) {
                    service.setStartState(tokens[1]);
                } else {
                    System.out.println("Usage: SET_START_STATE <state_name>");
                }
                break;
            case "ADD_TRANSITION":
                if (tokens.length >= 4) {
                    service.addTransition(tokens[1], tokens[2], tokens[3]);
                } else {
                    System.out.println("Usage: ADD_TRANSITION <from_state> <event> <to_state>");
                }
                break;
            case "TRIGGER_EVENT":
                if (tokens.length >= 2) {
                    service.triggerEvent(tokens[1]);
                } else {
                    System.out.println("Usage: TRIGGER_EVENT <event>");
                }
                break;
            case "SET_FSM_NOTIFICATION":
                if (tokens.length >= 2) {
                    service.setGlobalNotify(Boolean.parseBoolean(tokens[1]));
                } else {
                    System.out.println("Usage: SET_FSM_NOTIFICATION <true/false>");
                }
                break;
            case "SET_STATE_NOTIFICATION":
                if (tokens.length >= 3) {
                    service.setStateNotify(tokens[1], Boolean.parseBoolean(tokens[2]));
                } else {
                    System.out.println("Usage: SET_STATE_NOTIFICATION <state_name> <true/false>");
                }
                break;
            case "PRINT_CURRENT_STATE":
                service.printCurrentState();
                break;
            case "PRINT_TRANSITION_HISTORY":
                service.printTransitionHistory();
                break;
            case "PRINT_FSM":
                service.printFSM();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}