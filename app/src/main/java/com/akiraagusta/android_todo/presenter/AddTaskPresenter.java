package com.akiraagusta.android_todo.presenter;

import com.akiraagusta.android_todo.interactor.AddTaskInteractor;
import com.akiraagusta.android_todo.model.Task;
import com.akiraagusta.android_todo.callback.RequestCallback;
import com.akiraagusta.android_todo.contract.AddTaskContract;

public class AddTaskPresenter implements AddTaskContract.Presenter {
    private AddTaskContract.View view;
    private AddTaskInteractor interactor;

    public AddTaskPresenter(AddTaskContract.View view, AddTaskInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void addTask(Task task) {
        view.startLoading();
        interactor.addTask(task, new RequestCallback<String>() {
            @Override
            public void requestSuccess(String message) {
                view.addTaskSuccess(message);
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