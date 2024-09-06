package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.NotificationData;

public interface NotificationRepository extends JpaRepository<NotificationData, Long> {

}
