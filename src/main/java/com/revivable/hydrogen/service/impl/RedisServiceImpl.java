package com.revivable.hydrogen.service.impl;

import com.revivable.hydrogen.entity.Area;
import com.revivable.hydrogen.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String addArea(Area area) {
        if(area!=null){
            stringRedisTemplate.opsForValue().set("areaname",area.getAreaname());
        }
        return stringRedisTemplate.opsForValue().get("areaname");
    }

    @Override
    public void sendMessage(String channel, String message) {
        stringRedisTemplate.convertAndSend(channel,message);
    }
}
