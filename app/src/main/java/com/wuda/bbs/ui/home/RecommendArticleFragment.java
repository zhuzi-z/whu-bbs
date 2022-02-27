package com.wuda.bbs.ui.home;

import android.widget.Toast;

import com.wuda.bbs.logic.NetworkEntry;
import com.wuda.bbs.logic.bean.BriefArticle;
import com.wuda.bbs.logic.bean.response.ContentResponse;
import com.wuda.bbs.ui.board.ArticleContainerFragment;
import com.wuda.bbs.utils.networkResponseHandler.RecommendArticleHandler;

import java.util.List;

public class RecommendArticleFragment extends ArticleContainerFragment {

    @Override
    protected void requestArticleFromServer() {

        NetworkEntry.requestRecommendArticle(new RecommendArticleHandler() {
            @Override
            public void onResponseHandled(ContentResponse<List<BriefArticle>> response) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        article_srl.setRefreshing(false);
                    }
                });
                if (response.isSuccessful()) {
                    mViewModel.articleResponse.postValue(response);
                } else {
                    Toast.makeText(getContext(), response.getMassage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}