package com.roshine.weibo_es_fans.service;

import com.roshine.weibo_es_fans.entity.WeiboVFans;

import java.util.List;

/**
 * @author luoxin
 * @version 1.0.0
 * @date 2019-10-08 15:49
 * @Description
 */
public interface WeiboVFansService {

    List<WeiboVFans> getWeiboVFansByVId(String vId);
}
