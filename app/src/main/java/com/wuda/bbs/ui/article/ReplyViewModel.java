package com.wuda.bbs.ui.article;

import android.text.Editable;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;

import com.wuda.bbs.logic.NetworkEntry;
import com.wuda.bbs.logic.bean.DetailArticle;
import com.wuda.bbs.logic.bean.WebResult;
import com.wuda.bbs.logic.bean.response.ContentResponse;
import com.wuda.bbs.ui.base.BaseResponseViewModel;
import com.wuda.bbs.utils.networkResponseHandler.WebResultHandler;

import java.util.HashMap;
import java.util.Map;

public class ReplyViewModel extends BaseResponseViewModel {

    DetailArticle repliedArticle;
    String groupId;
    String boardId;

    String content;

    MutableLiveData<String> postResultMutableLiveData;

    public MutableLiveData<String> getPostResultMutableLiveData() {
        if (postResultMutableLiveData == null) {
            postResultMutableLiveData = new MutableLiveData<>();
        }
        return postResultMutableLiveData;
    }

    public void post(){

        String title = "@" + repliedArticle.getAuthor();
        StringBuilder builder = new StringBuilder();
        builder.append(content);
        builder.append("\n【 在 ").append(repliedArticle.getAuthor()).append(" 的大作中提到: 】\n");
        String[] replyContent = repliedArticle.getContent().split("\\\\n");
        builder.append(": ").append(replyContent[0]);


        // board=&reID=0&font=&subject=&Content=&signature=
        Map<String, String> form = new HashMap<>();
        form.put("board", boardId);
        form.put("reID", repliedArticle.getId());
        form.put("groupID", groupId);
        form.put("reToWho", repliedArticle.getAuthor());
        form.put("font", "");
        form.put("subject", title);
        form.put("Content", builder.toString());
        form.put("signature", "");

        NetworkEntry.postArticle(form, new WebResultHandler() {
            @Override
            public void onResponseHandled(ContentResponse<WebResult> response) {
                if (response.isSuccessful()) {
                    postResultMutableLiveData.postValue(response.getContent().getResult());
                } else {
                    errorResponseMutableLiveData.postValue(response);
                }
            }
        });
    }

}
