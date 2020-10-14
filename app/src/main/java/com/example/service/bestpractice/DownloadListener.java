package com.example.service.bestpractice;

public interface DownloadListener {

    void onProgress (int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();

}
