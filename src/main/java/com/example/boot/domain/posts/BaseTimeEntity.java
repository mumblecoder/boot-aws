package com.example.boot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    // @CreationTimestamp, @UpdateTimestamp 대신 이걸 쓰는 이유는
    // 위 2개는 hibernate의 어노테이션이라서 구현체를 변경할경우 이 어노테이션도 다 변경해줘야 하기 때문이다.
    // 자세한 설명은 https://github.com/jojoldu/freelec-springboot2-webservice/issues/96

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
