package com.example.plugissue.user.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;


@EntityListeners(AuditingEntityListener.class)
public abstract class UserEntity {

}

