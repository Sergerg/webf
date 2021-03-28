package serger.webf;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(initializers = WebfApplication.class)
@AutoConfigureWebTestClient
class WebfApplicationTests {

    @Autowired
    private WebTestClient client;

    //@Disabled
    @Test
    void contextLoads() {
        ;
    }

    @Test
    public void theAnswer() throws Exception {
        client.get().uri("/the-answer")//.body(Mono.just("par1"), String.class)
                .exchange().expectStatus().isOk()
                .expectBody(Integer.class).isEqualTo(42);
    }

    @Test
    public void helloWorld() throws Exception {
        client.get().uri("/hello-world")//.body(Mono.just("par1"), String.class)
                .exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, null!");
    }


}
