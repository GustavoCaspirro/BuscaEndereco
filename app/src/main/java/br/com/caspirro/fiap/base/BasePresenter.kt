package br.com.caspirro.fiap.base

import br.com.caspirro.fiap.inject.components.DaggerPresenterInjector
import br.com.caspirro.fiap.inject.components.PresenterInjector
import br.com.caspirro.fiap.inject.module.ContextModule
import br.com.caspirro.fiap.inject.module.NetworkModule
import br.com.caspirro.fiap.ui.main.MainPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()
    init {
        inject()
    }
    open fun onViewCreated() {}
    open fun onViewDestroyed() {}
    private fun inject() {
        when (this) {
            is MainPresenter -> injector.inject(this)
        }
    }
}
