package com.modbot.Commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class coinflipCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("coinflip")) {
            int n;

            String user = event.getUser().getAsMention();

            String cf = null;

            for (int i = 0; i < 52; i++) {
                n = (int) (Math.random() * 2) + 1;

                if (n == 1) {
                    cf = "Head";
                } else if (n == 2) {
                    cf = "Tails";
                } else {
                    cf = "An error was ocurred";
                }
            }
            if (cf == "Head") {
                EmbedBuilder ebC = new EmbedBuilder();
                ebC.setDescription("<:coinDc:877350503493824542> | " + user + " " + cf);
                event.replyEmbeds(ebC.build()).queue();
            } else if (cf == "Tails") {
                EmbedBuilder ebT = new EmbedBuilder();
                ebT.setDescription("<:miyuu_coin:877350535466975272> | " + user + " " + cf);
                event.replyEmbeds(ebT.build()).queue();
            } else {
                event.reply("An error was ocurred").queue();
            }
        }

    }
}
