package com.karmanno.german4u.gateway;

import com.karmanno.german4u.model.Message;
import com.karmanno.german4u.transport.MessageTransport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "telegramApiClient", url = "http://localhost:8081/")
public interface TelegramApiClient {
    @RequestMapping(method = RequestMethod.POST, value = "/{botKey}/sendMessage")
    Message sendMessage(@PathVariable String botKey, MessageTransport transport);
}
