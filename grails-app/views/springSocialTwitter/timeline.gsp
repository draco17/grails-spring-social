<html>
<head>
    <title>Tweeter TimeLine</title>
    <meta name='layout' content='main'/>
</head>

<body>

<script src="http://platform.twitter.com/anywhere.js?id=7yWLgCOuQhIpPyffm0o2Vg&v=1" type="text/javascript"></script>
<script type="text/javascript">
    twttr.anywhere(function (T) {
        T(".feed").linkifyUsers();
    });
</script>

<h3>Your Twitter ${timelineName} Timeline</h3>

<h4>Post a tweet</h4>

<form action="${tweetUrl}" method="post">
    <textarea name="message" rows="2" cols="80"></textarea><br/>
    <input type="submit" value="Post Tweet"/>
</form>


<form action="${searchUrl}" method="get">
    <p><input type="text" name="query" value="${query}"/> <input type="submit" value="Search"/></p>
</form>


<ul class="choices">
    <li><g:link controller="twitter" action="timeline" id="home">Home Timeline</g:link></li>
    <li><g:link controller="twitter" action="timeline" id="friends">Friends Timeline</g:link></li>
    <li><g:link controller="twitter" action="timeline" id="user">User Timeline</g:link></li>
    <li><g:link controller="twitter" action="timeline" id="public">Public Timeline</g:link></li>
    <li><g:link controller="twitter" action="timeline" id="mentions">Mentions</g:link></li>
    <li><g:link controller="twitter" action="timeline" id="favorites">Favorites</g:link></li>
</ul>

<div class="feed">
    <ul class="imagedList">
        <g:each in="${timeline}" var="tweet">
            <li class="imagedItem">
                <div class="image">
                    <g:if test="${tweet.profileImageUrl}">
                        <img src="${tweet.profileImageUrl}" align="left"/>
                    </g:if>
                </div>

                <div class="content">
                    <strong><a href="http://twitter.com/${tweet.fromUser}">${tweet.fromUser}</a></strong><br/>
                    ${tweet.text}<br/>
                    <span class="postTime">${tweet.createdAt}</span>
                </div>
            </li>
        </g:each>

    </ul>
</div>

</body>
</html>
