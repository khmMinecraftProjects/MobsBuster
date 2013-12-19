package MobsBuster.Auxiliares;

import MobsBuster.base;
import MobsBuster.Configuracion.Datos;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs {

	public Tab(String label) {
		super(label);

	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return 1;// base.items.get(Datos.getI("")).itemID;
	}

	public String getTranslatedTabLabel() {
		return this.getTabLabel();
	}

}
