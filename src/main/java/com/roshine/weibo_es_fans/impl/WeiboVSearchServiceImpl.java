package com.roshine.weibo_es_fans.impl;

import com.roshine.weibo_es_fans.entity.SearchParam;
import com.roshine.weibo_es_fans.entity.WeiboVSearch;
import com.roshine.weibo_es_fans.service.WeiboVSearchService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-08 23:07
 * @Description
 */
@Service
public class WeiboVSearchServiceImpl implements WeiboVSearchService {
    private static final String ES_INDEX_NAME = "weibo";
    private static final String ES_TYPE_NAME = "WeiboV";
    @Autowired
    private JestClient jestClient;
    @Override
    public List<WeiboVSearch> weiboVSearch(SearchParam searchParam) {
        String searchKeyWord = searchParam.getSearchKeyWord();
        //jest的dsl工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(null);
        //bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //must
        if (StringUtils.isNotBlank(searchKeyWord)) {
            MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder(searchKeyWord);
            multiMatchQueryBuilder.field("vName");
            multiMatchQueryBuilder.field("vIntro");
            boolQueryBuilder.must(multiMatchQueryBuilder);
        }
        //query
        searchSourceBuilder.query(boolQueryBuilder);
        //from, size
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);
        String dslStr = searchSourceBuilder.toString();

        List<WeiboVSearch> weiboVSearches = new ArrayList<>();
        Search search = new Search.Builder(dslStr).addIndex(ES_INDEX_NAME).addType(ES_TYPE_NAME).build();
        SearchResult searchResult;
        try {
            searchResult = jestClient.execute(search);
            List<SearchResult.Hit<WeiboVSearch, Void>> resultHits = searchResult.getHits(WeiboVSearch.class);
            for (SearchResult.Hit<WeiboVSearch, Void> resultHit : resultHits) {
                WeiboVSearch source = resultHit.source;
                Double score = resultHit.score;
                System.out.println("相关性算分：" + score);
                source.setHotScore(score + "");
                //sort
                searchSourceBuilder.sort("hotScore", SortOrder.ASC);
                weiboVSearches.add(source);
                System.out.println(source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weiboVSearches;
    }
}
