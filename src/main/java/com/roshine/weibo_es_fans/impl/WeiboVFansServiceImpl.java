package com.roshine.weibo_es_fans.impl;

import com.roshine.weibo_es_fans.entity.WeiboVFans;
import com.roshine.weibo_es_fans.mapper.WeiboVFansMapper;
import com.roshine.weibo_es_fans.service.WeiboVFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-08 15:50
 * @Description
 */
@Service
public class WeiboVFansServiceImpl implements WeiboVFansService {
    private static final String HTTP = "http://192.168.0.108:8888/";
    private final WeiboVFansMapper weiboVFansMapper;
    @Autowired
    public WeiboVFansServiceImpl(WeiboVFansMapper weiboVFansMapper) {
        this.weiboVFansMapper = weiboVFansMapper;
    }

    @Override
    public List<WeiboVFans> getWeiboVFansByVId(String vId) {
        List<WeiboVFans> weiboVFansByVId = weiboVFansMapper.getWeiboVFansByVId(vId);
        for (WeiboVFans weiboVFans : weiboVFansByVId) {
            weiboVFans.setImagePath(HTTP + weiboVFans.getImagePath());
        }
        return weiboVFansByVId;
    }
}
