package com.machinecoding.model;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class State {
    private final String name;
    private final boolean isEndState;
    @Setter
    private boolean notifyEnabled;
    private final Map<String, State> transitions = new HashMap<>();

    public State(String name, boolean isEndState, boolean notifyEnabled) {
        this.name = name;
        this.isEndState = isEndState;
        this.notifyEnabled = notifyEnabled;
    }

    public void addTransition(String event, State toState) {
        transitions.put(event, toState);
    }

    public State getNextState(String event) {
        return transitions.get(event);
    }

}