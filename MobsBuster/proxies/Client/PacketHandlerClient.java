package MobsBuster.proxies.Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import MobsBuster.base;
import MobsBuster.Configuracion.Datos;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandlerClient implements IPacketHandler {
	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {

		Minecraft mc = Minecraft.getMinecraft();
		DataInputStream stream = new DataInputStream(new ByteArrayInputStream(
				packet.data));
		try {
			int id = stream.readByte();
			switch (id) {
			case 0: {
			}
			}
		} catch (IOException e) {
		}
	}

	public static void sendPacketPosition(EntityClientPlayerMP player) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Datos.nameMod;
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;

		player.sendQueue.addToSendQueue(packet);

	}
}
