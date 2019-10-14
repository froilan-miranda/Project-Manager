package services;

import models.Beer;

import java.util.ArrayList;
import java.util.Arrays;

public class BeerService {

    private static int nextId = 1;

    private ArrayList<Beer> inventory = new ArrayList<>();

    //create
    public Beer create(String name, String brand, String location, int quantity, float price) {
        Beer createdBeer = new Beer(nextId++, name, brand, location, quantity, price);
        inventory.add(createdBeer);
        return createdBeer;
    }

    //read
    public Beer findBeer(int readId) {
        Beer output = null;

        for(Beer b : inventory)
            if (b.getId() == readId) {
                output = b;
                break;
            }

        return output;
    }

    //read all
    public Beer[] findAll() {
        return inventory.toArray(new Beer[inventory.size()]);
    }

    //update

    //delete
    public boolean delete(int id) {
        boolean isDeleted = false;

        for(Beer b : inventory){
            if(b.getId() == id){
                inventory.remove(b);
                isDeleted = true;
                break;
            }
        }

        return isDeleted;
    }

    public int size(){
        return inventory.size();
    }

}
