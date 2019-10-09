package com.roshine.weibo_es_fans.mapper;

import com.roshine.weibo_es_fans.entity.WeiboVFans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author luoxin
 * @version 1.0.0
 * @date 2019-10-08 15:44
 * @Description
 */
@Mapper
public interface WeiboVFansMapper {

    List<WeiboVFans> getWeiboVFansByVId(String vId);
}
