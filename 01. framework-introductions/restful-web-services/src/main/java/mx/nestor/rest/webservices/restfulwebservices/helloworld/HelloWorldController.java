package mx.nestor.rest.webservices.restfulwebservices.helloworld;


//REST API

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Nestor";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("Hola Nestor bean");
    }

    // Path Parameters
    // /users/{id}/example/{id}  => /users/2/example/200

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hola Path, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){

        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message", null,"Default Message", locale);

        //return "Hello Nestor v2";
    }

    //1:good.morning.message=Good Morning
//- Example: en - English (Good Morning)
//- Example: nl - Dutch (Goedemorgen)
//- Example: fr - French (Bounjour)
//- Example: de - Deutsch (Guten Morgen)
}
