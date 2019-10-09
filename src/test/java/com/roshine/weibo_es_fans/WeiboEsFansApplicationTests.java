package com.roshine.weibo_es_fans;

import com.roshine.weibo_es_fans.entity.WeiboV;
import com.roshine.weibo_es_fans.entity.WeiboVSearch;
import com.roshine.weibo_es_fans.service.WeiboVService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeiboEsFansApplicationTests {
    private static final String ES_INDEX_NAME = "weibo";
    private static final String ES_TYPE_NAME = "WeiboV";
    @Autowired
    private WeiboVService weiboVService;
    @Autowired
    private JestClient jestClient;

    @Test
    public void insertES() {
        List<WeiboV> weiboVAll = weiboVService.getWeiboVAll();
        List<WeiboVSearch> weiboVSearches = new ArrayList<>();
        for (WeiboV weiboV : weiboVAll) {
            WeiboVSearch weiboVSearch = new WeiboVSearch();
            BeanUtils.copyProperties(weiboV, weiboVSearch);
            weiboVSearches.add(weiboVSearch);
        }
        for (WeiboVSearch weiboVSearch : weiboVSearches) {
            System.out.println(weiboVSearch);
            Index index = new Index.Builder(weiboVSearch).index(ES_INDEX_NAME).type(ES_TYPE_NAME).id(weiboVSearch.getId() + "").build();
            try {
                jestClient.execute(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("导入ES成功");
    }
}
