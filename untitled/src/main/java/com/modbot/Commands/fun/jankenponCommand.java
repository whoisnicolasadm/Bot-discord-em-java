package com.modbot.Commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class jankenponCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("jankenpon")){
            OptionMapping optionMapping = event.getOption("value");
            String choose = optionMapping.getAsString();
            String emoji = null;
            String emoji2 = null;
            String emoji3 = null;
            String answer = null;
            String frase = null;

            int n;
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 3) + 1;

                if (n == 1) {
                    answer = "Rock";
                    emoji2 = "\uD83E\uDEA8";
                } else if (n == 2) {
                    answer = "Paper";
                    emoji2 = "<:paper:1003062519352545442>";


                } else if (n == 3) {
                    answer = "Scissors";
                    emoji2 = "✂";
                }

            }


            if (choose.equals("Rock")) {
                emoji = "\uD83E\uDEA8";


            } else if (choose.equals("Paper")) {
                emoji = "<:paper:1003062519352545442>";


            } else if (choose.equals("Scissors")) {
                emoji = "✂";


            }

            //win cases
            if (choose.equals(answer)) {
                frase = "**\uD83D\uDD37| Draw! How about a rematch**";
                emoji3 = "\uD83C\uDFF3";
            } else if (choose.equals("Rock") && Objects.equals(answer, "Scissors")) {
                frase = "**\uD83D\uDD37| Congratulations, you win!**";
                emoji3 = "\uD83C\uDF89";
            } else if (choose.equals("Paper") && Objects.equals(answer, "Rock")) {
                frase = "**\uD83D\uDD37| Congratulations, you win!**";
                emoji3 = "\uD83C\uDF89";
            } else if (choose.equals("Scissors") && Objects.equals(answer, "Paper")) {
                frase = "**\uD83D\uDD37| Congratulations, you win!**";
                emoji3 = "\uD83C\uDF89";
            }//lose cases
            else if (choose.equals("Scissors") && Objects.equals(answer, "Rock")) {
                frase = "**\uD83D\uDD37| What a pity... you lost, but what matters is that you at least tried!**";
                emoji3 = "\uD83C\uDFF4\u200D";
            } else if (choose.equals("Rock") && Objects.equals(answer, "Paper")) {
                frase = "**\uD83D\uDD37| What a pity... you lost, but what matters is that you at least tried!**";
                emoji3 = "\uD83C\uDFF4\u200D";
            } else if (choose.equals("Paper") && Objects.equals(answer, "Scissors")) {
                frase = "**\uD83D\uDD37| What a pity... you lost, but what matters is that you at least tried!**";
                emoji3 = "\uD83C\uDFF4\u200D";
            }

            EmbedBuilder eb = new EmbedBuilder();
            eb.setDescription(emoji3 + "| You choose " + emoji + ", I choose " + emoji2 + "\n" + frase);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
