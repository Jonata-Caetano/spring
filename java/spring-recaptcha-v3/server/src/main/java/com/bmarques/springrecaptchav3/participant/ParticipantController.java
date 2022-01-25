package com.bmarques.springrecaptchav3.participant;

import com.bmarques.springrecaptchav3.recaptchav3.ReCaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/v1/participant")
public class ParticipantController {

    @Autowired
    private ReCaptchaService reCaptchaService;

    @PostMapping
    public ParticipantEntity save(@RequestBody ParticipantEntity participantEntity,
                                  @RequestHeader("g-recaptcha-response") String recaptchaResponse) throws ForbiddenException {
        final boolean isValidCaptcha = reCaptchaService.validateCaptcha(recaptchaResponse);

        if (!isValidCaptcha) {
            throw new ForbiddenException("User not authenticated");
        }

        return participantEntity;
    }
}
