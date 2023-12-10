plugins {
    id("org.springframework.boot") version "2.5.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("com.bmuschko.docker-spring-boot-application") version "9.4.0"
}

docker {
    springBootApplication {
        mainClassName.set("com.example.register.AccountApplication")
        images.set(setOf("registry.cn-hangzhou.aliyuncs.com/codelder/account"))
        baseImage.set("openjdk:8-alpine")
        ports.set(setOf(8081))
    }

    registryCredentials {
        username.set("wangyued@126.com")
        password.set("76y02m29d")
    }
}