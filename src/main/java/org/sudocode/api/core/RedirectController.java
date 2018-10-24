package org.sudocode.api.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class exists for when the JS bundles and index.html are in resources/static
 * and is a SPA such as Angular or React.
 */
@Controller
public class RedirectController {

    /**
     * Redirects the path to the index.
     * i.e: typing localhost:8080/projects will redirect to the angular app route 'projects' instead builder going to the error page.
     */
    // https://spring.io/blog/2015/05/13/modularizing-the-client-angular-js-and-spring-security-part-vii#using-ldquo-natural-rdquo-routes
    // https://stackoverflow.com/questions/24837715/spring-boot-with-angularjs-html5mode/44850886#44850886
    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
}
