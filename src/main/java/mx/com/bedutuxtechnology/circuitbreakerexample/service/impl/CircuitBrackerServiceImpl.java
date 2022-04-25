package mx.com.bedutuxtechnology.circuitbreakerexample.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mx.com.bedutuxtechnology.circuitbreakerexample.dto.PostDTO;
import mx.com.bedutuxtechnology.circuitbreakerexample.service.CircuitBreackerService;
import mx.com.bedutuxtechnology.circuitbreakerexample.utils.DummyFeignClient;

@RequiredArgsConstructor
@Service
public class CircuitBrackerServiceImpl implements CircuitBreackerService {

    private final DummyFeignClient dummyFeignClient;

    @Override
    public List<PostDTO> getPosts() {
        return dummyFeignClient.getPosts();
    }

    @Override
    public PostDTO getPostById(Long postId) {
        return dummyFeignClient.getPostById(postId);
    }

    
}
