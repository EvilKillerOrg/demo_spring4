package com.ek.spring.demo13_transaction_annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ek.spring.demo13_transaction_annotation.exception.BookStockException;
import com.ek.spring.demo13_transaction_annotation.exception.UserAccountException;

@Repository(value="bookShopDAO")
public class BookShopDAOImpl implements IBookShopDAO{

  @Autowired
  JdbcTemplate jdbcTemplate = null;
  
  
  @Override
  /*根据isbn获取书的单价*/
  public int findBookpriceByISBN(String isbn) {
    String sql = "select price from book where isbn = ?";
    return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
  }

  
  
  
  
  @Override
  /*根据isbn更新书的库存 使isbn对应的书的库存-1*/
  public void updateBookStock(String isbn) {
    //检查书的库存是否足够, 若不够则抛出异常
    String sql2 = "select stock from book_stock where isbn = ?";
    int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
    if(stock == 0){
      throw new BookStockException("库存不足");
    }
    
    String sql1 = "update book_stock set stock = stock-1 where isbn = ?";
    jdbcTemplate.update(sql1, isbn);
  }

  
  
  
  
  @Override
  /*更新用户的账户余额 使username的balance - price*/
  public void updateUserAccount(String username, int price) {
    //检查账户余额是否足够, 若不够则抛出异常
    String sql2 = "select balance from account where username = ?";
    int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
    if(balance < price){
      throw new UserAccountException("余额不足");
    }
    
    String sql1 = "update account set balance = balance-? where username = ?";
    jdbcTemplate.update(sql1, price , username);
  }

}