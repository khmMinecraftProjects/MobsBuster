package MobsBuster.proxies.Server;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import MobsBuster.Configuracion.Datos;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TickHandlerServer implements ITickHandler {
	public long clock;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

		if (type.equals(EnumSet.of(TickType.WORLD))) {
			preWorldTick((WorldServer) tickData[0]);
		} else if (type.equals(EnumSet.of(TickType.PLAYER))) {
			prePlayerTick(
					(WorldServer) ((EntityPlayerMP) tickData[0]).worldObj,
					(EntityPlayerMP) tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.WORLD))) {
			worldTick((WorldServer) tickData[0]);
		} else if (type.equals(EnumSet.of(TickType.PLAYER))) {
			playerTick((WorldServer) ((EntityPlayerMP) tickData[0]).worldObj,
					(EntityPlayerMP) tickData[0]);
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.WORLD, TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "TickHandlerServer" + Datos.nameMod;
	}

	public void worldTick(WorldServer world) {
		if (clock != world.getWorldTime()) {
			clock = world.getWorldTime();
		}
	}

	public void preWorldTick(WorldServer world) {

	}

	public void prePlayerTick(WorldServer world, EntityPlayerMP player) {

	}

	public void playerTick(WorldServer world, EntityPlayerMP player) {

	}

}