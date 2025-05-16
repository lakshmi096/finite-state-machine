package com.machinecoding.service;


import com.machinecoding.model.FSM;

public class FSMService {
    private final FSM fsm = new FSM();

    public void addState(String name, boolean isEndState, boolean notifyEnabled) {
        fsm.addState(name, isEndState, notifyEnabled);
    }

    public void setStartState(String name) {
        fsm.setStartState(name);
    }

    public void addTransition(String from, String event, String to) {
        fsm.addTransition(from, event, to);
    }

    public void triggerEvent(String event) {
        fsm.triggerEvent(event);
    }

    public void setGlobalNotify(boolean enabled) {
        fsm.setGlobalNotify(enabled);
    }

    public void setStateNotify(String stateName, boolean enabled) {
        fsm.setStateNotify(stateName, enabled);
    }

    public void printCurrentState() {
        fsm.printCurrentState();
    }

    public void printTransitionHistory() {
        fsm.printTransitionHistory();
    }

    public void printFSM() {
        fsm.printFSM();
    }
}
