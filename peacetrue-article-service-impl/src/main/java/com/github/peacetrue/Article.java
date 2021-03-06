package com.github.peacetrue;

import com.github.peacetrue.core.IdCapable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章实体类
 *
 * @author xiayx
 */
@Getter
@Setter
@ToString
public class Article implements Serializable, IdCapable<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @Id
    private Long id;
    /** 类型. descriptiveType */
    private Long typeId;
    /** 类型编码 */
    private String typeCode;
    /** 封面 */
    private String cover;
    /** 标题 */
    private String title;
    /** 简介 */
    private String intro;
    /** 详情 */
    private String detail;
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
