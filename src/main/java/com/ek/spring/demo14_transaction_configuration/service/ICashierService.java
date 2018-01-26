package com.ek.spring.demo14_transaction_configuration.service;

import java.util.List;

/**
 * 一个人一次买多本书 
 *
 */
public interface  ICashierService {

  public void checkout(String username , List<String> isbns);
}