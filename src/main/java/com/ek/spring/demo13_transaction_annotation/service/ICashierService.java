package com.ek.spring.demo13_transaction_annotation.service;

import java.util.List;

/**
 * 一个人一次买多本书 
 *
 */
public interface  ICashierService {

  public void checkout(String username , List<String> isbns);
}