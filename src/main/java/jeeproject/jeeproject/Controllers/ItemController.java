package jeeproject.jeeproject.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/api/items")
    public List<Item> GetSomeItems() {
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 100; ++i) {
            items.add(new Item(i, "name_" + i));
        }
        return items;
    }

    public class Item {
        private int id;
        private String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }
    }
}
