plugins {
	id("java")
	id("org.springframework.boot") version "2.7.8"
	id("org.liquibase.gradle") version "2.2.0"
	id("jacoco")
}

apply(plugin = "io.spring.dependency-management")




group = "ru.itis"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	//spring
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.security:spring-security-oauth2-resource-server:5.8.3")

	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")

	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
	implementation("org.thymeleaf:thymeleaf-spring5:3.0.15.RELEASE")

	//db
	implementation("org.postgresql:postgresql:42.5.3")

	//lombok
	compileOnly("org.projectlombok:lombok:1.18.24")
	annotationProcessor("org.projectlombok:lombok:1.18.24")

	implementation("org.springframework.boot:spring-boot-starter-websocket")
	//webjars
	implementation("org.webjars:jquery:3.6.0")
	implementation("org.webjars:bootstrap:4.6.0")
	implementation("org.webjars:webjars-locator-core:0.46")
	implementation("org.webjars:stomp-websocket:2.3.4")
	implementation("org.webjars:sockjs-client:1.5.1")


	//test
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.mockito:mockito-junit-jupiter:5.2.0")

	implementation("javax.mail:javax.mail-api:1.6.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
