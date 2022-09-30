package com.modbot.Commands.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class anagramCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {



        var invoke = event.getName();

        if (invoke.equals("anagram")) {
            OptionMapping optionMapping = event.getOption("word");
            EmbedBuilder eb = new EmbedBuilder();
            String word = optionMapping.getAsString();
            String user = event.getUser().getAsMention();

            long wL = word.length();
            long f = wL;

            List<String> letters = Arrays.asList(word.split(""));
            Collections.shuffle(letters);
            StringBuilder t = new StringBuilder(word.length());
            for (String k : letters) {
                t.append(k);
            }
            t.toString();

            if (wL > 20) {
                eb.setDescription("<:dce_textEdit:1000815394711421071>**| " + user + " Your anagram is: **`" + t + "`\n<:modbotzin:991131805212221440>| " + user + " The word has more anagrams than I can count");
            }

            while (wL > 1) {
                f = f * (wL - 1);
                wL--;
            }


            eb.setDescription("<:dce_textEdit:1000815394711421071>**| " + user + " Your anagram is: **`" + t + "`\n<:modbotzin:991131805212221440>| " + user + " The word `" + word + "` has **" + f + " different anagrams**");


            event.replyEmbeds(eb.build()).queue();
        }
    }
}
