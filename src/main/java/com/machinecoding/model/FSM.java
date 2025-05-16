package com.machinecoding.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FSM {
    private final Map<String, State> states = new HashMap<>();
    private State startState;
    private State currentState;
    private boolean globalNotifyEnabled = false;
    private final List<String> transitionHistory = new ArrayList<>();

    public void addState(String name, boolean isEndState, boolean notifyEnabled) {
        states.put(name, new State(name, isEndState, notifyEnabled));
    }

    public void setStartState(String name) {
        startState = states.get(name);
        currentState = startState;
    }

    public void addTransition(String from, String event, String to) {
        State fromState = states.get(from);
        State toState = states.get(to);
        if (fromState != null && toState != null) {
            fromState.addTransition(event, toState);
        }
    }

    public void triggerEvent(String event) {
        if (currentState == null) {
            System.out.println("Start state not set.");
            return;
        }
        State nextState = currentState.getNextState(event);
        if (nextState != null) {
            currentState = nextState;
            transitionHistory.add(currentState.getName());
            if (globalNotifyEnabled && currentState.isNotifyEnabled()) {
                System.out.println("Notification: Entered state " + currentState.getName());
            }
        } else {
            System.out.println("No transition found for event: " + event);
        }
    }

    public void setGlobalNotify(boolean enabled) {
        globalNotifyEnabled = enabled;
    }

    public void setStateNotify(String stateName, boolean enabled) {
        State state = states.get(stateName);
        if (state != null) {
            state.setNotifyEnabled(enabled);
        }
    }

    public void printCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.getName());
        } else {
            System.out.println("Current State: None");
        }
    }

    public void printTransitionHistory() {
        System.out.println("Transition History: " + transitionHistory);
    }

    public void printFSM() {
        System.out.println("FSM Configuration:");
        for (State state : states.values()) {
            System.out.println("State: " + state.getName() + ", EndState: " + state.isEndState() + ", Notify: " + state.isNotifyEnabled());
            for (Map.Entry<String, State> entry : state.getTransitions().entrySet()) {
                System.out.println("  On Event '" + entry.getKey() + "' -> " + entry.getValue().getName());
            }
        }
    }
}
