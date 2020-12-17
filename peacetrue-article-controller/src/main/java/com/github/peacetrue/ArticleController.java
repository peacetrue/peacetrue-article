package com.github.peacetrue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 文章控制器
 *
 * @author xiayx
 */
@Slf4j
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<ArticleVO> addByForm(ArticleAdd params) {
        log.info("新增文章信息(请求方法+表单参数)[{}]", params);
        return articleService.add(params);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ArticleVO> addByJson(@RequestBody ArticleAdd params) {
        log.info("新增文章信息(请求方法+JSON参数)[{}]", params);
        return articleService.add(params);
    }

    @GetMapping(params = "page")
    public Mono<Page<ArticleVO>> query(ArticleQuery params, Pageable pageable, String... projection) {
        log.info("分页查询文章信息(请求方法+参数变量)[{}]", params);
        return articleService.query(params, pageable, projection);
    }

    @GetMapping
    public Flux<ArticleVO> query(ArticleQuery params, Sort sort, String... projection) {
        log.info("全量查询文章信息(请求方法+参数变量)[{}]", params);
        return articleService.query(params, sort, projection);
    }

    @GetMapping("/{id}")
    public Mono<ArticleVO> getByUrlPathVariable(@PathVariable Long id, String... projection) {
        log.info("获取文章信息(请求方法+路径变量)详情[{}]", id);
        return articleService.get(new ArticleGet(id), projection);
    }

    @RequestMapping("/get")
    public Mono<ArticleVO> getByPath(ArticleGet params, String... projection) {
        log.info("获取文章信息(请求路径+参数变量)详情[{}]", params);
        return articleService.get(params, projection);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> modifyByForm(ArticleModify params) {
        log.info("修改文章信息(请求方法+表单参数)[{}]", params);
        return articleService.modify(params);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> modifyByJson(@RequestBody ArticleModify params) {
        log.info("修改文章信息(请求方法+JSON参数)[{}]", params);
        return articleService.modify(params);
    }

    @DeleteMapping("/{id}")
    public Mono<Integer> deleteByUrlPathVariable(@PathVariable Long id) {
        log.info("删除文章信息(请求方法+URL路径变量)[{}]", id);
        return articleService.delete(new ArticleDelete(id));
    }

    @DeleteMapping(params = "id")
    public Mono<Integer> deleteByUrlParamVariable(ArticleDelete params) {
        log.info("删除文章信息(请求方法+URL参数变量)[{}]", params);
        return articleService.delete(params);
    }

    @RequestMapping(path = "/delete")
    public Mono<Integer> deleteByPath(ArticleDelete params) {
        log.info("删除文章信息(请求路径+URL参数变量)[{}]", params);
        return articleService.delete(params);
    }


}
