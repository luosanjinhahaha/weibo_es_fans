package com.roshine.weibo_es_fans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author roshine
 * @version 1.0.0
 * @date 2019-10-07 12:25
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeiboV implements Serializable {
    private Integer id;
    private String vId;
    private String vName;
    private String vIntro;
    private Integer concernAmount;
    private Integer fansAmount;
    private String sex;
    private Integer lv;
    private String imagePath;
}
