package com.metrodata.ServiceEmploye.Services;

import com.metrodata.ServiceEmploye.Models.dto.Request.EmailRequest;

public interface EmailServices {
    EmailRequest sendSimpleMessage(EmailRequest emailRequest);
    EmailRequest sendMessageWithAttachment(EmailRequest emailRequest);
}
