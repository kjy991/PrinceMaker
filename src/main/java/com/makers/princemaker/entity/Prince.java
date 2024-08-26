package com.makers.princemaker.entity;

import com.makers.princemaker.code.StatusCode;
import com.makers.princemaker.type.PrinceLevel;
import com.makers.princemaker.type.SkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Snow
 */
//@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "prince")
public class Prince {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private PrinceLevel princeLevel;

    @Enumerated(EnumType.STRING)
    private SkillType skillType;

    @Enumerated(EnumType.STRING)
    private StatusCode status;

    private Integer experienceYears;
    private String princeId;
    private String name;
    private Integer age;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public PrinceLevel getPrinceLevel() {
        return princeLevel;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public StatusCode getStatus() {
        return status;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public String getPrinceId() {
        return princeId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
