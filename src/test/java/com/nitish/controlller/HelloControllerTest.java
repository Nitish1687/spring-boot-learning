package com.nitish.controlller;


import com.nitish.model.Greeting;
import com.nitish.service.GreetingMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

    @InjectMocks
    private HelloController helloController;
    @Mock
    private GreetingMessageService messageService;


    @Test
    public void shouldReturnHelloMessage() {
        when(messageService.getGreetingMessageFromMongoDB()).thenReturn(new ArrayList<Greeting>());
        ResponseEntity<List<Greeting>> helloMessage = helloController.getHelloMessage();
        verify(messageService, times(1)).getGreetingMessageFromMongoDB();
    }
}
