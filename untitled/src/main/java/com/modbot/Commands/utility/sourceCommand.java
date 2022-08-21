package com.modbot.Commands.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class sourceCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("source")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.addField("ModBot source code:", "https://github.com/whoisnicolasadm", false);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
