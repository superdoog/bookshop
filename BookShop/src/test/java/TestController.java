import com.lv.controller.CartController;
import com.lv.pojo.Book;
import com.lv.pojo.Cart;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;


@WebAppConfiguration
@ContextConfiguration({
        "classpath*:applicationContext.xml",
        "classpath*:spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)

public class TestController {

    @Autowired
    protected WebApplicationContext wac;

    @InjectMocks
    private CartController controller;


    private MockMvc mockMvc;

    private String url = "/checkStore";

    private String expected = "Test";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);     //使得打上Mock标签的对象被mock，依赖于Mock对象的类自动与Mock对象关联
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();             //整个mvc环境
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();        //加载局部mvc环境、两种方式都可以
    }

    @Test
    public void testController() throws Exception {
        Book book = Mockito.mock(Book.class);
        book.setBid(1);
        book.setBname("MockBook");
        book.setStore(2);
        Cart cart = Mockito.mock(Cart.class);
        HashMap goods = new HashMap<Book, Integer>();
        goods.put(book, 1);
        cart.setGoods(goods);
//        HttpSession session = Mockito.mock(HttpSession.class);
//        session.setAttribute("cart", cart);


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)     //传入的URL，进入对应的Controller        MockMvcRequestBuilders.get(url)
        .sessionAttr("cart",cart))
                // .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

//        Assert.assertEquals(expected, result.getModelAndView().getModel().get("user"));
    }

}
