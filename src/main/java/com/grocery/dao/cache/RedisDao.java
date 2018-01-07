package com.grocery.dao.cache;

import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.grocery.domain.NavigatationMenu;
import com.grocery.utilities.SerializationUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Repository
public class RedisDao {

    @Autowired
    private JedisPool jedisPool;

    private final Logger logger = LoggerFactory.getLogger(RedisDao.class);

    public String putNavigatationMenu(List<NavigatationMenu> navigatationMenus) {

        Jedis jedis = null;

        try {
            String key = "navigatationMenus";
            int timeout = 60 * 60;

            byte[] bytes = SerializationUtility.serializeList(new SerializationUtility.CacheList(navigatationMenus));

            jedis = jedisPool.getResource();
            return jedis.setex(key.getBytes(),timeout,bytes);

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }

        return "failed";
    }

    public List<NavigatationMenu> getNavigatationMenus() {

        Jedis jedis = null;
        List<NavigatationMenu> navigatationMenus = null;

        try {
            jedis = jedisPool.getResource();

            String key = "navigatationMenus";

            byte[] bytes = jedis.get(key.getBytes());

            navigatationMenus = SerializationUtility.unSerializeList(bytes,new SerializationUtility.CacheList<NavigatationMenu>()).getList();

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return navigatationMenus;
    }

}
