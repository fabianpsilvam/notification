package com.zebrands.notification.repository;

import com.zebrands.notification.entity.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<TrackingEntity, Integer> {
}
