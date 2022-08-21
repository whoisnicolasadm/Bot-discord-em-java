package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class handHoldCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("hand_hold")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 4) + 1;

                if (n == 1) {
                    imageLink = "https://imgur.com/fk8RpWF.gif";
                } else if (n == 2) {
                    imageLink = "https://imgur.com/4p4afJU.gif";
                } else if (n == 3) {
                    imageLink = "https://imgur.com/O9Zi3TB.gif";
                }else if (n == 4){
                    imageLink = "https://imgur.com/SHY2BPh.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " holds hands with " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
