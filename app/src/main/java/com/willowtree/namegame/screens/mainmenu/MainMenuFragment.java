package com.willowtree.namegame.screens.mainmenu;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.willowtree.namegame.R;
import com.willowtree.namegame.screens.gamedata.GameDataViewModel;

import java.util.concurrent.TimeUnit;

import androidx.navigation.fragment.NavHostFragment;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    MainMenuViewModel mainMenuViewModel;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainMenuViewModel = ViewModelProviders
                .of(this)
                .get(MainMenuViewModel.class);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_menu_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        if(!mainMenuViewModel.hasData()){
            NavHostFragment.findNavController(this).navigate(R.id.action_goToGameDataLoadFromMainMenu);
        }
    }
}
