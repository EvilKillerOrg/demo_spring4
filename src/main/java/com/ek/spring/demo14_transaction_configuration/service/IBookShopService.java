package com.ek.spring.demo14_transaction_configuration.service;
/**
 * 一个人一次买一本书
 *
 */
public interface IBookShopService {

  public void purchase(String username , String isbn);
  
}