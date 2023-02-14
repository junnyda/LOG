package io.lcalmsky.app.modules.account.domain.entity;

import io.lcalmsky.app.modules.account.domain.support.ListStringConverter;
import io.lcalmsky.app.modules.account.domain.entity.AuditingEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @ToString
public class Account extends AuditingEntity {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    private boolean isValid;

    private String emailToken;

    private LocalDateTime joinedAt;
    
    private String phonenumber;
    
    private String gender;
    
    private LocalDateTime regdate;
    

    @Embedded
    private Profile profile;

    @Embedded
    private NotificationSetting notificationSetting;

    private LocalDateTime emailTokenGeneratedAt;

    public void generateToken() {
        this.emailToken = UUID.randomUUID().toString();
        this.emailTokenGeneratedAt = LocalDateTime.now();
    }

    public boolean enableToSendEmail() {
        return this.emailTokenGeneratedAt.isBefore(LocalDateTime.now().minusMinutes(5));
    }

    public void verified() {
        this.isValid = true;
        joinedAt = LocalDateTime.now();
    }

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder @Getter @ToString
    public static class Profile {
        private String bio;
        @Convert(converter = ListStringConverter.class)
        private List<String> url;
        private String job;
        private String location;
        private String company;
        @Lob @Basic(fetch = FetchType.EAGER)
        private String image;
    }

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder @Getter @ToString
    public static class NotificationSetting {
        private boolean readingCreatedByEmail;
        private boolean readingCreatedByWeb;
        private boolean readingRegistrationResultByEmail;
        private boolean readingRegistrationResultByWeb;
        private boolean readingUpdatedByEmail;
        private boolean readingUpdatedByWeb;
    }
}