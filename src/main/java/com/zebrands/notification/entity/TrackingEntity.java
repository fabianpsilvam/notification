package com.zebrands.notification.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "tracking")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;

    @Column(name = "user_id")
    private String user;

    @Column
    private String params;
}
