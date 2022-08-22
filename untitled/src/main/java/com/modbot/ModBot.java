package com.modbot;

import com.modbot.Listeners.MentionListener;
import com.modbot.Listeners.commandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.SessionControllerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.utils.tuple.Pair;

import javax.security.auth.login.LoginException;



public class ModBot extends ListenerAdapter {
    private ShardManager shardManager;

    public ModBot() throws LoginException {
        String token = "NzY0MTQwNTI5MDQxNjcwMTU0.GsMEJ-.o1AKMe9EIlUaGJ1sp6Zlcz8ALFpk43alOxqeJg";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.playing("Live without Fear ~ | Cluster [1]"));
        builder.setStatus(OnlineStatus.ONLINE);

        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.enableCache(CacheFlag.ONLINE_STATUS);


        builder.addEventListeners(
                new MentionListener(),
                new commandManager()
        );

        builder.setShardsTotal(10).setShards(0, 9);
        shardManager = builder.build();




    }
    public ShardManager getShardManager(){
        return shardManager;
    }

    public static void main(String[] args) {
        try{
            ModBot bot = new ModBot();
        }catch (LoginException e){
            System.out.println("Erro!" + e);
        }
    }
}


