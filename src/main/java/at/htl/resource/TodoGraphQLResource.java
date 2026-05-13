package at.htl.resource;


import at.htl.control.TodoRepository;
import at.htl.entity.Todo;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class TodoGraphQLResource {

    @Inject
    TodoRepository repo;

    @Query("allTodos")
    public List<Todo> getAllTodos() {
        return repo.listAll();
    }
}
