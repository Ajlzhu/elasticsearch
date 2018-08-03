package com.li.blog.controller;

import com.li.blog.domain.es.EsBlog;
import com.li.blog.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author licheng
 * @description
 * @create 2018/8/2 22:27
 */
@RestController
@RequestMapping("/blogs")
public class EsBlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;
    /**
     * 查询符合条件的博客列表
     * @param pageSize 每页显示的条数
     * @param pageIndex 当前页
     * @param title 博客标题
     * @param summary 博客摘要
     * @param content  博客内容
     * @return java.util.List<com.li.blog.domain.es.EsBlog>
     */
    @RequestMapping("/list")
    public List<EsBlog>  list(@RequestParam(value="pageSize",defaultValue = "10") int pageSize,
                              @RequestParam(value="pageIndex",defaultValue = "0") int pageIndex,
                              @RequestParam(value="title") String title,
                              @RequestParam(value="summary") String summary,
                              @RequestParam(value="content") String content){

        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);
        return page.getContent();
    }
}
