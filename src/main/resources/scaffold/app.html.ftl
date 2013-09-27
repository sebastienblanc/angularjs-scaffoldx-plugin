<!doctype html>
<html lang="en" ng-app="${projectId}">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${projectTitle}</title>
    <link href="styles/topcoat-mobile-light.css" rel="stylesheet" media="screen">
    <link href="styles/main.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="topcoat-navigation-bar bar">
    <div class="topcoat-navigation-bar__item center full">
        <h1 class="topcoat-navigation-bar__title">${projectTitle}</h1>
    </div>
</div>

                    <div id="main" ng-view>

                </div>


</div>
    
    <script src="scripts/vendor/jquery-1.9.1.js"></script>
    <script src="scripts/vendor/angular.js"></script>
    <script src="scripts/vendor/angular-resource.js"></script>
    <script src="scripts/app.js"></script>
    <script src="scripts/filters/startFromFilter.js"></script>
    <script src="scripts/filters/genericSearchFilter.js"></script>
    <script src="scripts/services/locationParser.js"></script>
    <#list entityNames as entityName>
    <script src="scripts/services/${entityName}Factory.js"></script>
    <script src="scripts/controllers/new${entityName}Controller.js"></script>
    <script src="scripts/controllers/search${entityName}Controller.js"></script>
    <script src="scripts/controllers/edit${entityName}Controller.js"></script>
    </#list>
</body>
</html>