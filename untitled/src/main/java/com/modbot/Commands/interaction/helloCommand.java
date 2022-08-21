package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class helloCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("hello")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 8) + 1;

                if (n == 1) {
                    imageLink = "https://i.imgur.com/odFyo1Q.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/KyQN1RR.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/LDxsTxv.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/czWxIkd.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/DIeaddE.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/lUfKcOK.gif";
                }else if (n == 7){
                    imageLink = "https://i.imgur.com/bwwasl2.gif";
                }else if (n == 8){
                    imageLink = "https://i.imgur.com/cYsTgNK.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " says hello to " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
