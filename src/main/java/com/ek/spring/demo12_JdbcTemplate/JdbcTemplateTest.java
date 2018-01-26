package com.ek.spring.demo12_JdbcTemplate;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * JUnit环境下测试 Spring JdbcTemplate (JdbcTemplate是线程安全的)
 */
public class JdbcTemplateTest {

  private ApplicationContext ctx = null;
  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private UserInfoDAO userInfoDAO;
  
  
  
  
  
  {
    ctx = new ClassPathXmlApplicationContext("applicationContext_demo12.xml");
    jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    userInfoDAO = ctx.getBean(UserInfoDAO.class);
    namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
  }
  
  
  
  
  
  /*测试: 具名参数 namedParameterJdbcTemplate 1 
   * (注意不用? 用: 好处就是?多了要去对顺序,这个有名字对名字就可以了不怕乱,但是也有点麻烦)
   * 下面的好一点*/
  @Test
  public void testNamedParameterJdbcTemplate1(){
    String sql = "INSERT INTO user_info(username , sex , birthday) VALUES (:un, :sex, :bir)";
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("un", "eee");
    paramMap.put("sex", "1");
    paramMap.put("bir", "2017-01-02");
    namedParameterJdbcTemplate.update(sql, paramMap);
  }
  
  
  
  
  
  /*测试: 具名参数 namedParameterJdbcTemplate 2 
   * 这个更好一些 :后面给属性名就可以了*/
  @Test
  public void testNamedParameterJdbcTemplate2(){
    String sql = "INSERT INTO user_info(username , sex , birthday) VALUES (:userName, :sex, :birthday)";
    UserInfo userInfo = new UserInfo();
    userInfo.setUserName("kkkeee");
    userInfo.setSex("1");
    userInfo.setBirthday("1999-09-09");
    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userInfo);  
    namedParameterJdbcTemplate.update(sql, paramSource);
  }
  
  
  
  
  
  
  /*测试: UserInfoDAO*/
  @Test
  public void testUserInfoDAO(){
    System.out.println(userInfoDAO.getUserInfoByID(1));
  }
  
  
  
  
  
   /*测试: 查一个对象
   * RowMapper 指定如何去映射结果集的行,常用的实现类是BeanPropertyRowMapper
   * 使用列名完成列名和类的属性名的映射
   * 不支持级联(他还是jdbc不是orm)*/
  @Test
  public void testQueryForObject1(){
    String sql = "SELECT uuid , username userName , sex , birthday FROM user_info WHERE uuid = ?";
    RowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
    UserInfo userInfo = jdbcTemplate.queryForObject(sql, rowMapper, 1);
    System.out.println(userInfo);
  }
  
  
  
  
  
  /*测试: 获取单个列的值 或做统计查询*/
  @Test
  public void testQueryForObject2(){
    String sql = "SELECT COUNT(uuid) FROM user_info";
    Long count = jdbcTemplate.queryForObject(sql, Long.class);
    System.out.println(count);
  }
  
  
  
  
  
  /*测试: 查对象集合*/
  @Test
  public void testQuery(){
    String sql= "SELECT * FROM user_info WHERE uuid < 10";
    RowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
    List<UserInfo> userList = jdbcTemplate.query(sql, rowMapper);
    System.out.println(userList);
  }
  
  
  
  
  
  /*测试: 执行insert update delete*/
  @Test
  public void testUpdate(){
    String sql = "UPDATE user_info SET username=? WHERE uuid=?";
    jdbcTemplate.update(sql, "k",1);
  }
  
  
  
  
  
  /*测试: 批量执行insert update delete*/
  @Test
  public void testBatchUpdate(){
    String sql = "INSERT INTO user_info (username , sex , birthday) VALUES (?,?,?)";
    List<Object[]> batchArgs = new ArrayList<>();
    batchArgs.add(new Object[]{"s" , 1 , "2017-01-01"});
    batchArgs.add(new Object[]{"p" , 1 , "2017-01-01"});
    batchArgs.add(new Object[]{"r" , 1 , "2017-01-01"});
    batchArgs.add(new Object[]{"i" , 1 , "2017-01-01"});
    batchArgs.add(new Object[]{"n" , 1 , "2017-01-01"});
    batchArgs.add(new Object[]{"g" , 1 , "2017-01-01"});
    jdbcTemplate.batchUpdate(sql, batchArgs);
  }
  
  
  
  
  
  /*测试: 获取数据库连接*/
  @Test
  public void test() {
    DataSource dataSource = ctx.getBean(DataSource.class);
    try {
      System.out.println(dataSource.getConnection());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}