package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class hugCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("hug")){
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
                    imageLink = "https://i.imgur.com/aBdIEEu.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/03grRGj.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/EuIBiLi.gif";
                }else if (n == 4){
                    imageLink = "https://i.imgur.com/8KgVR9j.gif";
                }else if (n == 5){
                    imageLink =  "https://i.imgur.com/ZepPo0t.gif";
                }else if (n == 6){
                    imageLink = "https://i.imgur.com/iIsFQ3q.gif";
                }else if (n == 7){
                    imageLink = "https://i.imgur.com/XHhFoR1.gif";
                }else if (n == 8){
                    imageLink = "https://i.imgur.com/psGdps5.gif";
                }else if (n == 9){
                    imageLink = "https://i.imgur.com/OPKBDeA.gif";
                }else if (n == 10){
                    imageLink = "https://i.imgur.com/D0GABc2.gif";
                }else if (n == 11){
                    imageLink = "https://i.imgur.com/LtVBCX3.gif";
                }else if (n == 12){
                    imageLink = "https://i.imgur.com/o8JQtVL.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " hugs " +  "**" + userMentioned + "**");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
