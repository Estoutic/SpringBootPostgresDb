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

@Data
@Entity
@NoArgsConstructor
public class BuildProjectEntity {

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

    private String projectName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "project")
    private BuildAddressEntity buildAddressEntity;

    public void addAddress(BuildAddressEntity buildAddressSave){
        buildAddressSave.setProject(this);
        this.buildAddressEntity = buildAddressSave;
    }
}
