package com.example.estoutic.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class PhoneNumberEntity {
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userNameEntity", referencedColumnName = "id")
    private UserNameEntity userNameEntity;

    private String phone;


}
