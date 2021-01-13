package com.akiraagusta.android_todo.contract;

import com.akiraagusta.android_todo.model.Task;
import com.akiraagusta.android_todo.callback.RequestCallback;

import java.util.List;

public interface EditTaskContract {
    interface View {
        void setTask(Task task);
        void editTaskSuccess(String message);
        void deleteTaskSuccess(String message);
        void shareTask(Task task);
        void showError(String message);
        void startLoading();
        void endLoading();
    }

    interface Presenter {
        void setTask();
        void editTask(Task task);
        void deleteTask();
        void shareTask();
    }

    interface Interactor {
        void requestTask(final RequestCallback<Task> requestCallback);
        void editTask(Task task, RequestCallback<String> requestCallback);
        void deleteTask(RequestCallback<String> requestCallback);
    }
}
