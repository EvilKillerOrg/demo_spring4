package com.ek.spring.demo13_transaction_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ek.spring.demo13_transaction_annotation.dao.IBookShopDAO;

@Service("bookShopService")
public class BookShopServiceImpl implements IBookShopService {

  @Autowired
  private IBookShopDAO bookShopDAO;
  
  /*声名式事务*/
  
  /* 事务的传播行为:
   * bookShopService.purchase()有一个事务, 这cashierService.checkout()也有一个事务
   * propagation 指定事务的传播行为 即当前事务方法(purchase)被另外一个事务方法(checkout)调用时 如何处理事务
   * REQUIRED 是事务默认的传播行为 即使用调用方法(checkout)现有的事务 (比如买两本书 第一本买成功了,第二本买不成功的时候 两本书都回滚)
   * REQUIRES_NEW 是不使用现有的调用方法的事务(挂起),而使用自己的事务(新的一个事务) (比如买两本书 ,第一本买成功了,第二本买不成功的时候 只回滚第二本不成功的)
   * */
  
  /* 事务的隔离级别:
   * isolation 指定事务的隔离级别
   * READ_COMMITTED 读已提交(最常用的)
   * */
 
  /* 事务的回滚属性:
   * 默认是对运行时异常进行回滚 也可以通过对应的属性进行设置 通常使用默认
   * rollbackFor 对哪些异常回滚
   * noRollbackFor 对哪些异常不回滚 (例: noRollbackFor={UserAccountException.class})
   * */
  
  /* readOnly属性:
   * 指定事务为只读, 表示这个事务只读取数据但不更新数据,可以帮助数据库引擎优化事务.(若真的是一个只读取数据库的方法应设置readOnly=true)
   * */
  
  /* timeout属性:
   * 指定在强制回滚之前事务可以占多长时间,防止事务对连接占用时间过长,以提高运行性能(单位秒)
   * 连接占用时间查出设置,会强制回滚
   * */
  @Transactional(propagation=Propagation.REQUIRED , isolation=Isolation.READ_COMMITTED)
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