package com.example;

import com.example.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTest {

    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void errorPathNoBodyWhilePosting () throws Exception{

    mvc.perform(post("/employee"))
            .andExpect(status().isBadRequest());

    }

}
