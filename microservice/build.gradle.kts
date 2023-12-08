plugins {
	id("org.springframework.boot") version "2.7.17"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	application
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	mavenCentral()
}

val applications = listOf(
		"com.example.microservice.AccountApplication",
		"com.example.microservice.DraftApplication",
		"com.example.microservice.LoanApplication",
		"com.example.microservice.SettlementApplication"
)

tasks.register("runApplications") {
	group = "application"
	dependsOn(applications.map { "run${it.replace(".", "")}" })
}

applications.forEach { application ->
	val applicationType = application.substringAfterLast(".")
	tasks.register("run$applicationType", JavaExec::class) {
		mainClass.set(application)
		classpath = sourceSets.main.get().runtimeClasspath
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}