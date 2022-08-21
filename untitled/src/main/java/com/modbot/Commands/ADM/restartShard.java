package com.modbot.Commands.ADM;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class restartShard extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("restart_shard")){
            OptionMapping optionMapping = event.getOption("shardid");
            String shardId = optionMapping.getAsString();
            event.getJDA().getShardManager().start(6);
            event.reply("shard reiniciada com sucesso! shard reiniciada: " + shardId).queue();
        }
    }
}
