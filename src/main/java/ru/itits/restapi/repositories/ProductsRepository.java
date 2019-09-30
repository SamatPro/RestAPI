package ru.itits.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itits.restapi.models.Product;


public interface ProductsRepository extends JpaRepository<Product, Long> {
}
