package com.example.service;

import com.example.model.NotificationData;
import com.example.repo.NotificationRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    @Autowired
    private NotificationRepository repository;

    public String sendNotification(String title, String body, String token, String appId) {
        try {
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();

            Message message = Message.builder()
                    .setToken(token)
                    .setNotification(notification)
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);

           
            NotificationData data = new NotificationData(appId, title, body);
            repository.save(data);

            return "Sent message: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send message";
        }
    }
}
