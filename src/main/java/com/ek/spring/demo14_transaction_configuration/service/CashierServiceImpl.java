package com.ek.spring.demo14_transaction_configuration.service;

import java.util.List;

public class CashierServiceImpl implements ICashierService{

  private IBookShopService bookShopService;
  public void setBookShopService(IBookShopService bookShopService) { //setterDI
    this.bookShopService = bookShopService;
  }




  @Override
  public void checkout(String username, List<String> isbns) {
    for (String isbn : isbns) {
      bookShopService.purchase(username, isbn);
    }
  }

}