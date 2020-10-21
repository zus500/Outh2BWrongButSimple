package pl.karwan.oauth2example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("/api")
    public String hello(){
        return "hello";
    }
}
