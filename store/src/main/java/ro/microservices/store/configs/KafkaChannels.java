package ro.microservices.store.configs;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaChannels {

	@Input
	SubscribableChannel stockChannel();
	
}
