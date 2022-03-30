package ru.job4j.ood.isp;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate action) {
        boolean rsl = false;
        MenuItem menuItem = new SimpleMenuItem(childName, action);
        if (Objects.equals(parentName, ROOT)) {
            rootElements.add(menuItem);
        } else {
            Optional<ItemInfo> findByName = findItem(parentName);
            if (findByName.isPresent() && findItem(childName).isEmpty()) {
                findByName.ifPresent(itemInfo -> itemInfo.menuItem.getChildren().add(menuItem));
            }
        }
        return rsl;
    }


    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<MenuItemInfo> rsl = Optional.empty();
        Optional<ItemInfo> findBy = findItem(itemName);
        if (findBy.isPresent()) {
            ItemInfo itemInfo = new ItemInfo(findBy.get().getMenuItem(), findBy.get().getNumber());
            rsl = Optional.of(new MenuItemInfo(itemInfo.getMenuItem(), itemInfo.getNumber()));
        }
        return rsl;
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new Iterator<MenuItemInfo>() {

            private DFSIterator iterator = new DFSIterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ItemInfo itemInfo = iterator.next();
                return new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> rsl = Optional.empty();
        DFSIterator iterator = new DFSIterator();
        while (iterator.hasNext()) {
            ItemInfo itemInfo = iterator.next();
            if (itemInfo.menuItem.getName().equals(name)) {
                rsl = Optional.of(itemInfo);
                break;
            }
        }
        return rsl;
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate delegate;

        public SimpleMenuItem(String name, ActionDelegate delegate) {
            this.name = name;
            this.delegate = delegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return delegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        public DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                numbers.addLast(String.valueOf(number++).concat("."));
                stack.addLast(item);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new IllegalArgumentException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--).concat(".")));
            }
            return new ItemInfo(current, lastNumber);
        }
    }

    private class ItemInfo {

        MenuItem menuItem;

        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }

        public MenuItem getMenuItem() {
            return menuItem;
        }

        public String getNumber() {
            return number;
        }


        @Override
        public String toString() {
            return "ItemInfo{" + "menuItem=" + menuItem
                    + ", number='" + number + '\'' + '}';
        }
    }
}
