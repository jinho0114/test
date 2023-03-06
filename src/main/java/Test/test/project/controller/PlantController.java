package Test.test.project.controller;

import Test.test.project.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class PlantController {
    private final PlantService PlantService;

    @GetMapping("/test")
    public void write() throws IOException {
        PlantService.start();
    }
}