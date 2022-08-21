package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class patCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("pat")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 6) + 1;

                if (n == 1) {
                    imageLink = "https://i.imgur.com/J01NZCa.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/gGfSj84.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/17NzO6G.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/rGMvRNn.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/XuV9dUZ.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/8VniExt.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " pats  " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
