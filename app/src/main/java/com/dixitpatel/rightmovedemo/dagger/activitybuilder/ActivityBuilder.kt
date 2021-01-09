package com.dixitpatel.rightmovedemo.dagger.activitybuilder

import com.dixitpatel.rightmovedemo.ui.main.MainActivity
import com.dixitpatel.rightmovedemo.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This is Dagger Activity Builder Which activities will be used in app must be add
 * in Dagger Module.
 *
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity?
//
//    @ContributesAndroidInjector(modules = [DetailViewActivityModule::class])
//    abstract fun contributeDetailActivity(): DetailViewActivity?

}