package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class slapCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("slap")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 7) + 1;

                if (n == 1) {
                    imageLink = "https://i.imgur.com/omhZ2aQ.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/nSDYCNZ.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/bF9ruep.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/1aqwJq4.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/xQYw5E6.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/jyl49EQ.gif";
                }else if (n == 7){
                    imageLink = "https://i.imgur.com/G51eVZr.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " slaps " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
