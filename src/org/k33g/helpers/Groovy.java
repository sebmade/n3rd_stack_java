package org.k33g.helpers;

/**
 * User: k33g_org
 * Date: 12/23/12
 * Time: 9:45 PM
 */

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;

public class Groovy {

    public static String getScriptsPath() {
        return groovyScriptsPath;
    }

    public static void setScriptsPath(String groovyScriptsPath) {
        Groovy.groovyScriptsPath = groovyScriptsPath;
    }

    private static String groovyScriptsPath;

    private static GroovyScriptEngine gse = null;

    private static void initGroovyScriptEngine() throws IOException {
        if(gse==null) {
            String absolutePath = (new File(groovyScriptsPath)).getAbsolutePath();
            String[] roots = new String[] { absolutePath };
            gse = new GroovyScriptEngine(roots);
        }
    }

    public static void run(String script, Binding binding) throws IOException, ResourceException, ScriptException {

        initGroovyScriptEngine();
        gse.run(script, binding);
    }
}
