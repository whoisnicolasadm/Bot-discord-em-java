package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class avatarCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("avatar")){
            EmbedBuilder eb = new EmbedBuilder();
            OptionMapping optionMapping = event.getOption("user");
            String icon;
            String name;

            if(optionMapping == null){
                icon = event.getUser().getAvatarUrl();
                name = event.getUser().getName();
                eb.setTitle("<:discord:1002019703276974210> " + name);
                eb.setDescription("**Click [here](" + icon + ") to download the image!**");
                eb.setImage(icon);
                event.replyEmbeds(eb.build()).queue();
            }else{
                icon = optionMapping.getAsUser().getAvatarUrl();
                name = optionMapping.getAsUser().getName();
                eb.setTitle("<:discord:1002019703276974210> " + name);
                eb.setDescription("**Click [here](" + icon + ") to download the image!**");
                eb.setImage(icon);
                event.replyEmbeds(eb.build()).queue();
            }
            if(icon == null){
                eb.setDescription("**<:error:1000814880208715797> | The server does not have an icon to show!**");
                event.replyEmbeds(eb.build()).queue();
            }
        }
    }
}
