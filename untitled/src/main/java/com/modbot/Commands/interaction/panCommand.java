package com.modbot.Commands.interaction;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class panCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("pan")){
            OptionMapping optionMapping = event.getOption("user");
            String userMentioned = optionMapping.getAsUser().getName();
            String userAuthor = event.getUser().getName();
            EmbedBuilder eb = new EmbedBuilder();
            String imageLink = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 3) + 1;

                if (n == 1) {
                    imageLink = "https://i.imgur.com/4x3JLai.gif";
                } else if (n == 2) {
                    imageLink = "https://i.imgur.com/3IltdKo.gif";
                } else if (n == 3) {
                    imageLink = "https://i.imgur.com/ruFqQkT.gif";
                }
            }

            eb.setDescription("**" + userAuthor + "**" + " just hit " +  "**" + userMentioned + "** with a pan!");
            eb.setImage(imageLink);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
