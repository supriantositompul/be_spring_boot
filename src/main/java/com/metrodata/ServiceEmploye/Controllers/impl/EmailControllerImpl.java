package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.metrodata.ServiceEmploye.Controllers.EmailController;
import com.metrodata.ServiceEmploye.Models.dto.Request.EmailRequest;
import com.metrodata.ServiceEmploye.Services.impl.ServiceEmailImpl;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailControllerImpl implements EmailController {
    private ServiceEmailImpl serviceEmailImpl;

    // @PostMapping
    // @Override
    // public EmailRequest sendSimpleMessage(@RequestBody EmailRequest emailRequest) {
    //     return serviceEmailImpl.sendSimpleMessage(emailRequest);
    // }

    @PostMapping("/simple")
    @Override
    public EmailRequest sendSimpleMessage(@RequestBody EmailRequest emailRequest) {
        return serviceEmailImpl.sendSimpleMessage(emailRequest);
    }

    @PostMapping("/attach")
    @Override
    public EmailRequest sendMessageWithAttachment(@RequestBody EmailRequest emailRequest) {
        return serviceEmailImpl.sendMessageWithAttachment(emailRequest);
    }
}
