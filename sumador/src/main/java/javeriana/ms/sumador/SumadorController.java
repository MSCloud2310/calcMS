package javeriana.ms.sumador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumadorController {
    @Autowired
    org.springframework.core.env.Environment environment;

    @GetMapping("/suma")
    public String suma(@RequestParam int a, @RequestParam int b){
        String port =environment.getProperty("local.server.port");
        String response = "Result: "+String.valueOf(a+b)+" -> Microservice running on port: "+port;
        return response;
    }
}
