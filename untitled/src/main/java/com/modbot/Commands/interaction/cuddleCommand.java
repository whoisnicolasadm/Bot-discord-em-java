package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class cuddleCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("cuddle")){
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
                    imageLink = "https://i.imgur.com/HqFckvG.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/pH8TTOd.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/3SqJTbV.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/SVAA1NH.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/6RyqnBL.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/YrMqjtQ.gif";
                }else if (n == 7){
                    imageLink = "https://i.imgur.com/EAk4KtB.gif";
                }else if (n == 8){
                    imageLink = "https://i.imgur.com/FAGX2zs.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " cuddles " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
