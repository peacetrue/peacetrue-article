package com.github.peacetrue.article;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 文章客户端
 *
 * @author xiayx
 */
@ReactiveFeignClient(name = "peacetrue-article", url = "${peacetrue.article.url:${peacetrue.server.url:}}")
public interface Article3ServiceClient {

    @PostMapping(value = "/articles3")
    Mono<Article3VO> add(Article3Add params);

    @GetMapping(value = "/articles3", params = "page")
    Mono<Page<Article3VO>> query(@Nullable @SpringQueryMap Article3Query params, @Nullable Pageable pageable, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles3", params = "sort")
    Flux<Article3VO> query(@SpringQueryMap Article3Query params, Sort sort, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles3")
    Flux<Article3VO> query(@SpringQueryMap Article3Query params, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles3/get")
    Mono<Article3VO> get(@SpringQueryMap Article3Get params, @SpringQueryMap String... projection);

    @PutMapping(value = "/articles3")
    Mono<Integer> modify(Article3Modify params);

    @DeleteMapping(value = "/articles3/delete")
    Mono<Integer> delete(@SpringQueryMap Article3Delete params);

}
