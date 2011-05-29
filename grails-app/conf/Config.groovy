/* Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// configuration for plugin testing - will not be included in the plugin zip
 
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'

    warn   'org.mortbay.log'
}


facebook {
    appId = "27d9bcea3c686d1bdaaf597f725ca875"
    appSecret = "0e1037e0edbe4d378c32e2e1a0be77d1"
    postToWallFlag = "postToWall"
}

twitter {
    consumerKey = "VDtfobfXlwpeuCwMEFrU5A"
    consumerSecret = "aZOtwPO0PRy35Qdy94Nk6JAYLhTHVWFTk06RWed0I"
    postTweetFlag = "postTweet"
}

tripit {
    consumerKey = "c67a632af8b7f11fce3dcc82ab9a9c72492bb88b"
    consumerSecret = "10d6501813b0b085b824e5039f6e9bae35e3457c"
}