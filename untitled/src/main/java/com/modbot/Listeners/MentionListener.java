package com.modbot.Listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MentionListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        String user = event.getAuthor().getAsMention();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("<:modbotzin:991131805212221440>Help ModBot");
        eb.setDescription("Hello " + user + ", my name is ModBot, I'm only a simple bot for Discord\n" +
                "\nWith social and fun features to entertain and engage your member, moderate features to keep your server always safe and enjoyable, and an easy way to configure but with unparalleled customization power...");
        if(message[0].contentEquals("<@764140529041670154>")){
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }

    }
}
