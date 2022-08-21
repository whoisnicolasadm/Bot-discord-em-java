package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class laughCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("laugh")){
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
                    imageLink = "https://i.imgur.com/x4tmoDG.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/SQurrBn.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/ztrDzB9.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/zq0RN4l.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/4LOL35L.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/Lcm7Zkx.gif";
                }else if (n == 7){
                    imageLink = "https://i.imgur.com/X1oVvk4.gif";
                }else if (n == 8){
                    imageLink = "https://i.imgur.com/WJVT6J0.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " laughs at " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
