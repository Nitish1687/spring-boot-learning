package com.nitish.repository;

import com.mongodb.client.MongoDatabase;
import com.nitish.model.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class GreetingMessageRepositoryTest {

    @InjectMocks
    private GreetingMessageRepository classUnderTest;

    @Test
    public void shouldRetrieveMongoDataBase() {
        MongoDatabase mongoDb = classUnderTest.getMongoDb();
        assertFalse(mongoDb == null);
    }

    @Test
    public void shouldRetrieveGreetingMessageFromDb() {
        classUnderTest.main(new String[]{});

        List<Greeting> greetingMessage = classUnderTest.getGreetingMessage();

        assertEquals(2, greetingMessage.size());
    }
}