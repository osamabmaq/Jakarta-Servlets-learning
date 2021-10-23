<!DOCTYPE html>
<html>
<head>
    <title>Create entry</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Entries are:</h1>
<br/>
<#list entries as entry>
    <h2>${entry.getKey()} [--] ${entry.getValue()}</h2>
</#list>
</body>
</html>