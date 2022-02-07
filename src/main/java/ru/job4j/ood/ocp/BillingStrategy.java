package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

enum BillingStrategy {

        NORMAL (a -> a),

        HAPPY_HOUR (a -> a / 2);

        private final IntUnaryOperator strategy;

        BillingStrategy(IntUnaryOperator strategy) {
            this.strategy = strategy;
        }

        int getActPrice(int rawPrice) {
            return this.strategy.applyAsInt(rawPrice);
        }

    }

    class CustomerBill {
        private final List<Integer> drinks = new ArrayList<>();
        private BillingStrategy strategy;

        public CustomerBill(BillingStrategy strategy) {
            this.strategy = strategy;
        }

        public void add(int price, int quantity) {
            this.drinks.add(this.strategy.getActPrice(price * quantity));
        }

        public void print() {
            int sum = this.drinks.stream().mapToInt(v -> v).sum();
            System.out.println("Total due: " + sum);
            this.drinks.clear();
        }

        public void setStrategy(BillingStrategy strategy) {
            this.strategy = strategy;
        }
    }

     class StrategyPattern {
        public static void main(String[] arguments) {
            BillingStrategy normalStrategy    = BillingStrategy.NORMAL;
            BillingStrategy happyHourStrategy = BillingStrategy.HAPPY_HOUR;

            CustomerBill firstCustomer = new CustomerBill(normalStrategy);

            firstCustomer.add(100, 1);

            firstCustomer.setStrategy(happyHourStrategy);
            firstCustomer.add(100, 2);

            CustomerBill secondCustomer = new CustomerBill(happyHourStrategy);
            secondCustomer.add(80, 1);

            firstCustomer.print();


            secondCustomer.setStrategy(normalStrategy);
            secondCustomer.add(130, 2);
            secondCustomer.add(250, 1);
            secondCustomer.print();
        }
    }
