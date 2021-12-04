package com.example.evaluacioncontinua2;

import androidx.fragment.app.Fragment;

public interface NavigationHost {

    void NavigateTo(Fragment fragment, boolean addToBackStack);
}