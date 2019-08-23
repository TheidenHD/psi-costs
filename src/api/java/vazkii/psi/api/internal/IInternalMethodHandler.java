/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: http://psi.vazkii.us/license.php
 *
 * File Created @ [13/01/2016, 16:58:15 (GMT)]
 */
package vazkii.psi.api.internal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.psi.api.spell.*;

import java.util.List;

public interface IInternalMethodHandler {

	/**
	 * Gets the player data for a given player. Player Data contains info such as the
	 * player's Psi value or level.
	 */
	IPlayerData getDataForPlayer(EntityPlayer player);

	/**
	 * Gets the texture for the programmer. Used for drawing the arrows in a SpellPiece's
	 * params.
	 */
	ResourceLocation getProgrammerTexture();

	/**
	 * Gets an instance of a spell compiler. In most cases, you should use {@link #getSpellCache()} instead.
	 */
	ISpellCompiler getCompiler(Spell spell);

	/**
	 * Gets the singleton instance of the spell cache.
	 */
	ISpellCache getSpellCache();

	/**
	 * Delays a spell context.
	 */
	void delayContext(SpellContext context);

	/**
	 * Sets the crash handler data, in case the spell hard-crashes.
	 */
	void setCrashData(CompiledSpell spell, SpellPiece piece);

	@SideOnly(Side.CLIENT)
	void renderTooltip(int x, int y, List<String> tooltipData, int color, int color2);

	/**
	 * Localizes a string, with correct behavior on both server and client.
	 */
	String localize(String key, Object... format);

	ItemStack createDefaultCAD(List<ItemStack> components);

	ItemStack createCAD(ItemStack base, List<ItemStack> components);
}
