package com.modbot.Commands.ADM;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class serversListCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("server_list")){
            List<Guild> guildsList = event.getJDA().getShardManager().getGuilds();
            EmbedBuilder eb = new EmbedBuilder();

            eb.setDescription("" + guildsList);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
