package com.example.estoutic.database.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class UserNameEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32, updatable = false, nullable = false)
    @EqualsAndHashCode.Exclude
    private String id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime addDate;

    @Generated(GenerationTime.INSERT)
    private Integer serial;

    private String name;

    @OneToMany(
            targetEntity = PhoneNumberEntity.class,
            fetch = FetchType.EAGER,
            mappedBy = "userNameEntity",
            cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumberEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    Set<RegistrationEntity> registrations = new HashSet<>();

    public void addPhone(PhoneNumberEntity phoneNumberEntity) {
        phoneNumberEntity.setUserNameEntity(this);
        phoneNumberEntityList.add(phoneNumberEntity);
    }

}