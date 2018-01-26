package com.ek.spring.demo14_transaction_configuration.service;

import com.ek.spring.demo14_transaction_configuration.dao.IBookShopDAO;


public class BookShopServiceImpl implements IBookShopService {

  private IBookShopDAO bookShopDAO;
  public void setBookShopDAO(IBookShopDAO bookShopDAO) { //setterDI
    this.bookShopDAO = bookShopDAO;
  }


  /*XML事务*/
  @Override
  public void purchase(String username, String isbn) {
    //1.获取书的单价
    int price = bookShopDAO.findBookpriceByISBN(isbn);
    //2.更新书的库存
    bookShopDAO.updateBookStock(isbn);
    //3.更新用户余额
    bookShopDAO.updateUserAccount(username, price);
  }

}