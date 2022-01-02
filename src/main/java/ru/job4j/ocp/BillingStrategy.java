package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

enum BillingStrategy {

        // Normal billing strategy (unchanged price)
        NORMAL (a -> a),
        // Strategy for Happy hour (50% discount)
        HAPPY_HOUR (a -> a / 2);

        private final IntUnaryOperator strategy;

        BillingStrategy(IntUnaryOperator strategy) {
            this.strategy = strategy;
        }

        // Use a price in cents to avoid floating point round-off error
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

        // Payment of bill
        public void print() {
            int sum = this.drinks.stream().mapToInt(v -> v).sum();
            System.out.println("Total due: " + sum);
            this.drinks.clear();
        }

        // Set Strategy
        public void setStrategy(BillingStrategy strategy) {
            this.strategy = strategy;
        }
    }

     class StrategyPattern {
        public static void main(String[] arguments) {
            // Prepare strategies
            BillingStrategy normalStrategy    = BillingStrategy.NORMAL;
            BillingStrategy happyHourStrategy = BillingStrategy.HAPPY_HOUR;

            CustomerBill firstCustomer = new CustomerBill(normalStrategy);

            // Normal billing
            firstCustomer.add(100, 1);

            // Start Happy Hour
            firstCustomer.setStrategy(happyHourStrategy);
            firstCustomer.add(100, 2);

            // New Customer
            CustomerBill secondCustomer = new CustomerBill(happyHourStrategy);
            secondCustomer.add(80, 1);
            // The Customer pays
            firstCustomer.print();

            // End Happy Hour
            secondCustomer.setStrategy(normalStrategy);
            secondCustomer.add(130, 2);
            secondCustomer.add(250, 1);
            secondCustomer.print();
        }
    }
