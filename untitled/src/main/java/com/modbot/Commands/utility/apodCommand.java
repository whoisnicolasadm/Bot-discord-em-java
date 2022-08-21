package com.modbot.Commands.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class apodCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("apod")) {
            URL url;
            EmbedBuilder eb = new EmbedBuilder();
            try {
                url = new URL("https://api.nasa.gov/planetary/apod?api_key=bgw5YkLmHL56C59yb0BDCtYBabvMsSbm5DZBIqnA");
                Object content = url.getContent();
                System.out.println(content);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {

                HttpURLConnection http = (HttpURLConnection)url.openConnection();
                String content = http.getHeaderField(2);
                eb.setDescription(content);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
