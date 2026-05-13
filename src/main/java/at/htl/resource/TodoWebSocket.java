package at.htl.resource;

import at.htl.control.TodoRepository;
import at.htl.entity.Todo;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.WebSocket;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@WebSocket(path = "/todos-ws")
public class TodoWebSocket {

    @Inject
    TodoRepository repo;

    @OnOpen
    @Transactional
    public List<Todo> onOpen() {
        return repo.listAll();
    }
}
