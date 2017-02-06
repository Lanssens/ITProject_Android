package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.Address;

/**
 * Created by Thijs on 15/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public interface AddressCallback {
    void onSuccessAddress(Address address);
    void onAddressError();
}
