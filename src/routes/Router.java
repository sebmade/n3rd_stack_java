package routes;

import org.k33g.helpers.Groovy;
import org.k33g.helpers.N3rd;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class Router {

    public static void routes() {
        N3rd.about();

        get(new Route("/about") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Application.about(request, response);
            }
        });

        get(new Route("/about.json") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Application.aboutJSON(request, response);
            }
        });

        /* get one Human by id */
        get(new Route("/humans/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Humans.fetch(request, response);
            }
        });

        /* get All Humans */
        get(new Route("/humans") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Humans.getAll(request, response);
            }
        });

        /* create a Human */
        post(new Route("/humans") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Humans.add(request, response);
            }
        });

        /* update a human */
        put(new Route("/humans/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Humans.update(request, response);
            }
        });

        /* delete a human */
        delete(new Route("/humans/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.Humans.delete(request, response);
            }
        });

        //EXPERIMENTAL

        /*--- Groovy Support ---*/
        Groovy.setScriptsPath("groovy");
        try {
            Groovy.iniScriptEngine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*----------------------*/

        get(new Route("/groovy/us") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.GroovyDemo.helloUS(request, response);
            }
        });

        get(new Route("/groovy/fr") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.GroovyDemo.helloFR(request, response);
            }
        });

        /* get All Humans */
        get(new Route("/groovy/humans") {
            @Override
            public Object handle(Request request, Response response) {
                return controllers.GroovyDemo.allHumans(request, response);
            }
        });

    }
}
