package com.roshine.weibo_es_fans.controller;

import com.roshine.weibo_es_fans.entity.SearchParam;
import com.roshine.weibo_es_fans.entity.WeiboV;
import com.roshine.weibo_es_fans.entity.WeiboVFans;
import com.roshine.weibo_es_fans.entity.WeiboVSearch;
import com.roshine.weibo_es_fans.service.WeiboVFansService;
import com.roshine.weibo_es_fans.service.WeiboVSearchService;
import com.roshine.weibo_es_fans.service.WeiboVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-07 13:20
 * @Description
 */
@Controller
public class WeiboVController {
    private final WeiboVService weiboService;
    private final WeiboVFansService weiboVFansService;
    private final WeiboVSearchService weiboVSearchService;

    @Autowired
    public WeiboVController(WeiboVService weiboService, WeiboVFansService weiboVFansService,
                            WeiboVSearchService weiboVSearchService) {
        this.weiboService = weiboService;
        this.weiboVFansService = weiboVFansService;
        this.weiboVSearchService = weiboVSearchService;
    }

    @GetMapping("/getWeiboVAll")
    public String getWeiboVAll(Model model) {
        List<WeiboV> weiboVAll = weiboService.getWeiboVAll();
        model.addAttribute("weiboVAll", weiboVAll);
        return "index";
    }

    @GetMapping("/getWeiboVFansByVId/{vId}")
    public String getWeiboVFansByVId(@PathVariable("vId")String vId, Model model) {
        List<WeiboVFans> weiboVFansByVId = weiboVFansService.getWeiboVFansByVId(vId);
        model.addAttribute("weiboVFansByVId", weiboVFansByVId);
        return "indexFans";
    }

    @GetMapping("/weiboVSearch/{searchParam}")
    public String weiboVSearch(@PathVariable SearchParam searchParam, Model model) {
        List<WeiboVSearch> weiboVSearches = weiboVSearchService.weiboVSearch(searchParam);
        model.addAttribute("weiboVSearches", weiboVSearches);
        model.addAttribute("searchKeyWord", searchParam.getSearchKeyWord());
        return "indexSearch";
    }

    @GetMapping("/weiboVFansSearch/{searchParam}")
    public String weiboVFansSearch(@PathVariable SearchParam searchParam, Model model) {
        List<WeiboVSearch> weiboVSearches = weiboVSearchService.weiboVSearch(searchParam);
        model.addAttribute("weiboVSearches", weiboVSearches);
        return "indexSearch";
    }
}
