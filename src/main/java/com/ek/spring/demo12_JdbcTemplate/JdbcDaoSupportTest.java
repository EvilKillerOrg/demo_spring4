package com.ek.spring.demo12_JdbcTemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 
 * JdbcDaoSupport这个必须有一个 JdbcTemplate 或者 DataSource
 * 这样 声明就用不了 比较麻烦所以不推荐使用
 * 要用只能去配置文件里配置
 * 或者曲线救国 曲线救国的方法看佟刚的视频吧
 *
 */

public class JdbcDaoSupportTest extends JdbcDaoSupport{

}