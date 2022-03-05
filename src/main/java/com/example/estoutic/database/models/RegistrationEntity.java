package com.example.estoutic.database.models;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistrationEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32, updatable = false, nullable = false)
    @EqualsAndHashCode.Exclude
    private String id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime addDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserNameEntity user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    BuildProjectEntity project;

    public void addBuildProject(UserNameEntity userName, BuildProjectEntity buildProjectEntity){
        user = userName;
        project = buildProjectEntity;
        userName.registrations.add(this);
        buildProjectEntity.registrationEntities.add(this);
    }
}
