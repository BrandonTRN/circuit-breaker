package mx.com.bedutuxtechnology.circuitbreakerexample.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import mx.com.bedutuxtechnology.circuitbreakerexample.dto.PostDTO;
import mx.com.bedutuxtechnology.circuitbreakerexample.service.CircuitBreackerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class CircuitBreackerController {
    private final CircuitBreackerService circuitBreakerService;

    private static final String NAME_CIRCUIT_BREAKER = "circuitBreakerService";

    @GetMapping(value = "/obtenerPosts", produces = "application/json")
    @CircuitBreaker(name = NAME_CIRCUIT_BREAKER, fallbackMethod = "metodoAResponderEnFallo")
    public ResponseEntity<List<PostDTO>> obtenerPosts() {

        return ResponseEntity.ok().body(circuitBreakerService.getPosts());
    }

    @GetMapping(value = "/seleccionaPost/{pIdPost}", produces = "application/json")
    @CircuitBreaker(name = NAME_CIRCUIT_BREAKER, fallbackMethod = "metodoAResponderEnFallo")
    public ResponseEntity<PostDTO> buscaAlmacen(@PathVariable(value = "pIdPost") Long pIdPost) {
        return ResponseEntity.ok().body(circuitBreakerService.getPostById(pIdPost));
    }

    public ResponseEntity<String> metodoAResponderEnFallo(Exception e){

        return new ResponseEntity<String>("Servicio deshabilitado, intente mas tarde", HttpStatus.SERVICE_UNAVAILABLE);
    }
    
}
