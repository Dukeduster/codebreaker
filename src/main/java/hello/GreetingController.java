package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private  final CodeBreaker codeBreaker= new CodeBreaker();

    @CrossOrigin("*")
    @RequestMapping("/codebreaker/guess/{id}")
    public ResponseEntity<Resultado> guess(@PathVariable String id) {
        Resultado resultado = new Resultado();
        //System.out.println("secret: "+secret.getSecret());
        resultado.setResultado(codeBreaker.guesst(id));
        return ResponseEntity.ok().body(resultado);
    }
    @CrossOrigin("*")
    @PostMapping("/codebreaker/guess")
    public ResponseEntity<Resultado> guess(@RequestBody Secret secret) {
        Resultado resultado = new Resultado();
        resultado.setResultado("OK");
        codeBreaker.setSecret(secret.getSecret());
        return ResponseEntity.ok().body(resultado);
    }
}
