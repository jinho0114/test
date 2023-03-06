package Test.test.project.dto;

import Test.test.project.entity.plantEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class plantDto {

    private Long id;
    private String plantName;

    @Builder
    public plantDto(Long id, String plantName){
        this.id = id;
        this.plantName = plantName;
    }

    public plantEntity toEntity(){
        return plantEntity.builder()
                .id(1L)
                .plantName("123")
                .build();
    }
}
