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
package grails.plugins.springsocial

class UserConnection implements Serializable {

    String userId
    String providerId
    String providerUserId
    String displayName
    String profileUrl
    String imageUrl
    String accessToken
    String secret
    String refreshToken
    Long rank
    Long expireTime

    static constraints = {
        userId nullable: false
        providerId nullable: false
        providerUserId nullable: false
        displayName nullable: true
        profileUrl nullable: true
        imageUrl nullable: true
        accessToken nullable: false
        secret nullable: true
        refreshToken nullable: true
        rank nullable: false
        expireTime nullable: true
    }

    static mapping = {
        table "UserConnection"
        version false

        id composite:['userId', 'providerId', 'providerUserId']

        userId column:'userId'
        providerId column:'providerId'
        providerUserId column:'providerUserId'
        displayName column:'displayName'
        profileUrl column:'profileUrl'
        imageUrl column:'imageUrl'
        accessToken column:'accessToken'
        secret column:'secret'
        refreshToken column:'refreshToken'
        rank column:'rank'
        expireTime column:'expireTime'
    }
}