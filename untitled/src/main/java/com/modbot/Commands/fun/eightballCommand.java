package com.modbot.Commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class eightballCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("8ball")) {
            int n;

            String user = event.getUser().getAsMention();

            String resposta = null;

            for (int i = 0; i < 33; i++) {
                n = (int) (Math.random() * 11) + 1;

                if (n == 1) {
                    resposta = "Maybe yes";
                } else if (n == 2) {
                    resposta = "No";
                } else if (n == 3) {
                    resposta = "I can't comment on this";
                } else if (n == 4) {
                    resposta = "Maybe no";
                } else if (n == 5) {
                    resposta = "Yes";
                } else if (n == 6) {
                    resposta = "Maybe...";
                } else if (n == 7) {
                    resposta = "I don't know";
                } else if (n == 8) {
                    resposta = "Hmmmmm...";
                } else if (n == 9) {
                    resposta = "My answer is no";
                } else if (n == 10) {
                    resposta = "My answer is yes";
                } else if (n == 11) {
                    resposta = "Definitely";
                } else {
                    resposta = "An error was ocurred";
                }
            }


            EmbedBuilder eb = new EmbedBuilder();
            eb.setDescription("<:modbotzin:991131805212221440> | " + user + " " + resposta);
            event.replyEmbeds(eb.build()).queue();
        }

    }
}
