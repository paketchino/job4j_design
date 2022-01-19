package ru.job4j.isp.menu;

import ru.job4j.isp.menu.compose.ActionItem;

import java.util.ArrayList;
import java.util.List;

public class MultiLV implements Action, ActionItem {

    private List<ActionItem> childList = new ArrayList<>();
    private String name;

    public MultiLV(String name) {
        this.name = name;
    }

    @Override
    public void add(ActionItem item) {
        childList.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ActionItem> getList() {
        return childList;
    }

}
