package ru.itits.restapi.services;

import ru.itits.restapi.dto.ProductDto;
import ru.itits.restapi.models.Product;

import java.util.List;

public interface ProductsService {
  List<Product> getAll();

  Product add(ProductDto product);

  Product update(Long id, ProductDto form);

  void delete(Long id);

  Product get(Long id);
}
