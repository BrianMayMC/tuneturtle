package me.nootnoot.mctiersadminbackend.managers;

import com.google.gson.Gson;
import lombok.Getter;
import org.springframework.stereotype.Service;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.DefaultRedisCredentials;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;

@Service
public class RedisManager {

    private final JedisPooled jedis;
    @Getter private static final Gson gson = new Gson();

    public RedisManager(){
        DefaultJedisClientConfig config = DefaultJedisClientConfig.builder()
                .credentials(new DefaultRedisCredentials(null, "Puoifdv4bTysSkfzsqKrHajiU3dVEWUgi53rU5QqjCXFk8RZXsX8A7L6rpuQcP273c9Ro9WdLyGAJ7RLJiWuEXVxH87CWpnT"))
                .build();

        HostAndPort address = new HostAndPort("23.139.82.191", 6379);
        jedis = new JedisPooled(address, config);
    }

    public void send(Object object, String channel){
        jedis.publish(channel, gson.toJson(object));
    }
}
