package com.pncomp.lifegame.proliferators;

import com.pncomp.lifegame.domain.LifeField;

/**
 * This class is responsible for defining proliferation mechanisms of the organisms.
 */
public interface Proliferator {

    void proliferateFromField(LifeField field, LifeField[] adjecents);
}
