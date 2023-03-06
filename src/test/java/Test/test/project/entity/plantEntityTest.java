//package Test.test.project.entity;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//class plantEntityTest {
//    @Autowired
//    plantRepository plantRepository;
//
//    @Test
//    void save() {
//        plantEntity params = plantEntity.builder()
//                .plantName("123")
//                .build();
//        plantRepository.save(params);
//
//    }
//}