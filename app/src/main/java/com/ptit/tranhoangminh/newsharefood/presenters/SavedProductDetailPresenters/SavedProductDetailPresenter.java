package com.ptit.tranhoangminh.newsharefood.presenters.SavedProductDetailPresenters;

import android.content.Context;

import com.ptit.tranhoangminh.newsharefood.models.ProductDetail;
import com.ptit.tranhoangminh.newsharefood.views.savedProductDetailViews.activities.SavedProductDetailView;

public class SavedProductDetailPresenter implements LoadSavedProductDetailListener {
    private SavedProductDetailView savedProductDetailView;
    private SavedProductDetailInteractor savedProductDetailInteractor;

    public SavedProductDetailPresenter(SavedProductDetailView savedProductDetailView, Context context) {
        this.savedProductDetailView = savedProductDetailView;
        this.savedProductDetailInteractor = new SavedProductDetailInteractor(this, context);
    }

    public void loadSavedProductDetail(String id) {
        savedProductDetailView.showProgress();
        savedProductDetailInteractor.createSavedProductDetail(id);
    }

    @Override
    public void onLoadSavedProductDetailSuccess(ProductDetail productDetail) {
        savedProductDetailView.displayProductDetail(productDetail);
        savedProductDetailView.hideProgress();
    }

    @Override
    public void onLoadSavedProductDetailFailure(String message) {
        savedProductDetailView.displayMessage(message);
        savedProductDetailView.hideProgress();
    }
}

