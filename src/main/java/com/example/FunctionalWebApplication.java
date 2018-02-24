package com.example;

import com.example.BoardMVC.Board;
import org.apache.catalina.LifecycleException;
import org.json.JSONException;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.ipc.netty.http.server.HttpServer;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


public class FunctionalWebApplication {

    static RouterFunction getRouter() throws JSONException {
        Controller controller = Controller.GetInstance();
        controller.BoardAdd("Gelecek");
        controller.BoardRow_Add(controller.Board_Find(0).getID(),"Filankes");
        controller.BoardRowTask_Add(controller.Board_Find(0).getID(),controller.BoardRow_Find(controller.Board_Find(0).getID(),0).getId(),"Task1");
        controller.BoardRowTask_Add(controller.Board_Find(0).getID(),controller.BoardRow_Find(controller.Board_Find(0).getID(),0).getId(),"Task2");
        controller.BoardAdd("Indi");
        controller.BoardRow_Add(controller.Board_Find(0).getID(),"edirem");
        controller.BoardAdd("Kecmis");
        controller.BoardRow_Add(controller.Board_Find(0).getID(),"edecem");
        controller.BoardAdd("Silinmis");
        //RouterFunction<?> route =
        //        route(GET("/hello-world"),
        //                request -> Response.ok().body(fromObject("Hello World")))
        //                .and(route(GET("/the-answer"),
        //                        request -> Response.ok().body(fromObject(42))));
        return
                route(
                        GET("/board/{id}"), request -> {
                            try {
                                return ok().
                                        body(fromObject(
                                                controller.
                                                        BoardRow_GetAllListString
                                                                (controller.Board_Find(Integer.parseInt(request.pathVariable("id"))).getID())));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return null;
                                }
                        }
                        );
    }

    public static void main(String[] args) throws IOException, LifecycleException, InterruptedException, JSONException {


        //System.out.println(controller.Read(0,0));
        //System.out.println(controller.ReadRowName(0));
        RouterFunction router = getRouter();

        HttpHandler httpHandler = RouterFunctions
                .toHttpHandler(router);

        HttpServer
                .create("localhost", 5478)
                .newHandler(new ReactorHttpHandlerAdapter(httpHandler))
                .block();

        Thread.currentThread().join();
    }
}
