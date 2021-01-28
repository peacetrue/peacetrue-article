package com.github.peacetrue.article;

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
@RequestMapping(value = "/articles3")
public class Article3Controller {

    @Autowired
    private Article3Service articleService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Article3VO> addByForm(Article3Add params) {
        log.info("新增文章信息(请求方法+表单参数)[{}]", params);
        return articleService.add(params);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Article3VO> addByJson(@RequestBody Article3Add params) {
        log.info("新增文章信息(请求方法+JSON参数)[{}]", params);
        return articleService.add(params);
    }

    @GetMapping(params = "page")
    public Mono<Page<Article3VO>> query(Article3Query params, Pageable pageable, String... projection) {
        log.info("分页查询文章信息(请求方法+参数变量)[{}]", params);
        return articleService.query(params, pageable, projection);
    }

    @GetMapping
    public Flux<Article3VO> query(Article3Query params, Sort sort, String... projection) {
        log.info("全量查询文章信息(请求方法+参数变量)[{}]", params);
        return articleService.query(params, sort, projection);
    }

    @GetMapping("/{id}")
    public Mono<Article3VO> getByUrlPathVariable(@PathVariable Long id, String... projection) {
        log.info("获取文章信息(请求方法+路径变量)详情[{}]", id);
        return articleService.get(new Article3Get(id), projection);
    }

    @RequestMapping("/get")
    public Mono<Article3VO> getByPath(Article3Get params, String... projection) {
        log.info("获取文章信息(请求路径+参数变量)详情[{}]", params);
        return articleService.get(params, projection);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> modifyByForm(Article3Modify params) {
        log.info("修改文章信息(请求方法+表单参数)[{}]", params);
        return articleService.modify(params);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> modifyByJson(@RequestBody Article3Modify params) {
        log.info("修改文章信息(请求方法+JSON参数)[{}]", params);
        return articleService.modify(params);
    }

    @DeleteMapping("/{id}")
    public Mono<Integer> deleteByUrlPathVariable(@PathVariable Long id) {
        log.info("删除文章信息(请求方法+URL路径变量)[{}]", id);
        return articleService.delete(new Article3Delete(id));
    }

    @DeleteMapping(params = "id")
    public Mono<Integer> deleteByUrlParamVariable(Article3Delete params) {
        log.info("删除文章信息(请求方法+URL参数变量)[{}]", params);
        return articleService.delete(params);
    }

    @RequestMapping(path = "/delete")
    public Mono<Integer> deleteByPath(Article3Delete params) {
        log.info("删除文章信息(请求路径+URL参数变量)[{}]", params);
        return articleService.delete(params);
    }


}
