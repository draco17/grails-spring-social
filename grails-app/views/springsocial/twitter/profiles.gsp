<html>
<head>
    <title>Twitter Profiles</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<h3>Your Twitter Friends</h3>

<ul class="imagedList">
    <g:each in="${profiles}" var="profile">
        <li class="imagedItem">
            <div class="image">
                <g:if test="${profile.profileImageUrl}">
                    <img src="${profile.profileImageUrl}" alt="" width="48" height="48" align="left" />
                </g:if>
            </div>

            <div class="content">
                <p><a href="http://twitter.com/${profile.screenName}">${profile.screenName}</a></p>
            </div>
        </li>
    </g:each>

</ul>

</body>
</html>
