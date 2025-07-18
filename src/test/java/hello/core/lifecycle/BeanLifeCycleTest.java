package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // configurable을 사용해서 가능
    }


    @Configuration
    static class LifeCycleConfig {

        // @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();

            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }

}
