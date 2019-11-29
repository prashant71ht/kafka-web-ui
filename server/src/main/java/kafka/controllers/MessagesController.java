package kafka.controllers;

import kafka.model.Message;
import kafka.model.MessageType;
import kafka.model.Topic;
import kafka.model.UsersBean;
import kafka.service.KafkaMessageService;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {
    @Autowired
    KafkaMessageService kafkaMessageService;

    @Autowired
    private UsersBean usersBean;

    @GetMapping(path ="/messages/{topic}/{partition}/{maxMessagesToReturn}", produces = "application/json")
    public List<Message> getMessages(@PathVariable String topic, @PathVariable int partition,  @PathVariable int maxMessagesToReturn) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        return kafkaMessageService.listMessages( username,  usersBean.getPassword(username),  topic,  partition ,
                maxMessagesToReturn);
    }

}
