package br.com.caspirro.fiap.ui.main

import androidx.annotation.StringRes
import br.com.caspirro.fiap.base.BaseView
import br.com.caspirro.fiap.model.Endereco

interface MainView : BaseView {

    fun atualizaEndereco(endereco: Endereco)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}
