package com.github.peacetrue.article;

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
public interface Article3Service {

    /** 新增 */
    Mono<Article3VO> add(Article3Add params);

    /** 分页查询 */
    Mono<Page<Article3VO>> query(@Nullable Article3Query params, @Nullable Pageable pageable, String... projection);

    /** 全量查询 */
    Flux<Article3VO> query(Article3Query params, @Nullable Sort sort, String... projection);

    /** 全量查询 */
    default Flux<Article3VO> query(Article3Query params, String... projection) {
        return this.query(params, (Sort) null, projection);
    }

    /** 获取 */
    Mono<Article3VO> get(Article3Get params, String... projection);

    /** 修改 */
    Mono<Integer> modify(Article3Modify params);

    /** 删除 */
    Mono<Integer> delete(Article3Delete params);

}
