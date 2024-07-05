package uber.kautilya.kafka.jsonmessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import uber.kautilya.model.User;

@Service
public class KafkaJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    /**
     * Constructor dependency: Spring boot would inject this dependency as only one parameterized constructor
     * @param kafkaTemplate
     */
    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        Message<User> userMessage = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "javaguidesjson")
                .build();

        kafkaTemplate.send(userMessage);
    }
}
