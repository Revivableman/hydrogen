package com.revivable.hydrogen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.revivable.hydrogen.entity.MailMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDao extends BaseMapper<MailMessage> {
}
