package com.revivable.hydrogen.service;

import com.revivable.hydrogen.entity.Area;

public interface RedisService {

    String addArea(Area area);

    void sendMessage(String channel, String message);
}
