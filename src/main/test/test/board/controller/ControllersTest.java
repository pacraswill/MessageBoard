package test.board.controller;

import static org.mockito.Mockito.when;
import com.board.controller.UserController;
import com.board.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.unitils.easymock.annotation.Mock;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nobug on 1/17/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")

public class ControllersTest {
    private MockMvc mockMvc;
    @Mock
    private UserService userService;

    @InjectMocks
    UserController userController;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void should_return_success() throws Exception {
        when(userService.login("Allen", "2141314")).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .param("name", "Allen")
                .param("password", "2141314"))
                ;
    }
}
