package uber.kautilya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic beanTopic() {
        return TopicBuilder.name("javaguides")
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic beanJsonTopic() {
        return TopicBuilder.name("javaguidesjson")
                .partitions(1)
                .build();
    }
}
