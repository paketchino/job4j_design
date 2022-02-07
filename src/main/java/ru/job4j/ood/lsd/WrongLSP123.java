package ru.job4j.ood.lsd;

public class WrongLSP123 {

    /*
    Есть аккаунты людей
     */

    static class Account {

        private String name;

        public int age;

        public Account(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    /*
     Маркет для продаже
     */

    static class OnlineMarket {

        private Account account;

        public OnlineMarket(Account account) {
            this.account = account;
            validate();
        }

        public void setAccount(Account account) {
            validate();
            this.account = account;
        }

        public void validate() {
            if (account.getAge() < 16) {
                throw new IllegalArgumentException("Пользователя меньше 16 лет платеж не может осуществлен");
            }
            if (account.getAge() < 1) {
                throw new IllegalArgumentException("Пользователь без возвраста не может быть зарегистрирован");
            }
        }
    }

    /*
      Предусловие было усилено т.к банк не продает услуги несовершеннолетним
     */

    static class Bank extends OnlineMarket {

        public Bank(Account account) {
            super(account);
        }

        @Override
        public void setAccount(Account account) {
            if (account.getAge() < 18) {
                throw new IllegalArgumentException("Пользователя меньше 18 лет платеж не может осуществлен");
            }
            if (account.getAge() < 1) {
                throw new IllegalArgumentException("Пользователь без возвраста не может быть зарегистрирован");
            }
        }
    }

    /*
     Постусловие, был ослаблен в подклассе также была удалена проверка на возраст, что является постусловием
     чтобы не нарушить оба принципа нужно вписывать все проверки из базового родительского класса
     */
    static class StreetMarket extends OnlineMarket {

        public StreetMarket(Account account) {
            super(account);
        }

        @Override
        public void setAccount(Account account) {
            if (account.getAge() < 12) {
                throw new IllegalArgumentException("Барыги школярам не продают");
            }
        }
    }
}
