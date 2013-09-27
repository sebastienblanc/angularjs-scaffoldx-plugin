<div class="topcoat-list__container">
    <ul class="topcoat-list list">
        <li ng-repeat="result in searchResults" class="topcoat-list__item">
            <a href="#/${entityName}s/edit/{{result.${entityId}}}">
                <p>{{result.title}}</p>
                <p>{{result.content}}</p>
                <span class="chevron"></span>
            </a>
        </li>
    </ul>
</div>
