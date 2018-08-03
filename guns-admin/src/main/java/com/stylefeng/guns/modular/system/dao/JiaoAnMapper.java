package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.Jiaoan;
import com.stylefeng.guns.modular.system.model.Tag;

import java.util.List;

public interface JiaoAnMapper extends BaseMapper<Jiaoan> {
     List<Tag> SelectTag() ;
}
