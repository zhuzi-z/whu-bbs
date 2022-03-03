package com.wuda.bbs.ui.drawer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wuda.bbs.logic.bean.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    MutableLiveData<List<Friend>> friendList;

    public FriendViewModel() {
        friendList = new MutableLiveData<>();
        friendList.setValue(new ArrayList<>());
    }
}