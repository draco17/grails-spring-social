<html>
<head>
    <title>Twitter Messages</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<h3>Your Twitter ${dmListType.capitalize()} Messages</h3>


<g:link controller="springSocialTwitter" action="messages" id="inbox">Messages</g:link>

<g:form controller="springSocialTwitter" action="sendDM" method="POST">
    <p>Send a message:</p>
    <label for="to">To:</label><g:textField name="to"/><br/>
    <g:textArea name="text" rows="2" cols="80"></g:textArea><br/>
    <g:submitButton name="submit" value="Send Message"/>
</g:form>

<g:link controller="springSocialTwitter" action="messages" id="inbox">Messages</g:link>

    <ul class="choices">
    <li><g:link controller="springSocialTwitter" action="messages" id="received">Inbox</g:link></li>
    <li><g:link controller="springSocialTwitter" action="messages" id="sent">Send</g:link></li>
    </ul>


    <div class="feed">
        <ul class="imagedList">
            <g:each in="${directMessages}" var="dm">
                <li class="imagedItem">
                    <div class="image">
                        <g:if test="${dm.sender.profileImageUrl}">
                            <img src="${dm.sender.profileImageUrl}" alt="" align="left" />
                        </g:if>
                    </div>

                    <div class="content">
                        <strong><a href="${dm.sender.url}">${dm.sender.screenName}</a></strong><br/>
                        <span class="dmRecipient">to ${dm.recipient.screenName}"</span><br/>
                        ${dm.text}<br/>
                        <span class="postTime">${dm.createdAt}</span>
                    </div>
                </li>
            </g:each>

        </ul>
    </div>

    </body>
    </html>
