package MobsBuster.Configuracion;

import java.awt.List;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

import org.lwjgl.input.Keyboard;
import org.objectweb.asm.Type;

import MobsBuster.Auxiliares.Registros;

public class Info extends Registros {
	public static void initConfig(Configuration confi) {
		config = confi;

	}

	public Hashtable initItems() throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		return items;

	}

	public Hashtable initBlocks() throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		return blocks;
	}

	public void initMobs() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

	}

}
