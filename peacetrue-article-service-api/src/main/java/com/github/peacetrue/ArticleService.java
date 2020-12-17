package com.github.peacetrue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 文章服务接口
 *
 * @author xiayx
 */
public interface ArticleService {

    /** 新增 */
    Mono<ArticleVO> add(ArticleAdd params);

    /** 分页查询 */
    Mono<Page<ArticleVO>> query(@Nullable ArticleQuery params, @Nullable Pageable pageable, String... projection);

    /** 全量查询 */
    Flux<ArticleVO> query(ArticleQuery params, @Nullable Sort sort, String... projection);

    /** 全量查询 */
    default Flux<ArticleVO> query(ArticleQuery params, String... projection) {
        return this.query(params, (Sort) null, projection);
    }

    /** 获取 */
    Mono<ArticleVO> get(ArticleGet params, String... projection);

    /** 修改 */
    Mono<Integer> modify(ArticleModify params);

    /** 删除 */
    Mono<Integer> delete(ArticleDelete params);

}
