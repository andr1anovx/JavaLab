package com.example.jakarta;
import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    private List<UserData> dataList = new ArrayList<>();

    public void addData(UserData data) {
        dataList.add(data);
    }

    public List<UserData> getDataList() {
        return dataList;
    }

    public void removeData(UserData data) {
        dataList.remove(data);
    }
}
