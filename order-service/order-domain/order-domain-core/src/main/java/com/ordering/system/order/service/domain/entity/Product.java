package com.ordering.system.order.service.domain.entity;

import com.ordering.system.domain.entity.BaseEntity;
import com.ordering.system.domain.valueobject.Money;
import com.ordering.system.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {

    private String name;
    private Money price;

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }


    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

}
