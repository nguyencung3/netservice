package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Order;
import com.cvc.netservice.repository.CustomerRepository;
import com.cvc.netservice.repository.OrderRepository;
import com.cvc.netservice.repository.StaffRepository;
import com.cvc.netservice.service.OrderService;
import com.cvc.netservice.service.dto.*;
import com.cvc.netservice.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public Long createOrder(OrderDTO orderDTO) throws Exception {
        Order order = orderMapper.toEntity(orderDTO);
        orderRepository.save(order);
        return orderRepository.findFirstByOrderByIdDesc().getId();
    }

    private RevenueByTypeDTO filterOrderDetail(List<OrderDetailDTO> dtoList, String[] typeFilter, RevenueDetailDTO infoOrder) {
        List<RevenueDetailDTO> detailDTOList = new LinkedList<>();
        Double sumTotalOrder = 0D;
        for (OrderDetailDTO orderDetailDTO : dtoList) {
            if (Arrays.stream(typeFilter).parallel().anyMatch(orderDetailDTO.getTypeOrder().toLowerCase().trim()::contains)) {
                RevenueDetailDTO revenueDetailDTO = new RevenueDetailDTO();
                // Find productName
                revenueDetailDTO.setProductName(orderDetailDTO.getProductName());
                revenueDetailDTO.setCustomerName(infoOrder.getCustomerName());
                revenueDetailDTO.setOrderDate(infoOrder.getOrderDate());

                revenueDetailDTO.setQuantity(orderDetailDTO.getQuantity());
                revenueDetailDTO.setUnitPrice(orderDetailDTO.getUnitPrice());

                sumTotalOrder += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());

                detailDTOList.add(revenueDetailDTO);
            }
        }
        return new RevenueByTypeDTO(detailDTOList, sumTotalOrder);
    }

    private BillDTO sumTotalOrder(List<OrderDetailDTO> dtoList, BillDTO billDTO) {
        Double totalPrice = 0D;

        Double priceDiscount = 0D;

        Double totalPriceDiscounted = 0D;

        for (OrderDetailDTO orderDetailDTO : dtoList) {
            totalPrice += orderDetailDTO.getUnitPrice() * orderDetailDTO.getQuantity();
            totalPriceDiscounted += orderDetailDTO.getUnitPrice()
                    * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            priceDiscount += orderDetailDTO.getUnitPrice()
                    * orderDetailDTO.getQuantity() * (orderDetailDTO.getDiscount());
        }

        billDTO.setPriceDiscount(priceDiscount);
        billDTO.setTotalPrice(totalPrice);
        billDTO.setTotalPriceDiscounted(totalPriceDiscounted);
        return billDTO;
    }

    private RevenueDTO sumTotalOrder(List<OrderDetailDTO> dtoList) {
        Double sumComputer = 0D;
        Double sumFoodDrink = 0D;
        Double sumPromotion = 0D;

        for (OrderDetailDTO orderDetailDTO : dtoList) {
            if (orderDetailDTO.getTypeOrder().toLowerCase().trim().contains("an") ||
                    orderDetailDTO.getTypeOrder().toLowerCase().trim().contains("uong")) {
                sumFoodDrink += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            }

            if (orderDetailDTO.getTypeOrder().toLowerCase().trim().contains("tien")) {
                sumComputer += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            }

            sumPromotion += orderDetailDTO.getUnitPrice()
                    * orderDetailDTO.getQuantity() * orderDetailDTO.getDiscount();
        }

        return new RevenueDTO(sumComputer, sumFoodDrink, sumPromotion);
    }

    private List<OrderDTO> getOrderByDate(LocalDateTime from, LocalDateTime to) {
        return orderRepository.findByOrderDateBetween(from, to).stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public RevenueDTO getRevenueByDate(LocalDateTime dateTime) throws Exception {
        LocalDateTime from = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<OrderDTO> dtoList = getOrderByDate(from, to);

        Timestamp timestamp = Timestamp.valueOf(dateTime);
        Double sumComputer = 0D;
        Double sumFoodDrink = 0D;
        Double sumPromotion = 0D;

        for (OrderDTO orderDTO : dtoList) {
            if (orderDTO.getOrderDetails().size() != 0) {
                RevenueDTO revenueDTO = sumTotalOrder(orderDTO.getOrderDetails());
                sumComputer += revenueDTO.getTotalComputerFee();
                sumFoodDrink += revenueDTO.getTotalFoodDrinkFee();
                sumPromotion += revenueDTO.getTotalPromotionFee();
            }
        }
        return new RevenueDTO(sumComputer, sumFoodDrink, sumPromotion, dateTime.format(formatter));
    }

    @Override
    public RevenueByTypeDTO getRevenueByTypeAndDate(LocalDateTime from, LocalDateTime to, String[] type) throws Exception {
        from = LocalDateTime.of(from.getYear(), from.getMonth(), from.getDayOfMonth(), 0, 0, 0);
        to = LocalDateTime.of(to.getYear(), to.getMonth(), to.getDayOfMonth(), 23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        Double sumTotalOrder = 0D;
        RevenueByTypeDTO totalOrder = new RevenueByTypeDTO();
        List<OrderDTO> orderDTOS = getOrderByDate(from, to);
        for (OrderDTO orderDTO : orderDTOS) {
            //find name customer    orderDTO.getCustomerId();
            RevenueDetailDTO revenueDetailDTO = new RevenueDetailDTO();
            revenueDetailDTO.setOrderDate(orderDTO.getOrderDate().format(formatter));
            revenueDetailDTO.setCustomerName(customerRepository.findNameCustomer(orderDTO.getCustomerId()));

            RevenueByTypeDTO revenue = filterOrderDetail(orderDTO.getOrderDetails(), type, revenueDetailDTO);
            totalOrder.getListRevenue().addAll(revenue.getListRevenue());
            sumTotalOrder += revenue.getTotalRevenue();
        }
        totalOrder.setTotalRevenue(sumTotalOrder);
        return totalOrder;
    }

    @Override
    public List<BillDTO> getBillByDate(LocalDateTime from, LocalDateTime to) throws Exception {
        from = LocalDateTime.of(from.getYear(), from.getMonth(), from.getDayOfMonth(), 0, 0, 0);
        to = LocalDateTime.of(to.getYear(), to.getMonth(), to.getDayOfMonth(), 23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        List<BillDTO> billDTOS = new LinkedList<>();
        List<OrderDTO> orderDTOS = getOrderByDate(from, to);
        for (OrderDTO orderDTO : orderDTOS) {
            BillDTO billDTO = new BillDTO();
            billDTO.setId(orderDTO.getId());
            billDTO.setOrderDate(orderDTO.getOrderDate().format(formatter));
            billDTO.setNameCustomer(customerRepository.findNameCustomer(orderDTO.getCustomerId()));
            billDTO.setNameStaff(staffRepository.findNameStaff(orderDTO.getStaffId()));

            billDTO = sumTotalOrder(orderDTO.getOrderDetails(), billDTO);
            billDTOS.add(billDTO);
        }
        return billDTOS;
    }
}
