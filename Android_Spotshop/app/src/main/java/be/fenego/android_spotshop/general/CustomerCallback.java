package be.fenego.android_spotshop.general;

import be.fenego.android_spotshop.models.Customer;

/**
 * Created by Thijs on 1/12/2017.
 */

public interface CustomerCallback {
    void onSuccessCustomer(Customer customer);
    void onError();
}

