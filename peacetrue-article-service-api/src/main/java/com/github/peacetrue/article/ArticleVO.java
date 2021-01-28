package com.github.peacetrue.article;

import com.github.peacetrue.core.IdCapable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiayx
 */
@Data
public class ArticleVO implements Serializable, IdCapable<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    private Long id;
    /** 类型. descriptiveType */
    private Long typeId;
    /** 类型编码 */
    private String typeCode;
    /** 封面 */
    private String cover;
    /** 封面链接 */
    private String coverUrl;
    /** 标题 */
    private String title;
    /** 备注 */
    private String remark;
    /** 序号 */
    private Long serialNumber;
    /** 创建者主键 */
    private Long creatorId;
    /** 创建时间 */
    private LocalDateTime createdTime;
    /** 修改者主键 */
    private Long modifierId;
    /** 修改时间 */
    private LocalDateTime modifiedTime;
}
