/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.entites;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Cart {
   
    private List<artwork> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(artwork item) {
        items.add(item);
    }

    public void removeItem(artwork item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (artwork item : items) {
            total += item.getPrix_artwork();
        }
        return total;
    }

    public int size() {
       return items.size();
    }

    public ObservableList<artwork> getItems() {
    return FXCollections.observableList(items);
}
}
