package Test.test.project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class plantEntity {

    @Id
    @Column
    private Long id;
    @Column
    private String plantName;

    @Builder
    public plantEntity(Long id, String plantName){
        this.id=id;
        this.plantName=plantName;
    }


}
