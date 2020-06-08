package com.by.km.mapper;

import com.by.km.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bingyi
 */
@Mapper
public interface DemoMapper {

    List<Demo> queryAll();

}
