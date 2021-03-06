/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.scaffold.angularjs;

import static org.jboss.forge.scaffold.angularjs.AngularScaffold.SCAFFOLD_DIR;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of utility methods that return collections representing groups of {@link ScaffoldResource}s for further
 * processing.
 * 
 */
public class ResourceProvider {

    static final String INDEX_HTML = "/index.html";

    static final String GLYPHICONS_WHITE_PNG = "/img/glyphicons-halflings-white.png";

    static final String GLYPHICONS_PNG = "/img/glyphicons-halflings.png";

    static final String FORGE_LOGO_PNG = "/img/forge-logo.png";

    static final String ANGULAR_RESOURCE_JS = "/scripts/vendor/angular-resource.js";

    static final String ANGULAR_JS = "/scripts/vendor/angular.js";

    static final String JQUERY_JS = "/scripts/vendor/jquery-1.9.1.js";

    static final String BOOTSTRAP_RESPONSIVE_CSS = "/styles/bootstrap-responsive.css";

    static final String MAIN_CSS = "/styles/main.css";

    static final String BOOTSTRAP_CSS = "/styles/bootstrap.css";

    /**
     * Provides a list of {@link ScaffoldResource}s representing static files that are to be copied upon scaffolding setup.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be copied to.
     * @return A list of {@link ScaffoldResource}s representing static files that are to be copied upon scaffolding setup.
     */
    public static List<ScaffoldResource> getStatics(String targetDir) {
        List<ScaffoldResource> statics = new ArrayList<ScaffoldResource>();
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + BOOTSTRAP_CSS, targetDir + BOOTSTRAP_CSS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + MAIN_CSS, targetDir + MAIN_CSS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + BOOTSTRAP_RESPONSIVE_CSS, targetDir + BOOTSTRAP_RESPONSIVE_CSS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + JQUERY_JS, targetDir + JQUERY_JS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + ANGULAR_JS, targetDir + ANGULAR_JS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + ANGULAR_RESOURCE_JS, targetDir + ANGULAR_RESOURCE_JS));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + FORGE_LOGO_PNG, targetDir + FORGE_LOGO_PNG));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + GLYPHICONS_PNG, targetDir + GLYPHICONS_PNG));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + GLYPHICONS_WHITE_PNG, targetDir + GLYPHICONS_WHITE_PNG));
        return statics;
    }
    
    /**
     * Provides a list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed only once for a
     * scaffold generation run.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be written to.
     * @return A list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed only once for a
     *         scaffold generation run.
     */
    public static List<ScaffoldResource> getGlobalTemplates(String targetDir) {
        List<ScaffoldResource> resources = new ArrayList<ScaffoldResource>();
        resources.add(new ScaffoldResource("index.html.ftl", INDEX_HTML));
        resources.add(new ScaffoldResource("app.html.ftl", targetDir + "/app.html"));
        resources.add(new ScaffoldResource("scripts/app.js.ftl", targetDir + "/scripts/app.js"));
        resources.add(new ScaffoldResource("scripts/services/locationParser.js.ftl", targetDir
                + "/scripts/services/locationParser.js"));
        resources.add(new ScaffoldResource("scripts/filters/genericSearchFilter.js.ftl", targetDir
                + "/scripts/filters/genericSearchFilter.js"));
        resources.add(new ScaffoldResource("scripts/filters/startFromFilter.js.ftl", targetDir
                + "/scripts/filters/startFromFilter.js"));
        return resources;
    }

    /**
     * Provides a list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed for every entity
     * during a scaffold generation run.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be written to.
     * @param entityName The name of the JPA entity
     * @return A list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed for every entity
     *         during a scaffold generation run.
     */
    public static List<ScaffoldResource> getEntityTemplates(String targetDir, String entityName) {
        List<ScaffoldResource> resources = new ArrayList<ScaffoldResource>();
        resources.add(new ScaffoldResource("views/detail.html.ftl", targetDir + "/views/" + entityName
                + "/detail.html"));
        resources.add(new ScaffoldResource("views/search.html.ftl", targetDir + "/views/" + entityName
                + "/search.html"));
        resources.add(new ScaffoldResource("scripts/services/entityFactory.js.ftl", targetDir + "/scripts/services/"
                + entityName + "Factory.js"));
        resources.add(new ScaffoldResource("scripts/controllers/newEntityController.js.ftl", targetDir
                + "/scripts/controllers/new" + entityName + "Controller.js"));
        resources.add(new ScaffoldResource("scripts/controllers/searchEntityController.js.ftl", targetDir
                + "/scripts/controllers/search" + entityName + "Controller.js"));
        resources.add(new ScaffoldResource("scripts/controllers/editEntityController.js.ftl", targetDir
                + "/scripts/controllers/edit" + entityName + "Controller.js"));
        return resources;
    }

}
