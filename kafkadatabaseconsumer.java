package net.aryaman.springboot;

import net.aryaman.springboot.entity.wikimediadata;
import net.aryaman.springboot.repository.Wikimediarepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service

public class kafkadatabaseconsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkadatabaseconsumer.class);
    private Wikimediarepository wikimediarepository;

    public kafkadatabaseconsumer(Wikimediarepository wikimediarepository) {
        this.wikimediarepository = wikimediarepository;
    }

    @KafkaListener(topics="wikimedia_recentchange",
    groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format(" Event message received -> %s", eventMessage));
        wikimediadata wikimediadata = new wikimediadata();
        wikimediadata.setWikiEventData(eventMessage);
        wikimediarepository.save(wikimediadata);

    }

}
