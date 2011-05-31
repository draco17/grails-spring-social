<html>
<head>
    <title>Twitter Trending Topics</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<h3>Trending Topics</h3>

<ul class="imagedList">
    <g:each in="${trends.trends}" var="trend">
        <li class="imagedItem">
            <div class="content">
                <p>${trend.query}</p>
            </div>
        </li>
    </g:each>

</ul>

</body>
</html>
