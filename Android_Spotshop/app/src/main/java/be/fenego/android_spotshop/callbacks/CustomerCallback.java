package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.Customer;

/**
 * Created by Thijs on 1/12/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public interface CustomerCallback {
    void onSuccessCustomer(Customer customer);
    void onError();
}

