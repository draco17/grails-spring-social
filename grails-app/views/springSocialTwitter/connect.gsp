<html>
<head>
    <title>Connect to Twitter</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>
<h1>Connect to Twitter</h1>


<g:form mapping="springSocialConnect" params="[providerId: 'twitter']" method="POST">
    <div class="formInfo">
        <p>
            You haven't created any connections with Twitter yet. Click the button to connect Spring Social Showcase with your Twitter account.
            (You'll be redirected to Twitter where you'll be asked to authorize the connection.)
        </p>
    </div>

    <p><button type="submit"><img
            src="${createLinkTo(dir: 'images/social/twitter', file: 'connect-with-twitter.png')}"/></button></p>
    <label for="postTweet"><g:checkBox id="postTweet"
                                       name="${grailsApplication.config.twitter.postTweetFlag}"/> Post a tweet about connecting with Grails Social Showcase</label>
</g:form>

</body>
</html>
