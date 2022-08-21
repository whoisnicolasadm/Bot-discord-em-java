package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class killCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("kill")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 5) + 1;

                if (n == 1) {
                    imageLink = "https://i.imgur.com/8Ryi8xQ.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/hGCGVmZ.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/mHTunac.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/xWkNtE5.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/1gVPkev.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " wants to kill " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
