package ighorafi.studentservice.repository;

import ighorafi.studentservice.entity.Project;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJECT-SERVICE")
public interface ProjectRestClient {

    @GetMapping("/project/{id}")
    @CircuitBreaker(name = "Project-service",fallbackMethod = "getDefaultProject")
    Project findProjectById(@PathVariable String id);

    default Project getDefaultProject(String id,Exception ex){
        return Project.builder().projectId(id).projectLibelle("not found").build();
    }
}
