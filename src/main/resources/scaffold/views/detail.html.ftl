<#assign formName = "${entityName}Form"
        model = "${entityName?uncap_first}">
<header ng-switch on="$location.path().endsWith('/${entityName}s/new')">
    <h3 ng-switch-when="true">Create ${entityName}</h3>
    <h3 ng-switch-when="false">View or edit ${entityName}</h3>
</header>
<form id="${formName}" name="${formName}" class="form-horizontal">
    <div ng-show="displayError" class="alert alert-error">
        <strong>Error!</strong> Something broke. Retry, or cancel and start afresh.
    </div>
    <#list properties as property>
        <#if (property["many-to-one"]!) == "true" || (property["one-to-one"]!) == "true">
        <#include "includes/nToOnePropertyDetail.html.ftl" >
        <#elseif (property["n-to-many"]!) == "true">
        <#include "includes/nToManyPropertyDetail.html.ftl" >
        <#elseif property["lookup"]??>
        <#include "includes/lookupPropertyDetail.html.ftl" >
        <#else>
        <#include "includes/basicPropertyDetail.html.ftl" >
        </#if>
    </#list>

    <div class="bar bottom">
        <div class="settings container">
            <a href="#/"> <img src='img/home.svg' />
            </a>
            <a href="#/Posts"> <img src='img/listview.svg' />
            </a>
            <a id="savesave${entityName}" name="save${entityName}" role="button"
               ng-click="save()" >
                <img src='img/save.svg'/>
            </a>
            <a id="delete" name="delete" role="button"
               ng-click="remove()" >
                <img src='img/delete.svg'/>
            </a>
        </div>
    </div>
</form>