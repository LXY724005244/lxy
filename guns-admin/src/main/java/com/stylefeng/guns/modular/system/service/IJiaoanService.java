package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.Jiaoan;
import com.stylefeng.guns.modular.system.model.Tag;

import java.util.List;

public interface IJiaoanService extends IService<Jiaoan> {
public List<Tag> SelectTag();
}
