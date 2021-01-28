package com.github.peacetrue.article;

import com.github.peacetrue.article.*;
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
@ReactiveFeignClient(name = "peacetrue-article", url = "${peacetrue.Article.url:${peacetrue.server.url:}}")
public interface ArticleServiceClient {

    @PostMapping(value = "/articles")
    Mono<ArticleVO> add(ArticleAdd params);

    @GetMapping(value = "/articles", params = "page")
    Mono<Page<ArticleVO>> query(@Nullable @SpringQueryMap ArticleQuery params, @Nullable Pageable pageable, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles", params = "sort")
    Flux<ArticleVO> query(@SpringQueryMap ArticleQuery params, Sort sort, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles")
    Flux<ArticleVO> query(@SpringQueryMap ArticleQuery params, @SpringQueryMap String... projection);

    @GetMapping(value = "/articles/get")
    Mono<ArticleVO> get(@SpringQueryMap ArticleGet params, @SpringQueryMap String... projection);

    @PutMapping(value = "/articles")
    Mono<Integer> modify(ArticleModify params);

    @DeleteMapping(value = "/articles/delete")
    Mono<Integer> delete(@SpringQueryMap ArticleDelete params);

}
