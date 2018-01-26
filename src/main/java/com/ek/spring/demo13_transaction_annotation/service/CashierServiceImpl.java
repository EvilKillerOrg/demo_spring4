package com.ek.spring.demo13_transaction_annotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierService")
public class CashierServiceImpl implements ICashierService{

  @Autowired
  private IBookShopService bookShopService;
  
   
  /* checkout()是一个事务方法,调用了另一个事务方法bookShopService.purchase()
   * 关于事务的传播性,请看被调用的事务方法bookShopService.purchase()*/
  @Transactional()
  @Override
  public void checkout(String username, List<String> isbns) {
    for (String isbn : isbns) {
      bookShopService.purchase(username, isbn);
    }
  }

}