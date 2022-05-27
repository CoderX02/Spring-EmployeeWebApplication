package company.hsenid.employeewebapplication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        Contact contact = new Contact("Rithika Hettiarachchi", "https://github.com/CoderX02", "rithika.h@hsenidoutsourcing.com");
        return new ApiInfo(
                "EmployeeWebApplication",
                "Demo Sample Project for Hsenid",
                "Version 1.0",
                "Terms of service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

//    public class ApiInfo {
//        public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
//        public static final springfox.documentation.service.ApiInfo DEFAULT;
//        private final String version;
//        private final String title;
//        private final String description;
//        private final String termsOfServiceUrl;
//        private final String license;
//        private final String licenseUrl;
//        private final Contact contact;
//        private final List<VendorExtension> vendorExtensions;
}
