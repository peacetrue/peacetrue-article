package com.github.peacetrue;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleAdd extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 类型. descriptiveType */
    @NotNull
    private Long typeId;
    /** 类型编码 */
    @Size(min = 1, max = 32)
    private String typeCode;
    /** 封面 */
    @NotNull
    @Size(min = 1, max = 255)
    private String cover;
    /** 标题 */
    @NotNull
    @Size(min = 1, max = 32)
    private String title;
    /** 简介 */
    @NotNull
    @Size(min = 1, max = 255)
    private String intro;
    /** 详情 */
    @NotNull
    @Size(min = 1, max = 20480)
    private String detail;
    /** 备注 */
    @Size(min = 1, max = 255)
    private String remark;
    /** 序号 */
    private Long serialNumber;

}
