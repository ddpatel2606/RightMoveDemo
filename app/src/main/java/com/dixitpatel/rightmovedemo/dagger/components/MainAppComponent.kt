package com.dixitpatel.rightmovedemo.dagger.components

import com.dixitpatel.rightmovedemo.dagger.activitybuilder.ActivityBuilder
import com.dixitpatel.rightmovedemo.dagger.modules.CommonAppModule
import com.dixitpatel.rightmovedemo.dagger.modules.NetworkModule
import com.dixitpatel.rightmovedemo.application.MyApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * This is MainAppComponent class where all modules are defined
 * i.e. ActivityModules, CommonAppModule, NetworkModule.
 */
@Singleton
@Component(modules = [  AndroidSupportInjectionModule::class,
                        NetworkModule::class,
                        CommonAppModule::class,
                        ActivityBuilder::class])
interface MainAppComponent : AndroidInjector<MyApplication?>
{
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MyApplication?>

    fun create(): MainAppComponent?
}