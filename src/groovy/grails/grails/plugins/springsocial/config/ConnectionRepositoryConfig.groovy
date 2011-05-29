package grails.grails.plugins.springsocial.config

import java.security.Principal
import javax.inject.Inject
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository

@Configuration
class ConnectionRepositoryConfig {

    @Inject
    private UsersConnectionRepository usersConnectionRepository;

    @Bean
    @Scope(value = "request")
    ConnectionRepository connectionRepository(@Value("#{request.userPrincipal}") Principal principal) {
        if (!principal) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user logged in")
        }
        usersConnectionRepository.createConnectionRepository(principal.getName())
    }
}
