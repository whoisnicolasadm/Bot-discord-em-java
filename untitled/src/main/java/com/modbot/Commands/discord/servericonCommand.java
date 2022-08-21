package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class servericonCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("servericon")) {
            EmbedBuilder eb = new EmbedBuilder();
            String name = event.getGuild().getName();
            String icon = event.getGuild().getIconUrl();

            if(icon == null){
                eb.setDescription("**<:error:1000814880208715797> | The server does not have an icon to show!**");
                event.replyEmbeds(eb.build()).queue();
            }else{
                eb.setTitle("<:discord:1002019703276974210> " + name);
                eb.setDescription("**Click [here](" + icon + ") to download the image!**");
                eb.setImage(icon);
                event.replyEmbeds(eb.build()).queue();
            }
        }

    }
}
