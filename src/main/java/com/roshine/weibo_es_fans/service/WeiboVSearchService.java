package com.roshine.weibo_es_fans.service;

import com.roshine.weibo_es_fans.entity.SearchParam;
import com.roshine.weibo_es_fans.entity.WeiboVSearch;

import java.util.List;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-08 23:06
 * @Description
 */
public interface WeiboVSearchService {

    List<WeiboVSearch> weiboVSearch(SearchParam searchParam);
}
