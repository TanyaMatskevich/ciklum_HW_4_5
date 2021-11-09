package com.ciklum.ciklumhybristesttask.repo;

import com.ciklum.ciklumhybristesttask.domain.Product;
import com.ciklum.ciklumhybristesttask.dto.OrderedProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    @Query(value = "select distinct p.name as productName, sum(oi.quantity) as totalQuantity from products as p join order_items as oi on p.id = oi.product_id group by p.name", nativeQuery = true)
    List<OrderedProductDto> findOrderedProducts();
}
