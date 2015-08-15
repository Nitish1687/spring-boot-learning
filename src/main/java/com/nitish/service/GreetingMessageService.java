package com.nitish.service;

import com.nitish.model.Greeting;
import com.nitish.repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingMessageService {

    @Autowired
    private GreetingMessageRepository repository;

    public List<Greeting> getGreetingMessageFromMongoDB() {
        return repository.getGreetingMessage();
    }

    public void addGreetings(List<Greeting> greetings) {
        repository.addGreetingMessageToMongoDb(greetings);
    }
}
