package com.miorg.primermod.events;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.miorg.primermod.init.InitItems.*;

public class MisHechizos {

    @SubscribeEvent
    public void varaHielo(PlayerInteractEvent.LeftClickBlock event){
        var item = event.getItemStack();

        if (event.getSide().isServer()){
            MinecraftServer server = event.getEntity().getServer();
            if(item.is(VARA_HIELO.get())&& server != null){
                var stack = server.createCommandSourceStack();
                var pos = event.getEntity().position();
                var command = "fill " + (int)(pos.x - 10) + " " + (int)(pos.y - 10) + " " + (int)(pos.z - 10) + " " + (int)(pos.x + 10) + " " + (int)(pos.y + 10) + " " + (int)(pos.z + 10) + " minecraft:ice replace minecraft:water";
                server.getCommands().performCommand(stack, command);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void varaLava (PlayerInteractEvent.LeftClickBlock event){
        var item = event.getItemStack();

        if (event.getSide().isServer()){
            MinecraftServer server = event.getEntity().getServer();
            if(item.is(VARA_LAVA.get())&& server != null){
                var stack = server.createCommandSourceStack();
                var pos = event.getEntity().position();
                var command = "fill " + (int)(pos.x - 10) + " " + (int)(pos.y - 10) + " " + (int)(pos.z - 10) + " " + (int)(pos.x + 10) + " " + (int)(pos.y + 10) + " " + (int)(pos.z + 10) + " minecraft:lava replace minecraft:grass_block";
                server.getCommands().performCommand(stack, command);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void varaMarina (PlayerInteractEvent.RightClickBlock event){
        var item = event.getItemStack();
        if (event.getSide().isServer()) {
            MinecraftServer server = event.getEntity().getServer();
            if(item.is(VARA_MARINA.get())&& server != null){
                var stack = server.createCommandSourceStack();
                var pos = event.getEntity().position();
                var command1 = "effect give " + event.getEntity().getName().getString() + " minecraft:dolphins_grace 50 7" ;
                var command2 = "effect give " + event.getEntity().getName().getString() + " minecraft:conduit_power 50 7" ;
                var command3 = "effect give " + event.getEntity().getName().getString() + " minecraft:night_vision 50" ;
                var command4 = "effect give " + event.getEntity().getName().getString() + " minecraft:water_breathing 50 7" ;
                server.getCommands().performCommand(stack, command1);
                server.getCommands().performCommand(stack, command2);
                server.getCommands().performCommand(stack, command3);
                server.getCommands().performCommand(stack, command4);


                event.setCanceled(true);
            }
        }

    }
    @SubscribeEvent
    public void varaMov(PlayerInteractEvent.RightClickBlock event) {
        var item = event.getItemStack();
        if (event.getSide().isServer()) {
            MinecraftServer server = event.getEntity().getServer();
            if (item.is(VARA_MOV.get()) && server != null) {
                var stack = server.createCommandSourceStack();
                var pos = event.getEntity().position();
                var command1 = "effect give " + event.getEntity().getName().getString() + " minecraft:speed 50 7";
                var command2 = "effect give " + event.getEntity().getName().getString() + " minecraft:jump_boost 50 4";
                var command3 = "effect give " + event.getEntity().getName().getString() + " minecraft:invisibility 50";
                server.getCommands().performCommand(stack, command1);
                server.getCommands().performCommand(stack, command2);
                server.getCommands().performCommand(stack, command3);


                event.setCanceled(true);
            }
        }
    }

        @SubscribeEvent
        public void varaFuerza(PlayerInteractEvent.RightClickBlock event){
            var item = event.getItemStack();
            if (event.getSide().isServer()) {
                MinecraftServer server = event.getEntity().getServer();
                if(item.is(VARA_FUERZA.get())&& server != null){
                    var stack = server.createCommandSourceStack();
                    var pos = event.getEntity().position();
                    var command1 = "effect give " + event.getEntity().getName().getString() + " minecraft:strength 50 7" ;
                    var command2 = "effect give " + event.getEntity().getName().getString() + " minecraft:regeneration 50" ;
                    var command3 = "effect give " + event.getEntity().getName().getString() + " minecraft:fire_resistant 50" ;
                    var command4 = "effect give " + event.getEntity().getName().getString() + " minecraft:resistance 50 4" ;
                    server.getCommands().performCommand(stack, command1);
                    server.getCommands().performCommand(stack, command2);
                    server.getCommands().performCommand(stack, command3);
                    server.getCommands().performCommand(stack, command4);

                    event.setCanceled(true);
                }
        }
    }

}
