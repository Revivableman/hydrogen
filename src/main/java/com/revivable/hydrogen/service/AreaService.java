package com.revivable.hydrogen.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.revivable.hydrogen.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> queryAllData();

    /*
     * 批量增加区域
     */
    int batchInsertArea(List<Area> areaList);

    List<Area> wrapperQuery(QueryWrapper<Area> queryWrapper);

    List<Area> areaSelectWrapper(LambdaQueryWrapper<Area> wrapper);
}
