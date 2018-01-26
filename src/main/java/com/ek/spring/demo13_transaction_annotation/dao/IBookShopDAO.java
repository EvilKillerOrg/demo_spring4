package com.ek.spring.demo13_transaction_annotation.dao;

/**
 * 测试事务 (annotation实现) 
 *
 */
public interface IBookShopDAO {
  
  /*根据isbn获取书的单价*/
  public int findBookpriceByISBN(String isbn);
  
  /*根据isbn更新书的库存 使isbn对应的书的库存-1*/
  public void updateBookStock(String isbn);
  
  /*更新用户的账户余额 使username的balance - price*/
  public void updateUserAccount(String username , int price);

}