package com.nitish.service;

import com.nitish.model.Greeting;
import com.nitish.repository.GreetingMessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreetingMessageServiceTest {

    @InjectMocks
    private GreetingMessageService greetingMessageService;
    @Mock
    private GreetingMessageRepository repository;

    @Test
    public void shouldGetTheGreetingMessageFromRepository() {
        when(repository.getGreetingMessage()).thenReturn(new ArrayList<Greeting>());
        List<Greeting> greetingMessageFromMongoDB = greetingMessageService.getGreetingMessageFromMongoDB();
        verify(repository, times(1)).getGreetingMessage();
    }
}