plugins {
    java
}

subprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer:3.0.2")
        implementation("org.springframework.cloud:spring-cloud-commons:3.0.2")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2021.1")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config:2021.1")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}









//val applications = listOf(
//        "com.example.register.AccountApplication",
//        "com.example.register.DraftApplication",
//        "com.example.register.LoanApplication",
//        "com.example.register.SettlementApplication"
//)
//
//tasks.register("runApplications") {
//    group = "application"
//    dependsOn(applications.map { "run${it.replace(".", "")}" })
//}
//
//applications.forEach { application ->
//    val applicationType = application.substringAfterLast(".")
//    tasks.register("run$applicationType", JavaExec::class) {
//        mainClass.set(application)
//        classpath = sourceSets.main.get().runtimeClasspath
//    }
//}
//
//docker {
//    springBootApplication {
//        baseImage.set("openjdk:8-alpine")
//    }
//}
//
//tasks.register("docker_account") {
//    doFirst {
//        docker {
//            springBootApplication {
//                mainClassName.set("com.example.register.AccountApplication")
//                images.set(setOf("com.example/account"))
//                ports.set(setOf(8081))
//            }
//        }
//    }
//    finalizedBy("dockerBuildImage")
//}
//
//tasks.register("docker_settlement") {
//    doFirst {
//        docker {
//            springBootApplication {
//                mainClassName.set("com.example.register.SettlementApplication")
//                images.set(setOf("com.example/settlement"))
//                ports.set(setOf(8082))
//            }
//        }
//    }
//    finalizedBy("dockerBuildImage")
//}
//
//tasks.register("docker_loan") {
//    doFirst {
//        docker {
//            springBootApplication {
//                mainClassName.set("com.example.register.LoanApplication")
//                images.set(setOf("com.example/loan"))
//                ports.set(setOf(8083))
//            }
//        }
//    }
//    finalizedBy("dockerBuildImage")
//}
//
//tasks.register("docker_draft") {
//    doFirst {
//        docker {
//            springBootApplication {
//                mainClassName.set("com.example.register.DraftApplication")
//                images.set(setOf("com.example/draft"))
//                ports.set(setOf(8080))
//            }
//        }
//    }
//    finalizedBy("dockerBuildImage")
//}
//
//docker {
//
//}
//
//tasks.named("dockerPushImage") {
//    doFirst {
//        docker {
//            registryCredentials {
//                url.set("http://registry.cn-hangzhou.aliyuncs.com")
//                username.set("codelder")
//                password.set("76y02m29d")
//            }
//        }
//    }
//}
////tasks.register("push_docker") {
////    dependsOn("docker_draft")
////    dependsOn("docker_account")
////    dependsOn("docker_loan")
////    dependsOn("docker_settlement")
////    docker {
////        registryCredentials {
////            url.set("http://registry.cn-hangzhou.aliyuncs.com")
////            username.set("codelder")
////            password.set("76y02m29d")
////        }
////    }
////    finalizedBy("dockerPushImage")
////}



