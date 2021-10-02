package com.example.springtest;

import com.example.springtest.dto.AddProductCommand;
import com.example.springtest.dto.BasketSummary;
import com.example.springtest.dto.Product;
import com.example.springtest.dto.SummaryItem;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BasketService {

    private final com.example.springtest.BasketRepository basketRepository;
    private final com.example.springtest.ProductRepository productRepository;

    public BasketService(com.example.springtest.BasketRepository basketRepository, com.example.springtest.ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    public Long add(AddProductCommand command) {
        com.example.springtest.Basket basket = basketRepository.getBasket(command.getBasketId());
        Product product = productRepository.getProduct(command.getName());
        com.example.springtest.SelectedProduct selectedProduct = product.buildSelectedProduct(command.getQuantity());

        basket.add(selectedProduct);

        return basketRepository.save(basket);
    }

    public BasketSummary summary(Long basketId) {
        com.example.springtest.Basket basket = basketRepository.getBasket(basketId);

        List<com.example.springtest.SelectedProduct> products = basket.products();

        List<SummaryItem> items = products.stream()
                                          .map(com.example.springtest.SelectedProduct::toSummaryItem)
                                          .collect(toList());
        return new BasketSummary(items);
    }
}
