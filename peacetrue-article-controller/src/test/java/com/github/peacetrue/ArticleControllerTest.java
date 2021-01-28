package com.github.peacetrue;

import com.github.peacetrue.article.ArticleModify;
import com.github.peacetrue.article.ArticleVO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.function.Consumer;

/**
 * @author xiayx
 */
@SpringBootTest(classes = TestControllerArticleAutoConfiguration.class)
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArticleControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    @Order(10)
    public void add() {
        this.client.post().uri("/articles")
                .bodyValue(ArticleServiceImplTest.ADD)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ArticleVO.class).value((Consumer<ArticleVO>) vo -> ArticleServiceImplTest.vo = vo);
    }

    @Test
    @Order(20)
    public void queryForPage() {
        this.client.get()
                .uri("/articles?page=0")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.totalElements").isEqualTo(1);
    }

    @Test
    @Order(30)
    public void queryForList() {
        this.client.get()
                .uri("/articles")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.size()").isEqualTo(1);
    }

    @Test
    @Order(40)
    public void get() {
        this.client.get()
                .uri("/articles/{0}", ArticleServiceImplTest.vo.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ArticleVO.class).isEqualTo(ArticleServiceImplTest.vo);
    }


    @Test
    @Order(50)
    public void modify() {
        ArticleModify modify = ArticleServiceImplTest.MODIFY;
        modify.setId(ArticleServiceImplTest.vo.getId());
        this.client.put()
                .uri("/articles/{id}", ArticleServiceImplTest.vo.getId())
                .bodyValue(modify)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

    @Test
    @Order(60)
    public void delete() {
        this.client.delete()
                .uri("/articles/{0}", ArticleServiceImplTest.vo.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Integer.class).isEqualTo(1);
    }

}
