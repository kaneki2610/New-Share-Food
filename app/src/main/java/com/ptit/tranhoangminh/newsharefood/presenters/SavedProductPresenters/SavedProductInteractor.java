package com.ptit.tranhoangminh.newsharefood.presenters.SavedProductPresenters;

import android.content.Context;

import com.ptit.tranhoangminh.newsharefood.database.DatabaseHelper;

public class SavedProductInteractor {
    private DatabaseHelper db;
    private LoadSavedProductListener listener;

    public SavedProductInteractor(LoadSavedProductListener listener, Context context) {
        this.listener = listener;
        db = new DatabaseHelper(context);
    }

    public void createSavedProductList() {
        listener.onLoadSavedProductsSuccess(db.getAllProducts());
    }

    public void destroySavedProduct(String id) {
        db.deleteProduct(id);
        db.deleteProductDetail(id);
    }
}
