package at.htl.resource;

import at.htl.control.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

@ApplicationScoped
public class TodoMqttClient {

    @Inject
    TodoRepository repo;

    @Inject
    ObjectMapper mapper;

    @ConfigProperty(name = "mqtt.broker")
    String broker;

    @ConfigProperty(name = "mqtt.topic")
    String topic;

    @Transactional
    void onStart(@Observes StartupEvent event) throws Exception {
        String json = mapper.writeValueAsString(repo.listAll());

        MqttClient client = new MqttClient(broker, MqttClient.generateClientId(), new MemoryPersistence());
        client.connect();
        client.publish(topic, new MqttMessage(json.getBytes()));
        client.disconnect();
    }
}
