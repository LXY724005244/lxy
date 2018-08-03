package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Dept;
import com.stylefeng.guns.modular.system.dao.DeptMapper;
import com.stylefeng.guns.modular.system.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-25
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
