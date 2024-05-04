package com.metrodata.ServiceEmploye.Models.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailRequest {
    @NotBlank(message = "Destination email cannot blank")
    @Email(message = "Destination email must be valid")
    private String to;

    @NotBlank(message = "Subject cannot blank")
    private String subject;

    @NotBlank(message = "The body of the email must not be empty")
    private String body;


    private String attachment;


}
