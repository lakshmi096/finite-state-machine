package com.machinecoding.model;

import lombok.Getter;

@Getter
public class Transition {
    private final State fromState;
    private final String event;
    private final State toState;

    public Transition(State fromState, String event, State toState) {
        this.fromState = fromState;
        this.event = event;
        this.toState = toState;
    }

}