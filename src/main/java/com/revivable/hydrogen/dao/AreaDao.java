package com.revivable.hydrogen.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.revivable.hydrogen.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;
import java.util.List;

@Repository
public interface AreaDao extends BaseMapper<Area> {

    int batchInsertArea(List<Area> areaList);

    List<Area> areaSelectWrapper(@Param(Constants.WRAPPER) LambdaQueryWrapper<Area> wrapper);
}
