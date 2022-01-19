package ru.job4j.isp.menu.compose;

import java.util.List;

public interface ActionItem {

    String getName();

    List<ActionItem> getList();
}
