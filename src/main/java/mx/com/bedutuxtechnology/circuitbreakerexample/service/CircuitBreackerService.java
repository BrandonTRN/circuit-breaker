package mx.com.bedutuxtechnology.circuitbreakerexample.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import mx.com.bedutuxtechnology.circuitbreakerexample.dto.PostDTO;

public interface CircuitBreackerService {

    List<PostDTO> getPosts();

    PostDTO getPostById(@PathVariable("postId") Long postId);
    
}
