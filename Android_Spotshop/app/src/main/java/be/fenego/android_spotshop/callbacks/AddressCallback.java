package be.fenego.android_spotshop.callbacks;

import java.util.List;

import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Country;

/**
 * Created by Thijs on 15/01/2017.
 */

public interface AddressCallback {
    void onSuccessAddress(Address address);
    void onAddressError();
}
