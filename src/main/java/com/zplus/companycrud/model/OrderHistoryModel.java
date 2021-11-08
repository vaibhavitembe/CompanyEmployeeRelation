package com.zplus.companycrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_history")
public class OrderHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer orderHistoryId;

    @Column
    private String productName;

    @Column
    private Double productAmt;

    @Column
    private Double productQuantity;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderModel orderModel;

}
