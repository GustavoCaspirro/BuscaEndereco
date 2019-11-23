package br.com.caspirro.fiap.inject.components

import br.com.caspirro.fiap.base.BaseView
import br.com.caspirro.fiap.inject.module.ContextModule
import br.com.caspirro.fiap.inject.module.NetworkModule
import br.com.caspirro.fiap.ui.main.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}







