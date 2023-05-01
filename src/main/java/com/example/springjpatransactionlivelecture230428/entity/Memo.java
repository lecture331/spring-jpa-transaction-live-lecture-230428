package com.example.springjpatransactionlivelecture230428.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "memo")
@EntityListeners(AuditingEntityListener.class)
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
