package com.modbot.Commands.utility;

import com.mysql.cj.xdevapi.JsonParser;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class apodCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("apod")) {
            EmbedBuilder eb = new EmbedBuilder();
            JsonParser parser = new JsonParser();
            String title;
            String imageurl;
            String date;

            try{
                URL apodUrl = new URL("https://api.nasa.gov/planetary/apod?api_key=3Njztm2mHf9fbaMBpVrOVLIOOaXXIVtal9CcYrGr");
                BufferedReader bf = new BufferedReader(new InputStreamReader(apodUrl.openConnection().getInputStream()));
                String input = bf.readLine();

                title = input.substring(input.indexOf("\"title\":") + "\"title\":\"".length(), input.indexOf("\",\"url\":"));
                imageurl = input.substring(input.indexOf("\"url\":\"") + "\"url\":\"".length());
                date = input.substring(input.indexOf("\"date\":\"") + "\"date\":\"".length());

                imageurl = imageurl.substring(0, imageurl.length() - 2);

                eb.setTitle(title);
                eb.setImage(imageurl);
                eb.setDescription("**For more details: [click here!](https://apod.nasa.gov/apod/astropix.html)**");
                event.replyEmbeds(eb.build()).queue();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }
}
