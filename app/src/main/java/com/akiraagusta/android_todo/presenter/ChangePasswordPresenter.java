package com.akiraagusta.android_todo.presenter;
import com.akiraagusta.android_todo.interactor.ChangePasswordInteractor;
import com.akiraagusta.android_todo.callback.RequestCallback;
import com.akiraagusta.android_todo.contract.ChangePasswordContract;

public class ChangePasswordPresenter implements ChangePasswordContract.Presenter {
    private ChangePasswordContract.View view;
    private ChangePasswordInteractor interactor;

    public ChangePasswordPresenter(ChangePasswordContract.View view, ChangePasswordInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void savePassword(String[] password) {
        view.startLoading();
        interactor.changePassword(password, new RequestCallback<String>() {
            @Override
            public void requestSuccess(String message) {
                view.changePasswordSuccess(message);
                view.endLoading();
            }

            @Override
            public void requestFailed(String errorMessage) {
                view.showError(errorMessage);
                view.endLoading();
            }
        });
    }
}
