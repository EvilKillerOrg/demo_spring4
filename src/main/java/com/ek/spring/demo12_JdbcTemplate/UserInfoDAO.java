package com.ek.spring.demo12_JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ek.spring.demo12_JdbcTemplate.UserInfo;

/**
 * 开发环境下(annotation)  Spring JdbcTemplate 这么用
 */
@Repository(value="userDAO")
public class UserInfoDAO {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  /*查一行*/
  public UserInfo getUserInfoByID(Integer uuid){
    String sql = "select * from user_info where uuid=?";
    RowMapper<UserInfo> rowMapper = new  BeanPropertyRowMapper<>(UserInfo.class);
    UserInfo userinfo = jdbcTemplate.queryForObject(sql, rowMapper, uuid);
    return userinfo;
  }
}