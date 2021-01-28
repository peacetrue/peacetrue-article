package com.github.peacetrue.article;

import com.github.peacetrue.dictionary.modules.dictionaryvalue.DictionaryValueRepository;
import com.github.peacetrue.spring.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.StringUtils;
import reactor.core.scheduler.Schedulers;

/**
 * @author : xiayx
 * @since : 2020-12-17 13:49
 **/
@Slf4j
public class Article3Listener {

    @Autowired
    private DictionaryValueRepository dictionaryValueRepository;

    @EventListener
    public void setTypeCodeAfterArticleAdd(PayloadApplicationEvent<Article3Add> event) {
        Article3VO source = (Article3VO) event.getSource();
        if (StringUtils.isEmpty(source.getTypeCode())) {
            log.info("新增文章[{}]后，设置文章类别", source.getId());
            dictionaryValueRepository.setCodePropertyValue(BeanUtils.map(source, Article3.class), "typeId")
                    .subscribeOn(Schedulers.boundedElastic())
                    .subscribe();
        }
    }
}