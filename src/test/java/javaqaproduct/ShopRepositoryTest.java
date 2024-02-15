package javaqaproduct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(15, "книга", 1990);
    Product product2 = new Product(5, "тетрадь", 250);
    Product product3 = new Product(25, "тетрадь", 250);

    @Test
    public void testRemove() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(5);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveException() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(10));
    }

    @Test
    public void testAdd() {

        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFinById() {

        repo.add(product1);

        repo.findById(15);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}