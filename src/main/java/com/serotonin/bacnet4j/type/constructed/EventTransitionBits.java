/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2015 Infinite Automation Software. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * When signing a commercial license with Infinite Automation Software,
 * the following extension to GPL is made. A special exception to the GPL is
 * included to allow you to distribute a combined work that includes BAcnet4J
 * without being obliged to provide the source code for any proprietary components.
 *
 * See www.infiniteautomation.com for commercial license options.
 * 
 * @author Matthew Lohbihler
 */
package com.serotonin.bacnet4j.type.constructed;

import com.serotonin.bacnet4j.type.enumerated.EventState;
import com.serotonin.bacnet4j.type.primitive.BitString;
import com.serotonin.bacnet4j.util.sero.ByteQueue;

public class EventTransitionBits extends BitString {
    private static final long serialVersionUID = 7904969709288399573L;

    public EventTransitionBits(boolean toOffnormal, boolean toFault, boolean toNormal) {
        super(new boolean[] { toOffnormal, toFault, toNormal });
    }

    public EventTransitionBits(ByteQueue queue) {
        super(queue);
    }

    public EventTransitionBits(EventTransitionBits that) {
        super(that);
    }

    public boolean isToOffnormal() {
        return getValue()[0];
    }

    public boolean isToFault() {
        return getValue()[1];
    }

    public boolean isToNormal() {
        return getValue()[2];
    }

    public boolean contains(EventState toState) {
        return getValue(toState.getTransitionIndex());
    }
}
