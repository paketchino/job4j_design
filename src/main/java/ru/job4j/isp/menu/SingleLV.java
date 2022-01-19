package ru.job4j.isp.menu;

import ru.job4j.isp.menu.compose.ActionItem;

import java.util.ArrayList;
import java.util.List;

public class SingleLV implements Action, ActionItem {

    private List<ActionItem> singleList = new ArrayList<>();

    private String name;

    public SingleLV(String name) {
        this.name = name;
    }

    @Override
    public void add(ActionItem item) {
        if (singleList.size() > 1) {
            throw new IllegalArgumentException();
        }
        singleList.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ActionItem> getList() {
        return singleList;
    }
}
