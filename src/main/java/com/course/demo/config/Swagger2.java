package com.course.demo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2 //启用swagger2
/*通过@Configuration注解，让Spring来加载该类配置。再通过@EnableSwagger2注解来启用Swagger2。
再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。s
elect()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
*/
/*启动Spring Boot程序，访问：http://localhost:8080/swagger-ui.html
。就能看到前文所展示的RESTful API的页面
 */
public class Swagger2 {
	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("多数据源作业接口测试")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.course.demo.Controller"))
				//为有ApiOperation的注解的方法生成api文档
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				//添加登录认证 也就是点击Authorize可以输入请求token
				.build().securitySchemes(securitySchemes())
				.securityContexts(securityContexts());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("接口管理平台")
				.description("接口管理及测试")
				.version("1.0")
				.build();
	}
	public List<ApiKey> securitySchemes() {
		return newArrayList(new ApiKey("token", "token", "header"));
	}

	public List<SecurityContext> securityContexts() {
		return newArrayList(SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("^(?!auth).*$")).build());
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("token", authorizationScopes));
	}

}
