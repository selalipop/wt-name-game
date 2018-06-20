package com.willowtree.namegame.application;

import com.willowtree.namegame.screens.gamedata.GameDataViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBindingModule.class, ApplicationModule.class})
public interface ApplicationComponent {
    void inject(NameGameApplication nameGameApplication);

    void inject(GameDataViewModel gameDataViewModel);
}
