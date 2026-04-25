package org.checoalfa;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;

import static org.checoalfa.roomservice.Roomservice.*;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Order order = Order.newBuilder()
                .setOrderTime(Timestamp.newBuilder().setSeconds(System.currentTimeMillis()/1000).build())
                .setCost((float) 19.42)
                .putMeals("Arthur",
                        Meal.newBuilder()
                                .setEntree(Entree.newBuilder()
                                        .setType("Cheeseburger")
                                        .addNotes("hold the onion")
                                        .build())
                                .setDrink(Drink.newBuilder()
                                        .setType("Coke")
                                        .setSizeValue(Size.SIZE_MEDIUM_VALUE)
                                        .build())
                                .addSides(Side.newBuilder()
                                        .setType("French Fries")
                                        .setSize(Size.SIZE_LARGE)
                                        .build())
                                .build())
                .build();

        System.out.println(order.toByteString());

        Order o2 = Order.parseFrom(order.toByteArray());
        System.out.println(o2.toString());
    }
}