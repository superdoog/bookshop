package com.lv.util;

public class Constant {

	public static final String USER_SESSION = "userSession";
	public static final String CART = "cart";

	public static final int BOOK_PAGE_SIZE = 5;
	public static final int USER_PAGE_SIZE = 6;
	public static final int PRODUCT_LIST_PAGE_SIZE = 40;
	public static final int User_ORDER_PAGE_SIZE = 3;
	public static final int ORDER_PAGE_SIZE = 3;
	public static final String UN_DO ="未发货";
	public static final String UN_COMMENT ="待评价";
	public static final String EN_COMMENT ="已评价";

	public static final String[] NoFilter_Pages=new String[]{"/userReg.do","/index.do","/bookView.do","/addGoodsInCart.do"
			,"/removeGoodsFromCart.do","/productList.do",
			"/addBookOrder","/commentPage.do","/addComment.do","/reg.do"
			,"/login.do","/addUserPage.do","/cartPage.do","/productListPage.do"
			,"/oderPage.do","/shoppingResult.do","/mana.do"
			,"/updateUserPage.do","/updatePwdPage.do","/loginCheck.do"
			,"/updateUser.do","/logout.do","/userOrder.do"
			,"/updatePwd.do","/backLogin.do","/cleanCart.do"
			,"/checkStore.do"};
}
