package uber.kautilya.kafka.jsonmessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import uber.kautilya.model.User;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "javaguidesjson", groupId = "myConsumerGroup")
    public void consume(User user) {
        LOGGER.info("Message Received: {}", user);
    }
}
