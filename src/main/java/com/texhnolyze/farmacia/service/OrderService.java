package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Order;
import com.texhnolyze.farmacia.entities.Prescription;
import com.texhnolyze.farmacia.exceptions.OrderNotFoundException;
import com.texhnolyze.farmacia.exceptions.PrescriptionNotFoundException;
import com.texhnolyze.farmacia.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final Logger  logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        //TODO: Añadir una verificacion en caso que no exista el de la medicina
        logger.info("Info del prescription - {} ", order.toString());
        return orderRepository.save(order);
    }


    public Order getOrder(Long idOrder) { return orderRepository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException("Not found medication"));}

    public List<Order> getAllOrder() {return orderRepository.findAll();}

    public Order updateOrder(Long idOrder, Order order) {
        Optional<Order> notFoundOrder = orderRepository.findById(idOrder);

        Order existOrder = notFoundOrder.get();
        existOrder.setClientId(order.getClientId());
        existOrder.setMedications(order.getMedications());
        existOrder.setStatus(order.getStatus());

        return existOrder;
    }

    public void deleteOrder(Long idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
