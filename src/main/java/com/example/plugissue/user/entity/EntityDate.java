package com.example.plugissue.user.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


//MappedSuperClass를 추가해서 EntityDate 클래스를 다른클래스에서 상속 받게 되면
// 클래스에서는 createdAt 필드와 modifiedAt필드가 추가로 생성
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class EntityDate {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime modifiedAt;
}
