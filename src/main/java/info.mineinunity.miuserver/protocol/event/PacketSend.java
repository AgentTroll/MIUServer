/*
 * This file is part of MIUServer.
 *
 * Contact: woodyc40(at)gmail(dot)com
 * 
 * Copyright (C) 2013 AgentTroll
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
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package info.mineinunity.miuserver.protocol.event;

import info.mineinunity.miuserver.framework.ClientObjectStream;
import info.mineinunity.miuserver.protocol.Packet;

public class PacketSend implements Event<PacketSend> {

    private final Packet packet;
    private final ClientObjectStream destination;

    public PacketSend(Packet packet, ClientObjectStream destination) {
        this.packet = packet;
        this.destination = destination;
    }

    public Packet getPacket() {
        return packet;
    }

    public ClientObjectStream getDestination() {
        return destination;
    }

    @Override
    public void onEvent(Event<PacketSend> e) {

    }

    @Override
    public Event<PacketSend> getType() {
        return this;
    }
}
