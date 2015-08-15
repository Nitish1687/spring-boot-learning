package com.nitish.controlller;

import com.nitish.model.Greeting;
import com.nitish.service.GreetingMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelloController {

    @Autowired
    private GreetingMessageService messageService;

    @RequestMapping(value = "/", method = GET, produces = APPLICATION_JSON_VALUE, consumes = ALL_VALUE)
    public ResponseEntity<List<Greeting>> getHelloMessage() {
        List<Greeting> greetingMessageFromMongoDB = messageService.getGreetingMessageFromMongoDB();
        return new ResponseEntity<>(greetingMessageFromMongoDB, OK);
    }

    @RequestMapping(value = "/add/greeting", method = POST, produces = APPLICATION_JSON_VALUE, consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity addGreetingFor(@RequestBody Collection<Greeting> greetings) {
        messageService.addGreetings((List)greetings);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
