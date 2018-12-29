package com.pncomp.lifegame;

import com.pncomp.lifegame.domain.LifeArea;

public class SimulationEvent {

    public SimulationEventType getType() {
        return type;
    }

    public LifeArea getArea() {
        return area;
    }

    private final SimulationEventType type;

    private final LifeArea area;

    public SimulationEvent(SimulationEventType type, LifeArea area) {
        this.type = type;
        this.area = area;
    }

}
