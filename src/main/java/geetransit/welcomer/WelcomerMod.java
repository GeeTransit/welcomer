package geetransit.welcomer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class WelcomerMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Register the function to all player join events
		ServerPlayConnectionEvents.JOIN.register(this::onPlayerJoin);
	}

	public void onPlayerJoin(
			ServerPlayNetworkHandler e,
			PacketSender sender,
			MinecraftServer srv) {
		// Get the player that triggered this event
		ServerPlayerEntity p = e.getPlayer();
		// Get their username
		String username = p.getEntityName();
		// Send them a greeting containing their username
		p.sendMessage(Text.literal("Hi "+username+"! Nice to see you."));
	}
}
