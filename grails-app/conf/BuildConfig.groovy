grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // from public Maven repositories
        mavenLocal()
        mavenCentral()

        mavenRepo "http://maven.springframework.org/release"
        mavenRepo "http://maven.springframework.org/snapshot"
        mavenRepo "http://maven.springframework.org/milestone"
    }
    dependencies {
        def springSocialVersion = "1.0.0.M3"

        runtime("org.springframework.social:spring-social-core:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-web:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-facebook:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-tripit:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-twitter:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-github:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-gowalla:${springSocialVersion}") { transitive = false }
        runtime("org.springframework.social:spring-social-linkedin:${springSocialVersion}") { transitive = false }

        runtime("org.springframework.security:spring-security-crypto:3.1.0.RC1") { transitive = false }

        runtime("javax.inject:javax.inject:1")

        compile 'org.codehaus.jackson:jackson-mapper-asl:1.7.3'
    }
}
