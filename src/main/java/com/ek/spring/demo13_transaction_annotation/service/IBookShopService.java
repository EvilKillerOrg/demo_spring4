package com.ek.spring.demo13_transaction_annotation.service;
/**
 * 一个人一次买一本书
 *
 */
public interface IBookShopService {

  public void purchase(String username , String isbn);
  
}