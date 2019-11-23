package br.com.caspirro.fiap.ui.main

import br.com.caspirro.fiap.R
import br.com.caspirro.fiap.base.BasePresenter
import br.com.caspirro.fiap.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainPresenter(mainView: MainView) : BasePresenter<MainView>(mainView) {

    @Inject
    lateinit var enderecoApi: EnderecoAPI
    private var subscription: Disposable? = null

    override fun onViewCreated() {
        super.onViewCreated()
        view.hideLoading()
    }

    fun loadAddress(cep: String) {
        view.showLoading()
        subscription = enderecoApi
            .pesquisar(cep)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { endereco -> view.atualizaEndereco(endereco) },
                { erro -> view.showError(erro.message ?: "Erro") }
            )
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }

}