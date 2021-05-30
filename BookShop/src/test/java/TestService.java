import com.lv.mapper.BookMapper;
import com.lv.pojo.Book;
import com.lv.service.BookService;
import com.lv.service.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@ContextConfiguration({
        "classpath*:applicationContext.xml",
        "classpath*:spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestService {

    @Mock
    private BookMapper bookMapper;
    @InjectMocks
    private BookService bookService = new BookServiceImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testService() throws Exception{
        Book book = new Book();
        book.setBid(1);
        book.setBname("MockBook");
        book.setStore(5);
        Mockito.when(bookMapper.getBookBybid(Mockito.anyInt())).thenReturn(book);
        Assert.assertEquals(true,bookService.checkStore(1, 5));
        verify(bookMapper, times(1)).getBookBybid(anyInt());

    }
}
