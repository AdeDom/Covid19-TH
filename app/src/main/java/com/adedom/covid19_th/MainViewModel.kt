package com.adedom.covid19_th;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private DefaultCovid19Repository repository = new DefaultCovid19Repository();

    private MutableLiveData<Covid19Response> _covid19 = new MutableLiveData<>();
    private MutableLiveData<Throwable> _error = new MutableLiveData<>();

    LiveData<Covid19Response> covid19() {
        return _covid19;
    }

    LiveData<Throwable> error() {
        return _error;
    }

    void fetchCovid19() {
        repository.fetchCovid19()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Covid19Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Covid19Response covid19Response) {
                        _covid19.setValue(covid19Response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _error.setValue(e);
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
