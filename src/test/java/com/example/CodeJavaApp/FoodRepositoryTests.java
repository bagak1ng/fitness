package com.example.CodeJavaApp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.CodeJavaApp.model.Food;
import com.example.CodeJavaApp.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FoodRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FoodRepository repo;

    @Test
    public void testCreateFood() {
        Food food = new Food();
        food.setName("apple");
        food.setCalories(77.55);
        food.setProteins(0.66);
        food.setFat(0.66);
        food.setCarbohydrates(16.17);

        Food savedFood = repo.save(food);

        Food existFood = entityManager.find(Food.class, savedFood.getId());

        assertThat(food.getName()).isEqualTo(existFood.getName());
    }

}