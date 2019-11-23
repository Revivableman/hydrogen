package com.revivable.hydrogen.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.revivable.hydrogen.entity.Area;
import com.revivable.hydrogen.service.AreaService;
import com.revivable.hydrogen.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private RedisService redisService;

    @GetMapping("/queryList")
    public List<Area> queryList(){
        return areaService.queryAllData();
    }

    @GetMapping("/insertArea")
    public String insertArea(){
        Area area1 = new Area("luohu","CBD",3);
        Area area2 = new Area("longgang","suburb",4);
        List<Area> areaList = Arrays.asList(area1,area2);
        int effectedNum = areaService.batchInsertArea(areaList);
        if(effectedNum>0){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("wrapperQuery")
    public List<Area> wrapperQuery(){
        QueryWrapper<Area> queryWrapper = new QueryWrapper<Area>();
        queryWrapper.likeRight("areaname","long")
                .and(wq->wq.lt("priority",2).or().isNotNull("descri"));
        return areaService.wrapperQuery(queryWrapper);
    }

    @GetMapping("wrapperQueryPart")
    public List<Area> queryWrapperPart(){
        QueryWrapper<Area> queryWrapper = new QueryWrapper<Area>();
        queryWrapper.nested(wq->wq.isNotNull("descri").or().gt("priority",2))
                .likeLeft("areaname","n").select(Area.class,info->!info.getColumn().equals("id"));
        return areaService.wrapperQuery(queryWrapper);
    }

    @GetMapping("wrapperQueryLambda/{id}")
    public List<Area> queryWrapperLambda(@PathVariable Integer id){
        LambdaQueryWrapper<Area> lambdaQueryWrapper = new LambdaQueryWrapper<Area>();
        lambdaQueryWrapper.eq(Area::getId,id);
        return areaService.areaSelectWrapper(lambdaQueryWrapper);
}

    @GetMapping("redisOp")
    public String redisOp(){
        return redisService.addArea(new Area("dapeng","jiaqu",6));
    }

    @GetMapping("redisPublish")
    public void redisPublish(){
        redisService.sendMessage("revivable","kanyihachenggonglemao");
        redisService.sendMessage("medemo","zheshiyigehaoxiangmu");
    }
}
