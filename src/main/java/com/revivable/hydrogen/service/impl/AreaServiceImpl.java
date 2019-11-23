package com.revivable.hydrogen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.revivable.hydrogen.dao.AreaDao;
import com.revivable.hydrogen.entity.Area;
import com.revivable.hydrogen.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> queryAllData() {
        return areaDao.selectList(null);
    }

    @Override
    public int batchInsertArea(List<Area> areaList) {
        int effectedNum = 0;
        if(areaList != null && areaList.size()>0){
            try {
                effectedNum = areaDao.batchInsertArea(areaList);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return effectedNum;
    }

    @Override
    public List<Area> wrapperQuery(QueryWrapper<Area> queryWrapper) {
        return areaDao.selectList(queryWrapper);
    }

    @Override
    public List<Area> areaSelectWrapper(LambdaQueryWrapper<Area> wrapper) {
        return areaDao.areaSelectWrapper(wrapper);
    }
}
