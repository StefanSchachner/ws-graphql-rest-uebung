package at.htl.resource;

import at.htl.control.TodoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/todos")
public class TodoRestResource {

    @Inject
    TodoRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTodos() {
        return Response.ok(repo.listAll()).build();
    }
}
