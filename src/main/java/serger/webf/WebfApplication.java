package serger.webf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import serger.webf.beads.DefaultDemoService;
import serger.webf.beads.DemoService;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WebfApplication implements ApplicationContextInitializer<GenericApplicationContext> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        new SpringApplicationBuilder(WebfApplication.class)
                .initializers(new WebfApplication())
                .build()
                .run();
    }

    @Bean
    public RouterFunction<?> routerFunctionA(final DemoService demoService) {
        RouterFunction<?> route =
                route(GET("/hello-world"),
                        request -> ServerResponse
                                .ok()
                                .bodyValue(demoService.getHello("A"))
                                .log()
                );

        log.info("route A");
        return route;
    }

    @Bean
    public RouterFunction<?> routerFunctionB() {
        RouterFunction<?> route =
                route(GET("/the-answer"),
                        request -> ServerResponse
                                .ok()
                                .bodyValue(42)
                                .log()
                );

        log.info("route B");
        return route;
    }

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean("DemoService",
                DemoService.class,
                () -> new DefaultDemoService(
                        //applicationContext.getBean(NoteCrudRepository.class)
                )
                //, bd -> bd.setAutowireCandidate(true)
        );
        log.info("demoService");
    }
}
