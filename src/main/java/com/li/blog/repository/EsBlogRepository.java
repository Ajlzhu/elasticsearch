package com.li.blog.repository;

import com.li.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author licheng
 * @description EsBlogRepository接口
 * @create 2018/8/2 21:43
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 分页查询出标题包含title或摘要包含summary或内容包含content的博客并去重
     * @param title 标题
     * @param summary   摘要
     * @param content   内容
     * @return org.springframework.data.domain.Page<com.li.blog.domain.es.EsBlog>
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
