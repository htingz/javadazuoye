package com.zht.spring;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
@MapperScan("com.zht.spring.mapper")
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer()
//    {
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>()
//        {
//            @Override
//            public void customize(ConfigurableWebServerFactory factory)
//            {
//                ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer()
//                {
//                    @Override
//                    public void customize(Connector connector)
//                    {
//                        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//                        // protocol.setMaxConnections(200);
//                        // protocol.setMaxThreads(200);
//                        // protocol.setSelectorTimeout(3000);
//                        protocol.setSessionTimeout(60000);
//                        // protocol.setConnectionTimeout(3000);
//                    }
//                });
//            }
//        };
//    }
}
