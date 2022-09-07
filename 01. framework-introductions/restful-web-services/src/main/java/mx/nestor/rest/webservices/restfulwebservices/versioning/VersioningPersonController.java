package mx.nestor.rest.webservices.restfulwebservices.versioning;

import mx.nestor.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Nestor bean");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Nestor","Monroy II"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Nestor ");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Nestor","Monroy II"));
    }

    @GetMapping(path = "/person/header",  headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Nestor ");
    }

    @GetMapping(path = "/person/header2",  headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Nestor","Monroy II"));
    }


    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json" )
    public PersonV1 getFirstVersionOfPersonRequestAcceptHeader(){
        return new PersonV1("Nestor ");
    }

    @GetMapping(path = "/person/accept2",   produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestAcceptHeader(){
        return new PersonV2(new Name("Nestor","Monroy II"));
    }


}
