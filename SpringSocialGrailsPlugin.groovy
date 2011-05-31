import grails.plugins.springsocial.SpringSocialUtils
import org.springframework.security.crypto.encrypt.Encryptors
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository
import org.springframework.social.connect.support.ConnectionFactoryRegistry
import org.springframework.social.twitter.connect.TwitterConnectionFactory

class SpringSocialGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "grails-app/i18n/**"
    ]

    // TODO Fill in these fields
    def author = "Domingo Suarez Torres"
    def authorEmail = "domingo.suarez@gmail.com"
    def title = "Spring Social"
    def description = '''\\
Spring Social plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/spring-social"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        //def facebook = new FacebookConnectionFactory(config.facebook.appId, config.facebook.appSecret)
        //def tripit = new TripItConnectionFactory(config.tripit.consumerKey, config.tripit.consumerSecret)
        def config = SpringSocialUtils.config
        def twitterCK = config.twitter.consumerKey ?: ''
        def twitterCS = config.twitter.consumerSecret
        if(!twitterCK) {
            println "[SpringSocial] WARNING: Twitter not configured"
        }

        xmlns context: "http://www.springframework.org/schema/context"
        context.'component-scan'('base-package': "grails.plugins.springsocial.config")


        connectionFactoryLocator(ConnectionFactoryRegistry) {
            //connectionFactories = [twitter, facebook, tripit]
            connectionFactories = [new TwitterConnectionFactory(twitterCK, twitterCS)]
        }

        textEncryptor(Encryptors) { bean ->
            bean.factoryMethod = "noOpText"
        }

        usersConnectionRepository(JdbcUsersConnectionRepository, ref('dataSource'), ref('connectionFactoryLocator'), ref('textEncryptor'))



    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
