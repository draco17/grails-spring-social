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
package grails.plugins.springsocial.twitter

import grails.plugins.springsocial.SpringSocialUtils
import javax.inject.Inject
import javax.inject.Provider
import org.springframework.social.twitter.api.TwitterApi

class SpringSocialTwitterController {

    def springSecurityService

    @Inject
    Provider<TwitterApi> twitterApiProvider

    def index = {
        if (isConnected()) {
            def model = ["profile": getTwitterApi().userOperations().getUserProfile()]
            render(view: SpringSocialUtils.config.twitter.page.connectedHome, model: model)
        } else {
            render(view: SpringSocialUtils.config.twitter.page.connect)
        }
    }

    def timeline = {
        def id = params.id ?: "home"
        def tweets
        switch (id) {
            case "home":
                tweets = getTwitterApi().timelineOperations().getHomeTimeline()
                break
            case "friends":
                tweets = getTwitterApi().timelineOperations().getFriendsTimeline()
                break
            case "user":
                tweets = getTwitterApi().timelineOperations().getUserTimeline()
                break
            case "public":
                tweets = getTwitterApi().timelineOperations().getPublicTimeline()
                break
            case "mentions":
                tweets = getTwitterApi().timelineOperations().getMentions()
                break
            case "favorites":
                tweets = getTwitterApi().timelineOperations().getFavorites()
                break
            default:
                tweets = getTwitterApi().timelineOperations().getHomeTimeline()
                break
        }

        render view: SpringSocialUtils.config.twitter.page.timeLine, model: ['timeline': tweets]
    }

    def profiles = {
        def id = params.id ?: "friends"
        def profiles
        switch (id) {
            case "friends":
                profiles = getTwitterApi().friendOperations().getFriends()
                break
            case "followers":
                profiles = getTwitterApi().friendOperations().getFollowers()
                break
        }
        render view: SpringSocialUtils.config.twitter.page.profiles, model: ['profiles': profiles]
    }

    def messages = {
        def dmListType = params.id ?: 'received'
        def directMessages
        switch (dmListType) {
            case 'received':
                directMessages = getTwitterApi().directMessageOperations().getDirectMessagesReceived()
                break
            case 'sent':
                directMessages = getTwitterApi().directMessageOperations().getDirectMessagesSent()
                break
            default:
                directMessages = getTwitterApi().directMessageOperations().getDirectMessagesReceived()
                break
        }

        render view: SpringSocialUtils.config.twitter.page.directMessages, model: ['directMessages': directMessages, 'dmListType': dmListType]
    }

    def trends = {
        def trends = getTwitterApi().searchOperations().getCurrentTrends()
        render view: SpringSocialUtils.config.twitter.page.trends, model: ['trends': trends]
    }

    Boolean isConnected() {
        getTwitterApi()
    }

    private TwitterApi getTwitterApi() {
        twitterApiProvider.get()
    }
}
