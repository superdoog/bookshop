package com.lv.service;

import com.lv.pojo.Book;
import com.lv.pojo.Cart;

/**
 * @author lv
 */
public interface CartService {

	Cart addGoodsInCart(Book book , int number, Cart cart);

	Cart removeGoodsFromCart(Book book,Cart cart);

	Cart calTotalPrice(Cart cart);

}
