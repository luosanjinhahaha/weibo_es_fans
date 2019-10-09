package com.roshine.weibo_es_fans.impl;

import com.roshine.weibo_es_fans.entity.WeiboV;
import com.roshine.weibo_es_fans.mapper.WeiboVMapper;
import com.roshine.weibo_es_fans.service.WeiboVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-07 13:22
 * @Description
 */
@Service
public class WeiboServiceImpl implements WeiboVService {
    private static final String HTTP = "http://192.168.0.108:8888/";
    private final WeiboVMapper weiboVMapper;
    @Autowired
    public WeiboServiceImpl(WeiboVMapper weiboVMapper) {
        this.weiboVMapper = weiboVMapper;
    }

    @Override
    public List<WeiboV> getWeiboVAll() {
        List<WeiboV> weiboVAll = weiboVMapper.getWeiboVAll();
        for (WeiboV weiboV : weiboVAll) {
            weiboV.setImagePath(HTTP + weiboV.getImagePath());
        }
        return weiboVAll;
    }
}
