package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "captcha_codes")
@Data
public class CaptchaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "time")
    private LocalDateTime dateTimeGeneratedCaptcha;
    @Column(name = "code")
    private String codeOnCaptcha;
    @Column(name = "secret_code")
    private String secretCode;

}
