<h3>Connect to Twitter</h3>

<g:form mapping="springSocialconnect" params="[providerId: 'twitter']" method="POST">
    <div class="formInfo">
        <p>
            You haven't created any connections with Twitter yet. Click the button to connect Spring Social Showcase with your Twitter account.
            (You'll be redirected to Twitter where you'll be asked to authorize the connection.)
        </p>
    </div>

    <p><button type="submit"><img src="twitter/connect-with-twitter.png"/></button>
    </p>
    <label for="postTweet"><input id="postTweet" type="checkbox"
                                  name="postTweet"/> Post a tweet about connecting with Spring Social Showcase</label>
</g:form>