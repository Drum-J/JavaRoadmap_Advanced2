package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class SiteControllerV6 {

    public void site1(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>SITE 1</h1>");
    }

    public void site2(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>SITE 2</h1>");
    }
}
