package MobsBuster.proxies.Client;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import MobsBuster.Configuracion.Datos;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.main.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.EntityRendererProxy;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class TickHandlerClient implements ITickHandler {
	public float renderTick;

	public TickHandlerClient() {

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.WORLD, TickType.PLAYER, TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "TickHandlerClient" + Datos.nameMod;
	}

	public void preWorldTick(WorldServer world) {
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.CLIENT))) {
			if (Minecraft.getMinecraft().theWorld != null) {
				preWorldTick(Minecraft.getMinecraft(),
						Minecraft.getMinecraft().theWorld);
			}
		} else if (type.equals(EnumSet.of(TickType.PLAYER))) {
			prevPlayerTick((World) ((EntityPlayer) tickData[0]).worldObj,
					(EntityPlayer) tickData[0]);
		} else if (type.equals(EnumSet.of(TickType.RENDER))) {
			if (Minecraft.getMinecraft().theWorld != null) {
				preRenderTick(Minecraft.getMinecraft(),
						Minecraft.getMinecraft().theWorld, (Float) tickData[0]); // only
																					// ingame
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.CLIENT))) {
			if (Minecraft.getMinecraft().theWorld != null) {
				worldTick(Minecraft.getMinecraft(),
						Minecraft.getMinecraft().theWorld);
			}
		} else if (type.equals(EnumSet.of(TickType.PLAYER))) {
			if (tickData[0] instanceof EntityPlayer) {
				playerTick((World) ((EntityPlayer) tickData[0]).worldObj,
						(EntityPlayer) tickData[0]);
			}
		} else if (type.equals(EnumSet.of(TickType.RENDER))) {
			if (Minecraft.getMinecraft().theWorld != null) {
				renderTick(Minecraft.getMinecraft(),
						Minecraft.getMinecraft().theWorld, (Float) tickData[0]); // only
																					// ingame
			}
		}
	}

	public void preWorldTick(Minecraft mc, WorldClient world) {

	}

	public void worldTick(Minecraft mc, WorldClient world) {
	}

	public void prevPlayerTick(World world, EntityPlayer player) {

	}

	public static boolean isPressed(int key) {
		if (key < 0) {
			return Mouse.isButtonDown(key + 100);
		}
		return Keyboard.isKeyDown(key);
	}

	public void playerTick(World world, EntityPlayer player) {

	}

	public void preRenderTick(Minecraft mc, World world, float renderTick) {

	}

	public void renderTick(Minecraft mc, World world, float tickData) {
		this.renderTick = tickData;

	}

}