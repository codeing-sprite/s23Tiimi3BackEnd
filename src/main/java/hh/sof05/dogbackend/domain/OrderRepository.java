package hh.sof05.dogbackend.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByItem(Item item);
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByUser(User user);
}
