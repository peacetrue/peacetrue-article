package com.github.peacetrue.article;

import com.github.peacetrue.core.IdCapable;
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
public class ArticleModify extends OperatorCapableImpl<Long> implements IdCapable<Long> {

    private static final long serialVersionUID = 0L;

    /** 主键 */
    @NotNull
    private Long id;
    /** 类型. descriptiveType */
    private Long typeId;
    /** 类型编码 */
    @Size(min = 1, max = 32)
    private String typeCode;
    /** 封面 */
    @Size(min = 1, max = 255)
    private String cover;
    /** 标题 */
    @Size(min = 1, max = 32)
    private String title;
    /** 备注 */
    @Size(min = 1, max = 255)
    private String remark;
    /** 序号 */
    private Long serialNumber;

}
