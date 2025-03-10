package com.bearhive.bearhive.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "forgot")
public class Forgot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fgid;

    private String otp;
    private LocalDateTime expiredDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public Forgot() {
    }

    public Forgot(String otp, User user, LocalDateTime expiredDate) {
        this.otp = otp;
        this.user = user;
        this.expiredDate = expiredDate;
    }

    public Long getFgid() {
        return fgid;
    }
    public void setFgid(Long fgid) {
        this.fgid = fgid;
    }
    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }
    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiredDate);
    }
}
