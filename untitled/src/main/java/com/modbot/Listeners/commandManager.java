package com.modbot.Listeners;

import com.modbot.Commands.ADM.serversListCommand;
import com.modbot.Commands.ADM.shutdownCommand;
import com.modbot.Commands.bot.botinfoCommand;
import com.modbot.Commands.bot.pingCommand;
import com.modbot.Commands.bot.shardsCommand;

import com.modbot.Commands.bot.statsCommand;
import com.modbot.Commands.discord.*;

import com.modbot.Commands.fun.cancelledCommand;

import com.modbot.Commands.fun.coinflipCommand;

import com.modbot.Commands.fun.eightballCommand;

import com.modbot.Commands.fun.jankenponCommand;

import com.modbot.Commands.interaction.*;
import com.modbot.Commands.staff.*;

import com.modbot.Commands.utility.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class commandManager extends ListenerAdapter {



    @Override
    public void onReady(@NotNull ReadyEvent event) {

        List<CommandData> commandData = new ArrayList<>();
        event.getJDA().addEventListener(
                new pingCommand(),
                new avatarCommand(),
                new helpCommand(),
                new botinfoCommand(),
                new serverinfoCommand(),
                new userinfoCommand(),
                new servericonCommand(),
                new inviteCommand(),
                new jankenponCommand(),
                new coinflipCommand(),
                new eightballCommand(),
                new cancelledCommand(),
                new anagramCommand(),
                new lockCommand(),
                new unlockCommand(),
                new apodCommand(),
                new renamechannelCommand(),
                new deletechannelCommand(),
                new shardsCommand(),
                new sourceCommand(),
                new feedbackCommand(),
                new BiteCommand(),
                new cuddleCommand(),
                new shrugCommand(),
                new handHoldCommand(),
                new helloCommand(),
                new highfiveCommand(),
                new hugCommand(),
                new killCommand(),
                new kissCommand(),
                new laughCommand(),
                new panCommand(),
                new patCommand(),
                new pokeCommand(),
                new punchCommand(),
                new triggeredCommand(),
                new blushCommand(),
                new slapCommand(),
                new channelInfoCommand(),
                new statsCommand()
        );


        //options data
        OptionData optionName2 = new OptionData(OptionType.STRING, "name", "value", true);
        OptionData optionFeedback = new OptionData(OptionType.STRING, "feedback", "value", true);
        OptionData optionChannel = new OptionData(OptionType.CHANNEL, "channel", "value", true);
        OptionData optionUser = new OptionData(OptionType.USER, "user", "valuer", false);
        OptionData optionUser2 = new OptionData(OptionType.USER, "user", "value", true);
        OptionData optionName = new OptionData(OptionType.STRING, "word", "value", true);
        OptionData optionAsk = new OptionData(OptionType.STRING, "doubt", "value", true);
        OptionData optionValue = new OptionData(OptionType.STRING, "value", "value", true).addChoice("Rock", "Rock").addChoice("Paper", "Paper").addChoice("Scissors", "Scissors");

        //registering commands

        //staff commands
        commandData.add(Commands.slash("rename_channel", "ΓStaff⅃ Rename the selected channel").addOptions(optionChannel, optionName2));
        commandData.add(Commands.slash("delete_channel", "ΓStaff⅃ Delete the selected channel").addOptions(optionChannel));
        commandData.add(Commands.slash("lock", "ΓStaff⅃ Lock the channel"));
        commandData.add(Commands.slash("unlock", "ΓStaff⅃ Unlock the channel"));


        //utility commands
        commandData.add(Commands.slash("ping", "ΓUtility⅃ ModBot Ping"));
        commandData.add(Commands.slash("help", "ΓUtility⅃ ModBot Help"));
        commandData.add(Commands.slash("botinfo", "ΓUtility⅃ ModBot info"));
        commandData.add(Commands.slash("source", "ΓUtility⅃ View ModBot source code on GitHub"));
        commandData.add(Commands.slash("anagram", "ΓUtility⅃ Get name or word anagram").addOptions(optionName));
        commandData.add(Commands.slash("feedback", "ΓUtility⅃ Give feedback about the bot to the creator").addOptions(optionFeedback));
        commandData.add(Commands.slash("apod", "ΓUtility⅃ Astronomic picture of the day"));

        //Discord commands
        commandData.add(Commands.slash("serverinfo", "ΓDiscord⅃ server informations"));
        commandData.add(Commands.slash("userinfo", "ΓDiscord⅃ Get the user info").addOptions(optionUser));
        commandData.add(Commands.slash("avatar", "ΓDiscord⅃ Get the user avatar").addOptions(optionUser));
        commandData.add(Commands.slash("servericon", "ΓDiscord⅃ Get the server icon"));
        commandData.add(Commands.slash("channel_info", "ΓDiscord⅃ Get information about some channel").addOptions(optionChannel));



        //fun commands
        commandData.add(Commands.slash("jankenpon", "ΓFun⅃ Play Rock, Paper or Scissors! (Or, as how the weebs call it, jankenpon)").addOptions(optionValue));
        commandData.add(Commands.slash("8ball", "ΓFun⅃ Ask me anything").addOptions(optionAsk));
        commandData.add(Commands.slash("coinflip", "ΓFun⅃ Let me flip acoin and see if it will land on heads or tails!"));
        commandData.add(Commands.slash("cancelled", "ΓFun⅃ Your best friend was cancelled by Twitter's cancel culture! But... why were they cancelled?").addOptions(optionUser2));

        //bot commands
        commandData.add(Commands.slash("shards", "ΓBot⅃ View all ModBot shards stats"));
        commandData.add(Commands.slash("invite", "ΓBot⅃ Invite ModBot to your server"));
        commandData.add(Commands.slash("stats", "ΓBot⅃ ModBot stats"));

        //Interaction commands
        commandData.add(Commands.slash("bite", "ΓSocial⅃ bite some user").addOptions(optionUser2));
        commandData.add(Commands.slash("blush", "ΓSocial⅃ blush at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("cuddle", "ΓSocial⅃ cuddle some user").addOptions(optionUser2));
        commandData.add(Commands.slash("hand_hold", "ΓSocial⅃ hold some user's hand").addOptions(optionUser2));
        commandData.add(Commands.slash("hello", "ΓSocial⅃ say hello to some user").addOptions(optionUser2));
        commandData.add(Commands.slash("high_five", "ΓSocial⅃ Send a high five to some user").addOptions(optionUser2));
        commandData.add(Commands.slash("hug", "ΓSocial⅃ hug some user").addOptions(optionUser2));
        commandData.add(Commands.slash("kill", "ΓSocial⅃ kill some user").addOptions(optionUser2));
        commandData.add(Commands.slash("kiss", "ΓSocial⅃ kiss some user").addOptions(optionUser2));
        commandData.add(Commands.slash("laugh", "ΓSocial⅃ laugh at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("pan", "ΓSocial⅃ hit some user with a pan").addOptions(optionUser2));
        commandData.add(Commands.slash("pat", "ΓSocial⅃ pat some user").addOptions(optionUser2));
        commandData.add(Commands.slash("poke", "ΓSocial⅃ Poke some user").addOptions(optionUser2));
        commandData.add(Commands.slash("punch", "ΓSocial⅃ Punch some user").addOptions(optionUser2));
        commandData.add(Commands.slash("shrug", "ΓSocial⅃ Shrug at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("slap", "ΓSocial⅃ Slap some user").addOptions(optionUser2));
        commandData.add(Commands.slash("triggered", "ΓSocial⅃ Be triggered by some user").addOptions(optionUser2));

        event.getJDA().updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        event.getJDA().addEventListener(
                new shutdownCommand(),
                new serversListCommand()
        );

        if(event.getGuild().getId().equals("991347975362195596")){
            OptionData shardId = new OptionData(OptionType.STRING, "shardid", "none", true);
            OptionData shardId2 = new OptionData(OptionType.STRING, "shardid", "none", true);
            commandData.add(Commands.slash("shutdown_shard", "none").addOptions(shardId));
            commandData.add(Commands.slash("server_list", "none"));
            event.getGuild().updateCommands().addCommands(commandData).queue();
        }
    }
}
