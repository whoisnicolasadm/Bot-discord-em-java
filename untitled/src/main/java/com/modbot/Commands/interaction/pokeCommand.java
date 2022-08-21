package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class pokeCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("poke")){
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
                    imageLink = "https://i.imgur.com/BWG6gvH.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/xGlwJ3P.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/UD2EUBE.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/rFkrrdg.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/JIWK6Ht.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/rd9p6DQ.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " pokes " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
