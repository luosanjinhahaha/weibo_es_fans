package com.roshine.weibo_es_fans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author luoxin
 * @version 1.0.0
 * @date 2019-10-08 15:40
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeiboVFans implements Serializable {
    private Integer id;
    private String vId;
    private String fansId;
    private String fansName;
    private String fansFansAmount;
    private String imagePath;
}
