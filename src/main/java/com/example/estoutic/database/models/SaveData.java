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
public class SaveData {

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
//
//    @OneToMany(
//            fetch = FetchType.EAGER,
//            mappedBy = "dataToSave",
//            cascade = CascadeType.ALL
//    )
//    private List<AdditionalEntity> additionalEntities = new ArrayList<>();

    private String name;


//    public void addAdditional(AdditionalEntity additionalEntity) {
//        additionalEntity.setDataToSave(this);
//        additionalEntities.add(additionalEntity);
//    }
}