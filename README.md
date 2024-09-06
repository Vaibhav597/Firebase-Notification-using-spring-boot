# Firebase Notification using Spring Boot

This project demonstrates how to send Firebase notifications using Spring Boot. It includes setting up a notification system with Firebase Cloud Messaging (FCM) and integrating it with a Spring Boot backend.

## Features

- Send notifications using Firebase Cloud Messaging.
- Manage notification payloads with a simple RESTful API.
- Secure handling of service account credentials.

## Getting Started

### Prerequisites

- Java 17
- Spring Boot 3
- Firebase Account and Project Setup

### Setup Instructions

Postman url - 

1. post -https://fcm.googleapis.com/v1/projects/your project id/messages:send

{
  "message": {
    "token":"validated fcm token",
    "notification": {
      "title": "Test Notification",
      "body": "This is a test notification"
    }
  }
}



2. For Storing data in DB 

post - http://localhost:8080/api/notifications/send
{
  "title": "Notification Title",
  "body": "This is the notification body.",
  "token": "validated fcm token",
  "appId": "appilcation id "
}
