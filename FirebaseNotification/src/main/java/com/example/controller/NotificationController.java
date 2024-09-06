package com.example.controller;

import com.example.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


class NotificationRequest {
    private String title;
    private String body;
    private String token;
    private String appId;

   
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getAppId() { return appId; }
    public void setAppId(String appId) { this.appId = appId; }
}

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {
        // Use the PushNotificationService to send the notification
        return pushNotificationService.sendNotification(
                request.getTitle(),
                request.getBody(),
                request.getToken(),
                request.getAppId()
        );
    }
}
