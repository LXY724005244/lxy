package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.JiaoAnMapper;
import com.stylefeng.guns.modular.system.model.Jiaoan;
import com.stylefeng.guns.modular.system.model.Tag;
import com.stylefeng.guns.modular.system.service.IJiaoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiaoAnServiceImpl extends ServiceImpl<JiaoAnMapper,Jiaoan> implements IJiaoanService {
    @Autowired
    JiaoAnMapper jiaoAnMapper;
    @Override
    public List<Tag> SelectTag() {
        return jiaoAnMapper.SelectTag();
    }
}
