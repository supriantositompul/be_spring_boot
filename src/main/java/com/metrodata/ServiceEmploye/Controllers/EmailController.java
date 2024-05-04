package com.metrodata.ServiceEmploye.Controllers;

import com.metrodata.ServiceEmploye.Models.dto.Request.EmailRequest;

public interface EmailController {
    EmailRequest sendSimpleMessage(EmailRequest emailRequest);

    EmailRequest sendMessageWithAttachment(EmailRequest emailRequest);
}

