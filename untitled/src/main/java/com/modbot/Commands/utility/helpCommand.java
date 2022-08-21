package com.modbot.Commands.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class helpCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("help")) {
            String user = event.getMember().getUser().getAsMention();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("<:modbotzin:991131805212221440>Help ModBot");
            eb.setDescription("Hello " + user + ", my name is ModBot, I'm only a simple bot for Discord\n" +
                    "\nWith social and fun features to entertain and engage your member, moderate features to keep your server always safe and enjoyable, and an easy way to configure but with unparalleled customization power...");
            eb.addField("<:commands:1002581823425105970>**Command List**", "[ModBot Command List](https://joasknuicolas.wixsite.com/modbot)", false);
            eb.addField("<:task:1002583115392368742>**Do you have doubts? Ask my Support Server!**", "[ModBot Official Support Server](https://discord.com/invite/7XGwzTGDka)", false);
            event.replyEmbeds(eb.build()).queue();
        }

    }
}
