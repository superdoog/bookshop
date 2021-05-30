import com.lv.mapper.BookMapper;
import com.lv.pojo.Book;
import com.lv.service.BookService;
import com.lv.service.BookServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class Test {
    private final int param;
    private final boolean result;


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private final BookService bookService = new BookServiceImpl();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, true}, {2, true}, {3, true}, {4, true}, {5, true}, {6, false}, {0, false}, {-1, false}
        });
    }

    public Test(int param, boolean result) {
        this.param = param;
        this.result = result;
    }

    @org.junit.Test
    public void test() {
        Book book = mock(Book.class);
        when(book.getStore()).thenReturn(5);
        when(bookMapper.getBookBybid(anyInt())).thenReturn(book);
        Assert.assertEquals(result, bookService.checkStore(1, param));
        Mockito.verify(bookMapper, times(1)).getBookBybid(anyInt());
    }
}
