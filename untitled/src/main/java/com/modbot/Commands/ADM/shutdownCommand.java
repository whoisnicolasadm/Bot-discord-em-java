package com.modbot.Commands.ADM;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class shutdownCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("shutdown_shard")){
            OptionMapping optionMapping = event.getOption("shardid");
            String shardId = optionMapping.getAsString();
            event.getJDA().getShardManager().getShardById(shardId).shutdownNow();
            event.reply("shard desligada com sucesso! shard desligada: " + shardId).queue();
        }
    }
}
