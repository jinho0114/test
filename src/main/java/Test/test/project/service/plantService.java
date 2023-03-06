package Test.test.project.service;

import Test.test.project.dto.plantDto;
import Test.test.project.entity.plantRepository;

import Test.test.project.entity.plantEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class plantService {
    private final plantRepository plantRepository;

    public Long savePlant(plantDto plantDto) {
        return plantRepository.save(plantDto.toEntity()).getId();
    }
}
