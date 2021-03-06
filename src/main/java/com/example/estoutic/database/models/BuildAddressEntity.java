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
public class BuildAddressEntity {


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

        private String address;

        @JsonIgnore
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "projectName")
        private BuildProjectEntity project ;

}
