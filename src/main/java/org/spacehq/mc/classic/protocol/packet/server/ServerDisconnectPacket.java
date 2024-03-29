package org.spacehq.mc.classic.protocol.packet.server;

import org.spacehq.mc.classic.protocol.packet.ClassicPacketUtil;
import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import java.io.IOException;

public class ServerDisconnectPacket implements Packet {
	private String reason;

	@SuppressWarnings("unused")
	private ServerDisconnectPacket() {
	}

	public ServerDisconnectPacket(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return this.reason;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.reason = ClassicPacketUtil.readString(in);
	}

	@Override
	public void write(NetOutput out) throws IOException {
		ClassicPacketUtil.writeString(out, this.reason);
	}

	@Override
	public boolean isPriority() {
		return true;
	}
}
