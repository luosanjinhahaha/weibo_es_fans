package com.roshine.weibo_es_fans.mapper;

import com.roshine.weibo_es_fans.entity.WeiboV;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author luoxin
 * @version 1.0.0
 * @date 2019-10-07 13:22
 * @Description
 */
@Mapper
public interface WeiboVMapper {

    List<WeiboV> getWeiboVAll();

}
