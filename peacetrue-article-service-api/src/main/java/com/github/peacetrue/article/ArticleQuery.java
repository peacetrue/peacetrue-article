package com.github.peacetrue.article;

import com.github.peacetrue.core.OperatorCapableImpl;
import com.github.peacetrue.core.Range;
import lombok.*;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQuery extends OperatorCapableImpl<Long> {

    public static final ArticleQuery DEFAULT = new ArticleQuery();

    private static final long serialVersionUID = 0L;

    /** 主键 */
    private Long[] id;
    /** 类型. descriptiveType */
    private Long typeId;
    /** 类型编码 */
    private String typeCode;
    /** 封面 */
    private String cover;
    /** 标题 */
    private String title;
    /** 备注 */
    private String remark;
    /** 序号 */
    private Long serialNumber;
    /** 创建者主键 */
    private Long creatorId;
    /** 创建时间 */
    private Range.LocalDateTime createdTime;
    /** 修改者主键 */
    private Long modifierId;
    /** 修改时间 */
    private Range.LocalDateTime modifiedTime;

    public ArticleQuery(Long[] id) {
        this.id = id;
    }

}
