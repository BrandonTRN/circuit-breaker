package mx.com.bedutuxtechnology.circuitbreakerexample.utils;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.com.bedutuxtechnology.circuitbreakerexample.config.DummyFeignClientConfig;
import mx.com.bedutuxtechnology.circuitbreakerexample.dto.PostDTO;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/", configuration = DummyFeignClientConfig.class)
public interface DummyFeignClient {

    
/* @RequestMapping(method = RequestMethod.GET, value = "/posts") */
@GetMapping("/posts")
List<PostDTO> getPosts();

/* @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json") */
@GetMapping(value = "posts/{postId}", produces = "application/json")
PostDTO getPostById(@PathVariable("postId") Long postId);


}
