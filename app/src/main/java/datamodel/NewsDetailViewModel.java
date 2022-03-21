package datamodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsDetailViewModel extends ViewModel {

    public Articles mArticles;
    public MutableLiveData<String> back = new MutableLiveData<String>();

    public NewsDetailViewModel(Articles articles) {
        this.mArticles = articles;
    }

    public void buttonBack() {
        back.setValue("press");
    }
}
