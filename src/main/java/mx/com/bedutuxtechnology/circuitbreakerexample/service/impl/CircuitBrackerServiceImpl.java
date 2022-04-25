package mx.com.bedutuxtechnology.circuitbreakerexample.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mx.com.bedutuxtechnology.circuitbreakerexample.dto.PostDTO;
import mx.com.bedutuxtechnology.circuitbreakerexample.service.CircuitBreackerService;
import mx.com.bedutuxtechnology.circuitbreakerexample.utils.DummyFeignClient;

@RequiredArgsConstructor
@Service
public class CircuitBrackerServiceImpl implements CircuitBreackerService {

    
    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitBrackerServiceImpl.class);

    private DummyFeignClient dummyFeignClient;

    @Override
    public List<PostDTO> getPosts() {
        LOGGER.info("entro");
        return dummyFeignClient.getPosts();
    }

    @Override
    public PostDTO getPostById(Long postId) {

        return dummyFeignClient.getPostById(postId);
    }

    
}
