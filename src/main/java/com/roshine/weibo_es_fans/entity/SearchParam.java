package com.roshine.weibo_es_fans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author luoxin
 * @version 1.0.0
 * @date 2019-09-25 10:21
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchParam implements Serializable {
    private String searchKeyWord;
}
