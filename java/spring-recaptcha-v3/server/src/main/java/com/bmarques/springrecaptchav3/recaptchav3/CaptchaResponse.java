package com.bmarques.springrecaptchav3.recaptchav3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaResponse {

    private boolean success;
    @JsonProperty("challenge_ts")
    private LocalDateTime challenge;
    private String hostname;
    @JsonProperty("error-codes")
    private List<String> errorCodes;
    private Double score;
}